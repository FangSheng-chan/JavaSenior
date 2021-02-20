package t10;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/2/4 下午4:41
 */
public class t2 {

    public static void main(String[] args) {
        Enums[] values = Enums.values();
        Map<Integer, Enums> valueEnum = Enums.toMap();
        for (Map.Entry<Integer, Enums> entry : valueEnum.entrySet()) {
            Enums value = entry.getValue();
            System.out.println(value.getItemName());
            System.out.println(value.getItemValue());
        }
        System.out.println("-------");
        Enums value = Enums.getNameByValue(1);
        System.out.println(value.getItemName());
//        ArrayList<Object> list = new ArrayList<>();
//        list.get()
//        valueEnum.get()
    }
}
