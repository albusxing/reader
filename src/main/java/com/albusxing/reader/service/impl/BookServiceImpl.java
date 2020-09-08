package com.albusxing.reader.service.impl;

import com.albusxing.reader.domain.entity.Book;
import com.albusxing.reader.mapper.BookMapper;
import com.albusxing.reader.service.BookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    @Override
    public List<Book> listBook(String name, Page<Book> page) {
        return null;
    }
}
