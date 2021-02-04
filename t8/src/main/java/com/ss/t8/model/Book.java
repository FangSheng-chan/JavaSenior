package com.ss.t8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangsheng
 * @date 2021/1/26 11:19 上午
 */
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id;
    private String bookName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "----Book{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
