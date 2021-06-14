package com.hfut.xyxblog.common.response;

import com.hfut.xyxblog.common.enums.ResCode;
import lombok.Data;

@Data
public class CommonResp {

    //响应代码
    private ResCode code;

    //响应信息
    private String message;
}
