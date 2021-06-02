package t13;

/**
 * @author fangsheng
 * @date 2021/5/28 3:49 下午
 */
public class T2 {
    public static void main(String[] args) {
        System.out.println(getMappingedCmdIdByOriginalCmdId("21670575783162900"));
    }

    static String cable_burglar_alarm_type = "87";

    public static String getMappingedCmdIdByOriginalCmdId(String originalCmdId) {
        String deviceType = originalCmdId.substring(13, 15);
        String cmdBeforeName = originalCmdId.substring(0, 15);
        String mappingedCmdId = "";
        if (deviceType.equals(cable_burglar_alarm_type)) {// 电缆防盗
            mappingedCmdId = cmdBeforeName + "00";
        } else {
            mappingedCmdId = cmdBeforeName + "01";// 默认返回a相
        }
        return mappingedCmdId;
    }
}
