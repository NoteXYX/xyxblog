package com.hfut.xyxblog.dao.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    //种类id
    private int id;

    //种类名称
    private String name;
}
