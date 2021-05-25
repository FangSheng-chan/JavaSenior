package com.ss.model;

/**
 * @author fangsheng
 * @date 2021/5/24 2:02 下午
 */
public class Boy {
    private Integer id;
    private String boyName;
    private Integer userCp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public Integer getUserCp() {
        return userCp;
    }

    public void setUserCp(Integer userCp) {
        this.userCp = userCp;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCp=" + userCp +
                '}';
    }
}
