package test5;

/**
 * @author fangsheng
 * @date 2021/4/22 下午2:34
 */
public enum Week {

    SUN(0, "星期日"), MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THE(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六");

    public final int dayValue;
    private final String chinese;

    Week(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}