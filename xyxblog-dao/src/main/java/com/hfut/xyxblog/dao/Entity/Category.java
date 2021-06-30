package com.hfut.xyxblog.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    //种类id
    private int id;

    //种类名称
    private String name;
}
