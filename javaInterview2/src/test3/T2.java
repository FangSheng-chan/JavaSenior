package test3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fangsheng
 * @date 2021/3/3 下午3:28
 */
public class T2 {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        Long id = idGenerator.getId();
        System.out.println(id);
    }
}

class IdGenerator {
    AtomicLong aLong = new AtomicLong();

    public Long getId() {
        return aLong.incrementAndGet();
    }
}
