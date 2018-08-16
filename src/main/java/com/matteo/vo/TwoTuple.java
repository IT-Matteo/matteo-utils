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
public class TwoTuple<A, B> {
    private final A a;
    private final B b;

    TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}
