package t12;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/5/12 4:23 下午
 */
public class T2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        School school = new School();
        school.setSchoolName("实验小学");
        school.setStuNums(100);
        Student stu1 = new Student();
        stu1.setAge(20);
        stu1.setName("zhangsan");
        stu1.setSex(new StringBuffer("男"));
        school.setStudent(stu1);
        System.out.println("school: " + school + " school的hashcode:" + school.hashCode() + "  school中stu1的hashcode:" + school.getStudent().hashCode());
        //调用重写的clone方法，clone出一个新的school---s2
        School s2 = school.clone();
//        Student student = new Student();
//        student.setAge(22);
//        s2.setStudent(student);
        System.out.println("s2: " + s2 + " s2的hashcode:" + s2.hashCode() + " s2中stu1的hashcode:" + s2.getStudent().hashCode());
        System.out.println(school.getStudent().getName());
        System.out.println(s2.getStudent().getName());
    }
}
