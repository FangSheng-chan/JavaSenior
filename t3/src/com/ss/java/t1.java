package com.ss.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class t1 {
    public static void main(String[] args) {

        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now1.format(dateTimeFormatter);
        System.out.println(format);
    }
}
