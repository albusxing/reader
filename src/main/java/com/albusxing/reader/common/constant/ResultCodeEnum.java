package com.albusxing.reader.common.constant;
/**
 * 返回码
 */
public enum ResultCodeEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
