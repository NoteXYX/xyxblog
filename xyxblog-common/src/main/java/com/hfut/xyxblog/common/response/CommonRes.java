package com.hfut.xyxblog.common.response;

import com.hfut.xyxblog.common.enums.ResCode;
import lombok.Data;

@Data
public class CommonRes {
    //响应代码
    ResCode code;

    //响应信息
    String message;
}
