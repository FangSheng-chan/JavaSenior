package t10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author fangsheng
 * @date 2021/2/13 下午10:11
 */
public enum Enums {
    A(1, "A相"),
    B(2, "B相"),
    C(3, "C相"),
    A1(4, "A1相"),
    B1(5, "B1相"),
    C1(6, "C1相"),
    NONE(0, "无相别");
    private final int itemValue;
    private final String itemName;

    Enums(int itemValue, String itemName) {
        this.itemValue = itemValue;
        this.itemName = itemName;
    }

    public int getItemValue() {
        return itemValue;
    }

    public String getItemName() {
        return itemName;
    }

    public static Map<Integer, Enums> getValueEnum() {
        return VALUE_ENUM;
    }

    private static final Map<Integer, Enums> VALUE_ENUM =
            Arrays.stream(values())
                    .collect(Collectors.toMap(Enums::getItemValue, Function.identity()));

    public static Map<Integer, Enums> toMap() {
        HashMap<Integer, Enums> map = new HashMap<>();
        Enums[] enums = Enums.values();
        for (Enums anEnum : enums) {
            map.put(anEnum.itemValue, anEnum);
        }
        return map;
    }

    public static Enums getNameByValue(Integer itemValue) {
        return toMap().get(itemValue);
    }
}

