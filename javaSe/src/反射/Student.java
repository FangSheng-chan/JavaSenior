package 反射;

/**
 * @author fangsheng
 * @date 2021/3/18 下午3:00
 */
public class Student extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    public Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    private void show(String name, int age) {
        System.out.println("你好，我是😊" + name + age);
    }

    public void show() {
        System.out.println("你好，我是😊");
    }

    public void method(String ... strings){

    }

    public String showCoolBoy(String name, int age) {
        System.out.println(name + "\t他真是一个cool boy,他的年龄是：" + age);
        return name;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("info 就是我们的信息");
    }
}