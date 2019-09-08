package com.zzuli.library.service;

import com.zzuli.library.domain.BookInfo;

import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/19 15:37
 */
public interface BookInfoService {

    /**
     * 查找所有图书信息
     * @return  所以图书信息集合
     */
    List<BookInfo> listAllBookInfo();


    /**
     * 按检索查询图书信息
     * @param SearchWords   查询关键字 包括书名, 作者, 简介
     * @return  查询到的图书信息列表
     */
    List<BookInfo> listBooksBySearchWords(String SearchWords);


    /**
     * 按图书id查询图书信息
     * @param id    被查图书的id
     * @return  查询到的图书信息
     */
    BookInfo getBookById(long id);

    /**
     * 通过id移除图书
     * @param id  要移除图书的id
     * @return  数据库表受影响的行数  一般为1表示移除一条图书信息成功
     */
    int removeBookById(long id);

    /**
     * 修改图书信息
     * @param bookInfo  要修改的图书信息
     * @return  数据库表受影响的行数  一般为1表示修改一条图书信息成功
     */
    int updateBookInfo(BookInfo bookInfo);

    /**
     * 新增图书信息
     * @param bookInfo  新增的图书信息
     * @return  数据库表受影响的行数  一般为1表示新增一条图书信息成功
     */
    int saveBookInfo(BookInfo bookInfo);



}
