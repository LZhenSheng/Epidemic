package com.example.epidemic.liteorm;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/***
* 通行证表
* @author 胜利镇
* @time 2021/1/4
* @dec
*/
@Table("PassCard")
public class PassCard {

    /**
     * 标题
     * PrimaryKey:主键
     * BY_MYSELF:使用该字段的值
     * 还可以指定自动生成
     */
    @PrimaryKey(AssignType.BY_MYSELF)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private String commitDate;

    @NotNull
    private String reason;

    @NotNull
    private String num;

    @NotNull
    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNname() {
        return name;
    }

    public void setNname(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
