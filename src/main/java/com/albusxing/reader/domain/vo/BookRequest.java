package com.albusxing.reader.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BookRequest implements Serializable {

    private Long bookId;
    private String title;
    private String coverImg;
    private String author;
    private String press;
    private LocalDate publishDate;
    private String isbn;
    private String desc;
    private Double price;

}
