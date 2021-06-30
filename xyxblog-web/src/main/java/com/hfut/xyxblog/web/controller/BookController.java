package com.hfut.xyxblog.web.controller;

import com.google.gson.Gson;
import com.hfut.xyxblog.common.enums.FileType;
import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.files.FileUploadFactory;
import com.hfut.xyxblog.common.files.IFileUpload;
import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.CommonResp;
import com.hfut.xyxblog.common.response.FileUploadResp;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.dao.Entity.Book;
import com.hfut.xyxblog.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private Gson gson;

    @Autowired
    private FileUploadFactory fileUploadFactory;

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
    @PostMapping("/book/addOrUpdateBook")
    public CommonResp addOrUpdateBook(@RequestBody Book book) {
        log.info("Method:[addOrUpdateBook]; Req:book={}",gson.toJson(book, Book.class));
        CommonResp commonResp = new CommonResp();
        try {
            int successLine = bookService.insertOrUpdateBook(book);
            if (successLine == 1) {
                commonResp.setCode(ResCode.SUCCESS);
                commonResp.setMessage("书籍新增/修改成功！");
            } else {
                commonResp.setCode(ResCode.FAILURE);
                commonResp.setMessage("书籍新增/修改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResp.setCode(ResCode.ERROR);
            commonResp.setMessage("书籍新增/修改异常！");
        }
        log.info("Method:[addOrUpdateBook]; Resp:commonResp={}", gson.toJson(commonResp, CommonResp.class));
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
    @PostMapping("/book/queryAllBooks")
    public PageResp queryAllBooks(@RequestBody PageReq pageReq) {
        log.info("Method:[queryAllBooks]; Req:pageReq={}", gson.toJson(pageReq, PageReq.class));
        PageResp pageResp = new PageResp();
        CommonResp commonResp = new CommonResp();
        try {
            pageResp = bookService.selectAllBooks(pageReq);
            commonResp.setCode(ResCode.SUCCESS);
            commonResp.setMessage("查询所有书籍成功！");
        } catch (Exception e) {
            e.printStackTrace();
            commonResp.setCode(ResCode.ERROR);
            commonResp.setMessage("查询所有书籍出错！");
        }
        pageResp.setCommonResp(commonResp);
        log.info("Method:[queryAllBooks]; Resp:pageResp={}", gson.toJson(pageResp, PageResp.class));
        return pageResp;
    }

    @CrossOrigin
    @PostMapping("/book/uploadCover")
    public FileUploadResp uploadCover(MultipartFile file) {
        log.info("Method:[uploadCover]; Req:pic={}", gson.toJson(file.getOriginalFilename()));
        FileUploadResp fileUploadResp = new FileUploadResp();
        FileType fileType = FileType.PICTURE;
        IFileUpload fileUploadService = fileUploadFactory.getFileUploadService(fileType);
        fileUploadResp = fileUploadService.uploadFile(file);
        return fileUploadResp;
    }
}
