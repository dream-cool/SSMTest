package com.clt;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DateTest {

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

class test{
    public static void main(String[] args) {
        DateTest dateTest=new DateTest();
        String s="2019-10-10 12:12:12";
        dateTest.setDate(new Date());
        System.out.println(dateTest.getDate());
    }
}
