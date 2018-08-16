package com.matteo.vo;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.matteo.matteo.util
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2018/8/15      matteo                 Created
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    private final C c;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    public C getC() {
        return c;
    }
}
