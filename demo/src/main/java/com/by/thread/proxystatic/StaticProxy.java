package com.by.thread.proxystatic;

/**
 * 静态代理模式
 *      真实对象 与 代理对象 都要实现同一个接口
 *      代理对象要代理真实角色
 * @author bingyi
 */
public class StaticProxy {
    public static void main(String[] args) {

        // 与多线程掉好用方式对比
        new Thread(() -> System.out.println("我爱你")).start();

        // 所谓结婚，就是把你自己给婚庆公司即可
        new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}


/**
 * 真实角色：你自己
 */
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("我结婚啦。。。");
    }
}

/**
 * 代理角色：婚庆公司
 */
class WeddingCompany implements Marry {

    /**
     * 真实的自己
     */
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        // 真实对象调用方法
        this.target.happyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }


}