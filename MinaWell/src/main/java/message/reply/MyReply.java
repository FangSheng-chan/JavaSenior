package message.reply;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务器发送消息对象
 *
 * @author fangsheng
 * @date 2021/5/28 11:23 上午
 */
public class MyReply implements Serializable {
    private static final long serialVersionUID = 21759818375838690L;
    /**
     * 请求key
     */
    private String key;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回说明
     */
    private String message;
    /**
     * 返回数据集合
     */
    private Map<String, String> data;
    private long timestamp;

    public MyReply() {
        data = new HashMap<>();
        timestamp = System.currentTimeMillis();
    }

    public void put(String k, String v) {
        data.put(k, v);
    }

    public String get(String key) {
        return data.get(key);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        StringBuilder buffer = new StringBuilder();
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        buffer.append("<reply>");
        buffer.append("<key>").append(this.getKey()).append("</key>");
        buffer.append("<timestamp>").append(timestamp).append("</timestamp>");
        buffer.append("<code>").append(code).append("</code>");
        buffer.append("<message>").append(message).append("</message>");
        buffer.append("<data>");
        for (String key : this.getData().keySet()) {
            buffer.append("<" + key + ">").append(this.get(key)).append("</" + key + ">");
        }
        buffer.append("</data>");
        buffer.append("</reply>");
        return buffer.toString();
    }

    public String toJson() {
        return JSON.toJSONString(MyReply.class);
    }
}









