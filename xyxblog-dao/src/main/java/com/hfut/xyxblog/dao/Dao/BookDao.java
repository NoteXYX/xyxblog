package com.hfut.xyxblog.dao.Dao;

import com.hfut.xyxblog.dao.Entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {

    //根据分类号查询书籍
    List<Book> selectBooksByCid(int cid);

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
