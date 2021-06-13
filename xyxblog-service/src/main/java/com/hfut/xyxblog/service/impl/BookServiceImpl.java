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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
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
            int totalPageNum = (int) Math.ceil(pageInfo.getTotal() / pageInfo.getPageSize());
            pageResp.setTotalPageNum(totalPageNum);
        }
        log.info("PageResp: " + gson.toJson(pageResp, PageResp.class));
        return pageResp;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public int deleteBookByid(long id) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }

    @Override
    public List<Book> selectAllBooks() {
        return null;
    }

    @Override
    public List<Book> selectBooksByTitleOrAuthor(String name) {
        return null;
    }
}
