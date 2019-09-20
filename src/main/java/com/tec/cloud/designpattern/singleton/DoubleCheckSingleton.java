package com.tec.cloud.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式-双重校验锁
 *
 * @author tec
 */
public class DoubleCheckSingleton {

    /**
     * 私有的静态成员变量
     */
    private static /*volatile*/ DoubleCheckSingleton instance;

    /**
     * 私有的构造方法
     */
    private DoubleCheckSingleton() {
    }

    /**
     * 公有的静态方法
     */
    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
