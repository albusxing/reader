package com.albusxing.reader.domain.entity;

import com.albusxing.reader.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("r_book")
public class Book extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    private String coverImg;
    private String author;
    private String press;
    private LocalDate publishDate;
    private String isbn;
    private String desc;
    private Double price;


}
