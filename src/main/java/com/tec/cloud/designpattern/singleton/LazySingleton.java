package com.tec.cloud.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式-懒汉式
 *
 * @author tec
 */
public class LazySingleton {

    /**
     * 私有的静态成员变量
     */
    private static LazySingleton instance;

    /**
     * 私有的构造方法
     */
    private LazySingleton() {

    }

    /**
     * 公有的静态方法
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 公有的静态方法
     *
     * @return
     */
    public static LazySingleton heavyGetInstance() {
        if (instance == null) {
            // 模拟消耗时间和资源的创建过程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 内存可见的私有的静态成员变量
     */
    private static volatile LazySingleton safeInstance;

    /**
     * 线程安全的公有的静态方法
     *
     * @return
     */
    public static synchronized LazySingleton safeGetInstance() {
        if (safeInstance == null) {
            // 模拟消耗时间和资源的创建过程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safeInstance = new LazySingleton();
        }
        return safeInstance;
    }
}
