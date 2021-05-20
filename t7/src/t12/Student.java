package t12;

/**
 * @author fangsheng
 * @date 2021/5/13 2:29 下午
 */
public class Student {
    private String name;
    private int age;
    private StringBuffer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StringBuffer getSex() {
        return sex;
    }

    public void setSex(StringBuffer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
