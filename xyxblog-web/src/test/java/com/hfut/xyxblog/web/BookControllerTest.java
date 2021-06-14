package com.hfut.xyxblog.web;

import com.google.gson.Gson;
import com.hfut.xyxblog.common.req.PageReq;
import com.hfut.xyxblog.common.response.PageResp;
import com.hfut.xyxblog.web.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    BookController bookController;

    @Autowired
    Gson gson;

    @Test
    public void queryBooksByCidTest() {
        PageReq pageReq = new PageReq();
        pageReq.setPageNum(1);
        pageReq.setPageSize(10);
        int cid = 5;
        PageResp pageResp= bookController.queryBooksByCid(pageReq, cid);
        System.out.println("pageResp=" + gson.toJson(pageResp));
    }
}
