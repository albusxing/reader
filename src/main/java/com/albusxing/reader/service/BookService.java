package com.albusxing.reader.service;

import com.albusxing.reader.domain.entity.Book;
import com.albusxing.reader.domain.vo.BookRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BookService extends IService<Book> {

    List<Book> listBook(String name, Page<Book> page);

    boolean saveOrUpdate(BookRequest bookRequest);
}
