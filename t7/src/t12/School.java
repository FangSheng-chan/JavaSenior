package t12;

/**
 * @author fangsheng
 * @date 2021/5/13 2:31 下午
 */
public class School implements Cloneable {
    private String schoolName;
    private int stuNums;
    private Student student;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getStuNums() {
        return stuNums;
    }

    public void setStuNums(int stuNums) {
        this.stuNums = stuNums;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected School clone() throws CloneNotSupportedException {
        return (School) super.clone();
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", stuNums=" + stuNums +
                ", student=" + student +
                '}';
    }
}
