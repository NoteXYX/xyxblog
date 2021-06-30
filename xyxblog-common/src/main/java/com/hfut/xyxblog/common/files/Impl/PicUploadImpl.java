package com.hfut.xyxblog.common.files.Impl;

import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.files.IFileUpload;
import com.hfut.xyxblog.common.response.CommonResp;
import com.hfut.xyxblog.common.response.FileUploadResp;
import com.hfut.xyxblog.common.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class PicUploadImpl implements IFileUpload {

    //在配置文件中配置的文件保存路径
    @Value("${myFiles.imagePath}")
    private String imageRealPath;

    @Override
    public FileUploadResp uploadFile(MultipartFile file){
        FileUploadResp fileUploadResp = new FileUploadResp();
        CommonResp commonResp = new CommonResp();
        String imageRootPath = System.getProperty("user.dir") + imageRealPath;
        File filePath = new File(imageRootPath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdirs();
        }
        String originName = file.getOriginalFilename();
        if (StringUtils.isBlank(originName)) {
            commonResp.setCode(ResCode.FAILURE);
            commonResp.setMessage("上传失败，上传图片名为空！");
            fileUploadResp.setCommonResp(commonResp);
            return fileUploadResp;
        }
        String fileType = originName.substring(originName.lastIndexOf("."));
        String fileName = originName.substring(0, originName.lastIndexOf("."));
        String targetName = UUIDUtils.getUUID() + fileName + fileType;
        File targetFile = new File(imageRootPath, targetName);
        try {
            file.transferTo(targetFile);
            commonResp.setCode(ResCode.SUCCESS);
            commonResp.setMessage("图片上传成功！");
            fileUploadResp.setCommonResp(commonResp);
            fileUploadResp.setTargetPath(imageRealPath + targetName);
            return fileUploadResp;
        } catch (IOException e) {
            e.printStackTrace();
            commonResp.setCode(ResCode.ERROR);
            commonResp.setMessage("图片上传异常！");
            fileUploadResp.setCommonResp(commonResp);
            return fileUploadResp;
        }
    }
}
