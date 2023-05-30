package com.li.common.exception;

import com.li.common.result.ResultCodeEnum;

public class MyException extends RuntimeException{
    private Integer code;//状态码
    private String message;//描述信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyException(Integer code, String message){
        super(message);
        this.code= code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象/
     */
    public MyException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "MyException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
