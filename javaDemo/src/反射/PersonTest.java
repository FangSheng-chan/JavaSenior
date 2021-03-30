package 反射;

/**
 * @author fangsheng
 * @date 2021/3/18 下午6:06
 */

/**
 * 静态代理举例
 */
interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 */
public class PersonTest implements ClothFactory {

    private ClothFactory clothFactory;

    public PersonTest() {
    }

    public PersonTest(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("造纸厂开始做一些准备工作");

//        clothFactory.produceCloth();

        System.out.println("造纸厂做一些收尾工作");
    }
}

/**
 * 被代理类
 */
class NeckTest implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("造纸厂计划生产一批卫生纸");
    }
}

class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory factory = new NeckTest();

        ClothFactory proxyPaperFactor = new PersonTest(factory);

        proxyPaperFactor.produceCloth();
    }
}
