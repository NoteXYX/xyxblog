package com.hfut.xyxblog.common.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResp {

    //数据
    private List<?> data;

    //数据总量
    private long totalNum;

    //总页数
    private int totalPageNum;

    private CommonResp commonResp;
}
