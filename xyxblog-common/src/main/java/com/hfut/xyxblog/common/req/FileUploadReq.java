package com.hfut.xyxblog.common.req;

import com.hfut.xyxblog.common.enums.FileType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadReq {

    //需要上传的文件
    private MultipartFile file;

    //文件类型
    private FileType fileType;
}
