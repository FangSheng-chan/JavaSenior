package com.ss.model;

import com.ss.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fangsheng
 * @date 2021/5/20 2:27 下午
 */
public class Stu {
    private String[] courses;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private List<User> users;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", users=" + users +
                '}';
    }
}
