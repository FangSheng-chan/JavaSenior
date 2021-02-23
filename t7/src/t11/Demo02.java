package t11;

/**
 * @author fangsheng
 * @date 2021/2/22 下午2:16
 */
public class Demo02 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
    }

    static class Person {
        private int age;
        private String name;

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
