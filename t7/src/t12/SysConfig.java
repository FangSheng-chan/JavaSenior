package t12;

/**
 *
 * 单列模式的使用场景：需要频繁的进行创建和销毁的对象，工具类对象，频繁访问数据库或文件的对象
 *
 * @author fangsheng
 * @date 2021/5/13 10:12 上午
 */
public class SysConfig {

    /**
     * 饿汉式
     */
    public static final SysConfig instance = new SysConfig();

    private SysConfig() {
        get();
    }

    public static SysConfig getInstance() {
        return instance;
    }

    private void get(){
        System.out.println("get SysConfig....");
    }
}
