package com.zzuli.library.service;

/**
 * 读者借书&还书业务
 * @author hejjon
 * @date 2019/8/26 14:22
 */
public interface LendAndReturnService {

    /**
     * 读者借出图书
     * @param bookId   图书id
     * @param readerId 读者id
     * @return  借出成功返回1, 否则返回0
     */
    int lendBook(long bookId, long readerId);

    /**
     * 读者归还图书
     * @param bookId   图书id
     * @param readerId 读者id
     * @return  归还成功返回1, 否则返回0
     */
    int returnBook(long bookId, long readerId);



}
