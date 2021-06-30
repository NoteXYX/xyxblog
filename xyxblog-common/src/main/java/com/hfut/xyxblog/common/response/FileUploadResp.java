package com.hfut.xyxblog.common.response;

import lombok.Data;

@Data
public class FileUploadResp {

    //通用响应
    private CommonResp commonResp;

    //文件存储位置
    private String targetPath;
}
