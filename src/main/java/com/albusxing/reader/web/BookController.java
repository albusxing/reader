package com.albusxing.reader.web;

import com.albusxing.reader.common.base.BaseResult;
import com.albusxing.reader.common.constant.ResultCodeEnum;
import com.albusxing.reader.domain.entity.Book;
import com.albusxing.reader.domain.vo.BookRequest;
import com.albusxing.reader.service.BookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;


    @PostMapping("/save")
    public BaseResult<List<Book>> save(@RequestBody BookRequest bookRequest) {
        BaseResult<List<Book>> result = BaseResult.success();
        try {
            return BaseResult.success();
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @DeleteMapping("/{id}")
    public BaseResult<Void> delete(@PathVariable("id") Long id) {
        BaseResult<Void> result = BaseResult.success();
        try {
            bookService.removeById(id);
            return BaseResult.success();
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/{id}")
    public BaseResult<Void> update(@PathVariable("id") Long id, @RequestBody BookRequest bookRequest) {
        BaseResult<Void> result = BaseResult.success();
        try {
            bookService.removeById(id);
            return BaseResult.success();
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @GetMapping("/list")
    public BaseResult<List<Book>> list(@NotNull(message = "用户id不能为空") @RequestParam(value = "name") String name,
                                       @RequestParam(value = "pageNo", defaultValue = "1") Long pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize) {
        BaseResult<List<Book>> result = BaseResult.success();
        try {
            Page<Book> page = new Page<>(pageNo, pageSize);
            List<Book> bookList = bookService.listBook(name, page);
            return BaseResult.success(bookList);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }


    @GetMapping("/{id}")
    public BaseResult<Book> get(@PathVariable("id") Long id) {
        BaseResult<Book> result = BaseResult.success();
        try {
            Book book = bookService.getById(id);
            return BaseResult.success(book);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.FAIL.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }





}
