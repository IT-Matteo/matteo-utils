package com.matteo.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * *****************************************************************************
 * <p>
 * 功能名                             ：com.lxgs.activity.utils
 * 系统名                             ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date                     Name                 Reason for Change
 * ------------------  -----------------  ------------------------------------
 * 2018-12-11 13:29       matteo               Created
 */
@Slf4j
@Component
public class RedisUtils {
    /**
     * 锁超时时间，单位（ms）
     */
    private static final Long EXPIRE_TIME = 10000L;

    /**
     * 锁重试超时时间，单位（ms）
     */
    private static final Long RETRY_TIME = 2000L;

    /**
     * 重试间隔时间，单位（ms）
     */
    private static final Long RETRY_INTERVAL = 500L;

    /**
     * 锁值
     */
    private static final String LOCK_VALUE = "NX";

    /**
     * Redis缓存
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取Redis锁
     *
     * @param lockKey 锁Key
     * @return true-拿到锁 false-未拿到锁
     */
    public boolean getLock(String lockKey) {
        return getLock(lockKey, 0, EXPIRE_TIME);
    }

    /**
     * 获取Redis锁，重试1秒，锁超时2秒
     *
     * @param lockKey 锁Key
     * @return true-拿到锁 false-未拿到锁
     */
    public boolean getLockWithRetry(String lockKey) {
        return getLock(lockKey, RETRY_TIME, EXPIRE_TIME);
    }

    /**
     * 获取Redis锁
     *
     * @param lockKey      锁Key
     * @param retryTimeout 重试超时时间
     * @param lockTimeout  锁超时时间
     * @return true-拿到锁 false-未拿到锁
     */
    public boolean getLock(String lockKey, long retryTimeout, long lockTimeout) {
        // 当前时间戳
        long currentTime = System.currentTimeMillis();
        try {
            /*
             * 在重试超时时间内，一直去尝试获取redis锁
             */
            do {
                if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey, LOCK_VALUE)) {
                    // 拿到锁，设置锁失效时间
                    log.info("获取到redis锁");
                    stringRedisTemplate.expire(lockKey, lockTimeout, TimeUnit.MILLISECONDS);
                    return true;
                }
                if (retryTimeout > 0) {
                    log.warn("未拿到Reids锁：{}ms后尝试继续获取", RETRY_INTERVAL);
                    Thread.sleep(RETRY_INTERVAL);
                }
            } while (System.currentTimeMillis() - currentTime < retryTimeout);
        } catch (Exception e) {
            log.error("获取redis锁异常", e);
        }
        log.warn("未能获取到Redis锁");
        return false;
    }

    /**
     * 释放Redis锁
     *
     * @param lockKey 锁Key
     */
    public void releaseLock(String lockKey) {
        if (StringUtils.isNotBlank(lockKey)) {
            stringRedisTemplate.delete(lockKey);
            log.info("释放Redis锁");
        }
    }

}
