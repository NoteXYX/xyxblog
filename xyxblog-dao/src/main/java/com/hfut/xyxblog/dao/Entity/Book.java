package com.hfut.xyxblog.dao.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Book {

    //书id
    private long id;

    //书名
    private String title;

    //书摘要简介
    private String abs;

    //书封面图片地址
    private String cover;

    //作者名
    private String author;

    //书类id
    private int cid;

    //出版日期
    private Date pressDate;

    //出版社名称
    private String press;

    //更新书籍信息的用户id
    private long updateId;

    //更新书籍信息时间
    private Date updateDatetime;

}