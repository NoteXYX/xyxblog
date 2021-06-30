package com.hfut.xyxblog.common.files;

import com.hfut.xyxblog.common.enums.FileType;
import com.hfut.xyxblog.common.files.Impl.PicUploadImpl;
import com.hfut.xyxblog.common.files.Impl.TextUploadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FileUploadFactory {

    @Autowired
    private PicUploadImpl picUploadService;

    @Autowired
    private TextUploadImpl textUploadService;

    public IFileUpload getFileUploadService(FileType fileType) {
        if (Objects.isNull(fileType)) {
            return null;
        } else if (fileType.equals(FileType.PICTURE)) {
            return picUploadService;
        } else if (fileType.equals(FileType.TEXT)) {
            return textUploadService;
        } else {
            throw new RuntimeException("不存在的文件类型");
        }
    }
}
