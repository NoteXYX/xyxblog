package com.hfut.xyxblog.common.req;

import lombok.Data;

@Data
public class PageReq {

    //页码
    private Integer pageNum;

    //每页大小
    private Integer pageSize;
}
