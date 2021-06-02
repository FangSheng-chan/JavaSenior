package message.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/5/28 11:10 上午
 */
public class MyRequest implements Serializable {
    private static final long serialVersionUID = 7312121892044350003L;
    private String key;
    private Map<String, String> data;
    private long timestamp;

    public MyRequest() {
        data = new HashMap<>();
        timestamp = System.currentTimeMillis();
    }

    public void put(String k, String v) {
        data.put(k, v);
    }

    public void remove(String k) {
        data.remove(k);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        buffer.append("<sent>");
        buffer.append("<key>").append(key).append("</key>");
        buffer.append("<timestamp>").append(timestamp).append("</timestamp>");
        buffer.append("<data>");
        for (String key : data.keySet()) {
            buffer.append("<" + key + ">").append(data.get(key)).append(
                    "</" + key + ">");
        }
        buffer.append("</data>");
        buffer.append("</sent>");
        return buffer.toString();
    }
}
