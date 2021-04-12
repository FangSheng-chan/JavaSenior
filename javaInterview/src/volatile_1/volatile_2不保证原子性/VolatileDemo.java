package volatile_1.volatile_2不保证原子性;

/**
 * @author fangsheng
 * @date 2021/4/7 下午4:45
 */

/**
 * 假设是主物理内存
 */
class MyData{
    int number = 0;

    public void addTo60(){
        this.number = 60;
    }
}

public class VolatileDemo {

}
