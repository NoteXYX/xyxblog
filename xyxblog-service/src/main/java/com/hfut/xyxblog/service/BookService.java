package com.hfut.xyxblog.service;

import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.dao.Entity.Book;

public interface BookService {

    //根据分类号查询书籍
    PageResp selectBooksByCid(PageReq pageReq, Integer cid);

    //增加书籍
    int insertOrUpdateBook(Book book);

    //根据id删除书籍
    int deleteBookById(long id);

    //查询所有书籍
    PageResp selectAllBooks(PageReq pageReq);

    //按照书名或作者名模糊查找书籍
    PageResp selectBooksByTitleOrAuthor(PageReq pageReq, String name);

    //上传书面
}
