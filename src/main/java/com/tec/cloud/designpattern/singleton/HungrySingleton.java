package com.tec.cloud.designpattern.singleton;

/**
 * 单例模式-饿汉式
 * @author tec
 */
public class HungrySingleton {

    /**
     * 私有的静态成员变量
     */
    private static HungrySingleton instance = new HungrySingleton();

    /**
     * 私有的构造方法
     */
    private HungrySingleton() {
    }

    /**
     * 公有的静态方法
     *
     * @return
     */
    public static HungrySingleton getInstance() {
        return instance;
    }
}
