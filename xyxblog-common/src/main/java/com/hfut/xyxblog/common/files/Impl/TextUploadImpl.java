package com.hfut.xyxblog.common.files.Impl;

import com.hfut.xyxblog.common.files.IFileUpload;
import com.hfut.xyxblog.common.response.FileUploadResp;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class TextUploadImpl implements IFileUpload {
    @Override
    public FileUploadResp uploadFile(MultipartFile file) {
        return null;
    }
}
