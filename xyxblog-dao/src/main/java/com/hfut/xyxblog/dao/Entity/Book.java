package com.hfut.xyxblog.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    //书id
    private Long id;

    //书名
    private String title;

    //作者名
    private String author;

    //出版日期
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pressDate;

    //出版社名称
    private String press;

    //书封面图片地址
    private String cover;

    //书摘要简介
    private String abs;

    //书类id
    private int cid;

    //更新书籍信息的用户id
    private long updateId;

    //更新书籍信息时间
    private Date updateDatetime;

}