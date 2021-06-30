package com.hfut.xyxblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.dao.Dao.BookDao;
import com.hfut.xyxblog.dao.Entity.Book;
import com.hfut.xyxblog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private Gson gson;

    //根据分类号分页查询书籍
    @Override
    public PageResp selectBooksByCid(PageReq pageReq, Integer cid) {
        List<Book> bookList = Lists.newArrayList();
        PageResp pageResp = new PageResp();
        Integer pageNum = pageReq.getPageNum();
        Integer pageSize = pageReq.getPageSize();
        if (Objects.nonNull(cid) && Objects.nonNull(pageNum) && Objects.nonNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize);
            bookList = bookDao.selectBooksByCid(cid);
            PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
            pageResp.setData(pageInfo.getList());
            pageResp.setTotalNum(pageInfo.getTotal());
            int totalPageNum = 0;
            if (pageInfo.getPageSize() != 0) {
                totalPageNum = (int) Math.ceil(pageInfo.getTotal() / pageInfo.getPageSize());
            }
            pageResp.setTotalPageNum(totalPageNum);
        }
        return pageResp;
    }

    @Override
    public int insertOrUpdateBook(Book book) {
//        if (Objects.nonNull(book.getPressDate())) {     //改变时间格式
//
//        }
        if (Objects.isNull(book.getId())) {    //新增书籍
            return bookDao.insertBook(book);
        } else {    //修改书籍
            return bookDao.updateBook(book);
        }
    }

    @Override
    public int deleteBookById(long id) {
        return bookDao.deleteBookByid(id);
    }

    @Override
    public PageResp selectAllBooks(PageReq pageReq) {
        List<Book> bookList = Lists.newArrayList();
        PageResp pageResp = new PageResp();
        Integer pageNum = pageReq.getPageNum();
        Integer pageSize = pageReq.getPageSize();
        if (Objects.nonNull(pageNum) && Objects.nonNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize);
            bookList = bookDao.selectAllBooks();
            PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
            pageResp.setData(pageInfo.getList());
            pageResp.setTotalNum(pageInfo.getTotal());
            int totalPageNum = 0;
            if (pageInfo.getPageSize() != 0) {
                totalPageNum = (int) Math.ceil(pageInfo.getTotal() / pageInfo.getPageSize());
            }
            pageResp.setTotalPageNum(totalPageNum);
        }
        return pageResp;
    }

    @Override
    public PageResp selectBooksByTitleOrAuthor(PageReq pageReq, String name) {
        List<Book> bookList = Lists.newArrayList();
        PageResp pageResp = new PageResp();
        Integer pageNum = pageReq.getPageNum();
        Integer pageSize = pageReq.getPageSize();
        if (Objects.nonNull(name) && Objects.nonNull(pageNum) && Objects.nonNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize);
            bookList = bookDao.selectBooksByTitleOrAuthor(name);
            PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
            pageResp.setData(pageInfo.getList());
            pageResp.setTotalNum(pageInfo.getTotal());
            int totalPageNum = 0;
            if (pageInfo.getPageSize() != 0) {
                totalPageNum = (int) Math.ceil(pageInfo.getTotal() / pageInfo.getPageSize());
            }
            pageResp.setTotalPageNum(totalPageNum);
        }
        return pageResp;
    }
}
