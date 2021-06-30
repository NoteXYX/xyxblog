package com.hfut.xyxblog.common.enums;

//响应状态枚举
public enum ResCode {

    ERROR(400, "异常"),
    SUCCESS(200, "成功"),
    FAILURE(401, "失败");

    int code;
    String condition;

    ResCode(int code, String condition) {
        this.code = code;
        this.condition = condition;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
