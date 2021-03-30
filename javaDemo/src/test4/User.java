package test4;

/**
 * @author fangsheng
 * @date 2021/3/9 下午2:12
 */
public class User {
    private String name;
    private String id;
    private Integer age;

    public User(String name, String id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
