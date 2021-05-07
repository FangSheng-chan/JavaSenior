package test2;

/**
 * @author fangsheng
 * @date 2021/3/5 下午4:30
 */

public class TestThrow {
    public static void main(String[] args) {
        try {
            //调用带throws声明的方法，必须显式捕获该异常
            //否则，必须在main方法中再次声明抛出
            throwChecked(-3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //调用抛出Runtime异常的方法既可以显式捕获该异常，
        //也可不理会该异常
        throwRuntime(-3);
    }

    public static void throwChecked(int a) throws Exception {
        if (a > 0) {
            //自行抛出Exception异常
            //该代码必须处于try块里，或处于带throws声明的方法中
            throw new Exception("throwChecked方法，a的值大于0，不符合要求");
        }
    }

    public static void throwRuntime(int a) {
        if (a > 0) {
            //自行抛出RuntimeException异常，既可以显式捕获该异常
            //也可完全不理会该异常，把该异常交给该方法调用者处理
            throw new RuntimeException("throwRuntime方法，a的值大于0，不符合要求");
        }
    }
}