package com.tec.cloud.designpattern.singleton;

/**
 * 单例模式-枚举
 *
 * @author tec
 */
public enum EunmSingleton {

    INSTANCE;

    /**
     * 这个方法有点多余，但是基于封装的思想……
     * @return
     */
    public static EunmSingleton getInstance() {
        return INSTANCE;
    }
}
