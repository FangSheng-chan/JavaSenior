package t1;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author fangsheng
 * @date 2021/1/20 5:05 下午
 */
public class t1 {
    @Test
    public void test1() {
        File file = new File(getPath() + "1.txt");
        System.out.println(file);
    }

    public static String getPath() {
        return t1.class.getResource("/").getPath();
    }

    @Test
    public void test2() {
        List<AlarmTableConditionModel> list = new ArrayList<AlarmTableConditionModel>();
        list.add(new AlarmTableConditionModel("ss", "0"));
        list.add(new AlarmTableConditionModel("dd", "0"));
        list.add(new AlarmTableConditionModel(null, "0"));
        System.out.println(list);
//        for (AlarmTableConditionModel alarmTableConditionModel : list) {
//            String name = alarmTableConditionModel.getName();
//            if (name != null) {
//                alarmTableConditionModel.setAge("1");
//            }
//            System.out.println(alarmTableConditionModel);
//        }
    }
    
    @Test
    public void test02(){
    }
}
