package com.tec.cloud.designpattern.singleton;

/**
 * 单例模式-静态内部类
 *
 * @author tec
 */
public class StaticInnerClassSingleton {

    /**
     * 私有的构造方法
     */
    private StaticInnerClassSingleton() {
    }

    /**
     * 私有的静态内部类
     */
    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    /**
     * 公有的静态方法
     * @return
     */
    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.instance;
    }
}
