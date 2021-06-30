package com.hfut.xyxblog.common.enums;

//文件类型枚举
public enum FileType {

    PICTURE("pic"),
    TEXT("txt");

    String type;

    FileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
