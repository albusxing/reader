package com.albusxing.reader.common.base;

import com.albusxing.reader.common.constant.ResultCodeEnum;

/**
 * 通用返回结构
 * @param <T>
 */
public class BaseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public BaseResult() {
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResult<T> success(T data, String message) {
        return new BaseResult<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> BaseResult<T> fail() {
        return new BaseResult<T>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMessage());
    }

    public static <T> BaseResult<T> fail(String message) {
        return new BaseResult<T>(ResultCodeEnum.FAIL.getCode(), message);
    }

}
