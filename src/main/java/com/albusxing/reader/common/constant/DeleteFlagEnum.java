package com.albusxing.reader.common.constant;

public enum DeleteFlagEnum {

    NORMAL(0, "正常"),
    DELETED(1, "删除");

    private int code;
    private String desc;

    DeleteFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}


