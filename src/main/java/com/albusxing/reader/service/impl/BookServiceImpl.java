package com.albusxing.reader.service.impl;

import com.albusxing.reader.common.constant.DeleteFlagEnum;
import com.albusxing.reader.domain.entity.Book;
import com.albusxing.reader.domain.vo.BookRequest;
import com.albusxing.reader.mapper.BookMapper;
import com.albusxing.reader.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    @Override
    public List<Book> listBook(String name, Page<Book> page) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>()
                .eq("delete_flag", DeleteFlagEnum.NORMAL.getCode())
                .like("title", name);
        Page<Book> bookPage = this.page(page, queryWrapper);
        return bookPage.getRecords();
    }

    @Override
    public boolean saveOrUpdate(BookRequest bookRequest) {
        Long bookId = bookRequest.getBookId();
        Book book;
        if (Objects.isNull(bookId)) {
            book = new Book();
        } else {
            book = this.getById(bookId);
        }
        BeanUtils.copyProperties(bookRequest, book);
        return this.saveOrUpdate(book);
    }
}
