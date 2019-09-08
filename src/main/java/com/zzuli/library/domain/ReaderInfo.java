package com.zzuli.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 读者实体类
 * @author hejjon
 * @date 2019/8/18 7:09
 */
public class ReaderInfo implements Serializable {

    private long reader_id;
    private String name;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public long getReader_id() {
        return reader_id;
    }

    public void setReader_id(long reader_id) {
        this.reader_id = reader_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
