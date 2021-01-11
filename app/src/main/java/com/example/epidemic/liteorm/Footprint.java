package com.example.epidemic.liteorm;


import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

@Table("Account")
public class Footprint {

    /**
     * 标题
     * PrimaryKey:主键
     * BY_MYSELF:使用该字段的值
     * 还可以指定自动生成
     */
    @PrimaryKey(AssignType.BY_MYSELF)
    private String id;

    @NotNull
    private String area;

    @NotNull
    private String date;
}
