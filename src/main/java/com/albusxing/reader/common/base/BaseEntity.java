package com.albusxing.reader.common.base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class BaseEntity implements Serializable {

    protected Integer deleteFlag;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
}
