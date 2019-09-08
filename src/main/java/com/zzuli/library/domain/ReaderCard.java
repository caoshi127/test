package com.zzuli.library.domain;

import java.io.Serializable;

/**
 * 借阅卡实体类
 * @author hejjon
 * @date 2019/8/18 8:13
 */
public class ReaderCard implements Serializable {

    private long reader_id;
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "ReaderCard{" +
                "reader_id=" + reader_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public long getReader_id() {
        return reader_id;
    }

    public void setReader_id(long reader_id) {
        this.reader_id = reader_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
