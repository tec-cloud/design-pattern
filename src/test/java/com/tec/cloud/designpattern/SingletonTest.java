package com.tec.cloud.designpattern;

import com.tec.cloud.designpattern.singleton.DoubleCheckSingleton;
import com.tec.cloud.designpattern.singleton.HungrySingleton;
import com.tec.cloud.designpattern.singleton.LazySingleton;
import com.tec.cloud.designpattern.singleton.StaticInnerClassSingleton;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * 单例模式-测试类
 */
public class SingletonTest {

    /**
     * 饿汉式
     */
    @Test
    public void testHungrySingleton() {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        assertEquals(hungrySingleton1, hungrySingleton2);
    }

    /**
     * 懒汉式
     */
    @Test
    public void testLazySingleton1() {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        assertEquals(lazySingleton1, lazySingleton2);
    }

    /**
     * 懒汉式-多线程
     */
    @Test
    public void testLazySingleton2() {
        int threadNum = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int c = 0; c < threadNum; c++) {
            executorService.execute(() -> {
                // com.tec.cloud.designpattern.singleton.LazySingleton@44b1dbe8
                // com.tec.cloud.designpattern.singleton.LazySingleton@593461e8
                System.out.println(LazySingleton.heavyGetInstance());
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }
    }

    /**
     * 懒汉式-多线程下使用synchronizsed的性能
     */
    @Test
    public void testLazySingleton3() {

        int threadNum = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();
        for (int c = 0; c < threadNum; c++) {
            executorService.execute(() -> {
                System.out.println(LazySingleton.safeGetInstance());
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }
        // TODO 使用Benchmark比较多线程执行时，添加synchronized的损耗 消耗的时间：1098
        System.out.println(System.currentTimeMillis() - startTime);
    }

    /**
     * 双重校验锁
     */
    @Test
    public void testDoubleCheckSingleton1() {
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        assertEquals(doubleCheckSingleton1, doubleCheckSingleton2);
    }

    /**
     * 双重校验锁- TODO 创建实例时，发生指令重排
     *
     *     1.申请内存空间
     *
     *     2.初始化默认值
     *
     *     3.执行构造器初始化
     *
     *     4.将instance指向创建的对象
     */
    @Test
    public void testDoubleCheckSingleton2() {

        int threadNum = 500;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int c = 0; c < threadNum; c++) {
            executorService.execute(() -> {
                System.out.println(DoubleCheckSingleton.getInstance());
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }
    }


    @Test
    public void testStaticInnerClassSingleton() {
        StaticInnerClassSingleton staticInnerClassSingleton1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton staticInnerClassSingleton2 = StaticInnerClassSingleton.getInstance();
    }
}
