package com.hfut.xyxblog.service;

import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.dao.Entity.Book;

import java.util.List;

public interface BookService {
    //根据分类号查询书籍
    PageResp selectBooksByCid(PageReq pageReq, Integer cid);

    //增加书籍
    int insertBook(Book book);

    //根据id删除书籍
    int deleteBookByid(long id);

    //更新书籍
    int updateBook(Book book);

    //查询所有书籍
    List<Book> selectAllBooks();

    //按照书名或作者名模糊查找书籍
    List<Book> selectBooksByTitleOrAuthor(String name);
}
