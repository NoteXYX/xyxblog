package com.hfut.xyxblog.web.controller;

import com.google.gson.Gson;
import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.CommonResp;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.dao.Entity.Book;
import com.hfut.xyxblog.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    Gson gson;

    @CrossOrigin
    @GetMapping("/book/booksByCid")
    public PageResp queryBooksByCid(@RequestBody PageReq pageReq,
                                    @RequestParam(value = "cid", required = true) Integer cid) {
        log.info("Method:[queryBooksByCid]; Req:pageReq={}, cid={}", gson.toJson(pageReq, PageReq.class), cid);
        PageResp pageResp = bookService.selectBooksByCid(pageReq, cid);
        log.info("Method:[queryBooksByCid]; Resp:pageResp={}", gson.toJson(pageResp, PageResp.class));
        return pageResp;
    }

    @CrossOrigin
    @PostMapping("/book/insertBook")
    public CommonResp insertBook(@RequestBody Book book) {
        log.info("Method:[insertBook]; Req:Book={}",gson.toJson(book, Book.class));
        CommonResp commonResp = new CommonResp();
        int successLine = bookService.insertBook(book);
        if (successLine == 1) {
            commonResp.setCode(ResCode.SUCCESS);
            commonResp.setMessage("书籍新增成功！");
        } else {
            commonResp.setCode(ResCode.FAILURE);
            commonResp.setMessage("书籍新增失败！");
        }
        log.info("Method:[insertBook]; Resp:commonResp={}", gson.toJson(commonResp, CommonResp.class));
        return commonResp;
    }

    @CrossOrigin
    @GetMapping("/book/delete")
    public CommonResp deleteBook(@RequestParam(value = "id", required = true) Long id) {
        log.info("Method:[deleteBook]; Req:id={}", id);
        CommonResp commonResp = new CommonResp();
        int successLine = bookService.deleteBookById(id);
        if (successLine == 1) {
            commonResp.setCode(ResCode.SUCCESS);
            commonResp.setMessage("书籍删除成功！");
        } else {
            commonResp.setCode(ResCode.FAILURE);
            commonResp.setMessage("书籍删除失败！");
        }
        log.info("Method:[deleteBook]; Resp:commonResp={}", gson.toJson(commonResp, CommonResp.class));
        return commonResp;
    }

    @CrossOrigin
    @PostMapping("/book/update")
    public CommonResp updateBook(@RequestBody Book book) {
        log.info("Method:[updateBook]; Req:book={}", gson.toJson(book, Book.class));
        CommonResp commonResp = new CommonResp();
        int successLine = bookService.updateBook(book);
        if (successLine == 1) {
            commonResp.setCode(ResCode.SUCCESS);
            commonResp.setMessage("书籍更新成功！");
        } else {
            commonResp.setCode(ResCode.FAILURE);
            commonResp.setMessage("书籍更新失败！");
        }
        log.info("Method:[updateBook]; Resp:commonResp={}", gson.toJson(commonResp, CommonResp.class));
        return commonResp;
    }

    @CrossOrigin
    @PostMapping("/book/queryAllBooks")
    public PageResp queryAllBooks(@RequestBody PageReq pageReq) {
        log.info("Method:[queryAllBooks]; Req:pageReq={}", gson.toJson(pageReq, PageReq.class));
        PageResp pageResp = bookService.selectAllBooks(pageReq);
        log.info("Method:[queryAllBooks]; Resp:pageResp={}", gson.toJson(pageResp, PageResp.class));
        return pageResp;
    }
}
