package java并发实现原理.chapter06;

/**
 * @author fangsheng
 * @date 2021/6/29 3:31 下午
 */
public class Teacher implements Callback{

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}
