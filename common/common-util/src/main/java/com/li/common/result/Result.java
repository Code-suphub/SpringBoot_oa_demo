package com.li.common.result;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;//状态码
    private String message;//返回信息，成功/失败
    private T data;// 数据

    //构造私有化，单例
    private Result(){}


    //封装数据
    public static <T> Result<T> built(T body, ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        if(body !=null){
            result.setData(body);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }


    //返回成功的方法
    public static <T> Result<T> ok(){
        return built(null,ResultCodeEnum.SUCCESS);
    }

    //返回成功有数据
    public static <T> Result<T> ok(T data){
        return built(data, ResultCodeEnum.SUCCESS);
    }

    //失败
    public static <T> Result<T> fail(){
        return built(null,ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail(T data){
        return built(data,ResultCodeEnum.FAIL);
    }

    // 有的时候提供的枚举类的返回结果可能会有点问题，所以进行自定义消息和状态码的设置
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
