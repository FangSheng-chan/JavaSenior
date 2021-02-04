package com.ss.t8.config;

/**
 * @author fangsheng
 * @date 2021/1/25 4:41 下午
 */
public class CommonException extends RuntimeException{
    protected String status;
    protected String message;

    public CommonException() {}

    public CommonException(String status, String msg) {
        this.status = status;
        this.message = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
