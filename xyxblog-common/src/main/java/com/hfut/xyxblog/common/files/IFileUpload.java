package com.hfut.xyxblog.common.files;

import com.hfut.xyxblog.common.response.FileUploadResp;
import org.springframework.web.multipart.MultipartFile;

public interface IFileUpload {

    FileUploadResp uploadFile(MultipartFile file);
}
