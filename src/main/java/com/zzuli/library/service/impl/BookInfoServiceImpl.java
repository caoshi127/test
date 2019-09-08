package com.zzuli.library.service.impl;

import com.zzuli.library.domain.BookInfo;
import com.zzuli.library.mapper.BookInfoMapper;
import com.zzuli.library.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/19 15:38
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> listAllBookInfo() {
        return bookInfoMapper.listAllBooks();
    }

    @Override
    public List<BookInfo> listBooksBySearchWords(String SearchWords) {
        String search = "%" + SearchWords + "%";        // 不要在mapper.xml里直接用sql拼
        return bookInfoMapper.listBooksBySearchWords(search);
    }

    @Override
    public BookInfo getBookById(long id) {
        return bookInfoMapper.getBookById(id);
    }

    @Override
    public int removeBookById(long id) {
        return bookInfoMapper.deleteBookById(id);
    }

    @Override
    public int updateBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.updateBookInfo(bookInfo);
    }

    @Override
    public int saveBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.insertBookInfo(bookInfo);
    }


}
