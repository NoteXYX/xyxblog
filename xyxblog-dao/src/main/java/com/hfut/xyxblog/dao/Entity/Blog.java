package com.hfut.xyxblog.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Blog {
    //博客主键id
    private long id;

    //博客标签
    private String labels;

    //博客内容
    private String content;

    //作者id
    private long editorId;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
