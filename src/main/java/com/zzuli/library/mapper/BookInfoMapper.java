package com.zzuli.library.mapper;

import com.zzuli.library.domain.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/19 15:23
 */
public interface BookInfoMapper {

    /**
     * 查询所有图书信息
     * @return  返回所有图书信息对象
     */
    List<BookInfo> listAllBooks();

    /**
     *  通过检索查询图书信息
     * @param search    已拼接 % 的查询条件
     * @return      返回可能的多个图书信息对象
     */
    List<BookInfo> listBooksBySearchWords(String search);

    /**
     * 通过book_id 查询图书信息
     * @param book_id   图书id
     * @return  返回单个图书信息对象
     */
    BookInfo getBookById(long book_id);

    /**
     * 删除指定id的图书信息
     * @param book_id   图书id
     * @return  >0 说明删除成功, 否则删除失败
     */
    int deleteBookById(long book_id);

    /**
     * 修改图书信息
     * @param bookInfo  修改后的图书信息
     * @return  数据库受影响行数
     */
    int updateBookInfo(BookInfo bookInfo);

    /**
     * 新增图书信息
     * @param bookInfo  新增图书信息
     * @return  数据库表受影响行数
     */
    int insertBookInfo(BookInfo bookInfo);

    /**
     *  更新图书数量
     * @param book_id   图书id
     * @param number    更新后的图书数量
     * @return  更新成功返回1, 否则返回0
     */
    int updateBookNumber(@Param("book_id") long book_id, @Param("number") int number);


}
