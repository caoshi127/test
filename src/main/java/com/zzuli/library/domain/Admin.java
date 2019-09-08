package com.zzuli.library.domain;

/**
 * @author hejjon
 * @date 2019/8/17 20:31
 */
public class Admin {

    private long admin_id;
    private String password;
    private String userName;

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
