package com.zzuli.library.domain;

import java.util.Date;

/**
 * 借阅信息实体类, 对应数据库表: lend_list
 * @author hejjon
 * @date 2019/8/22 11:12
 */
public class LendInfo {
    private long ser_num;       // 流水号, 主键自增
    private long book_id;
    private long reader_id;
    private Date lend_date;     // 借出日期
    /**
     * 图书归还日期, 为null表示未归还
     */
    private Date back_date;

    @Override
    public String toString() {
        return "LendInfo{" +
                "ser_num=" + ser_num +
                ", book_id=" + book_id +
                ", reader_id=" + reader_id +
                ", lend_date=" + lend_date +
                ", back_date=" + back_date +
                '}';
    }

    public long getSer_num() {
        return ser_num;
    }

    public void setSer_num(long ser_num) {
        this.ser_num = ser_num;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getReader_id() {
        return reader_id;
    }

    public void setReader_id(long reader_id) {
        this.reader_id = reader_id;
    }

    public Date getLend_date() {
        return lend_date;
    }

    public void setLend_date(Date lend_date) {
        this.lend_date = lend_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }
}
