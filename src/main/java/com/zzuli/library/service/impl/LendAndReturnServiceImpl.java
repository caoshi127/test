package com.zzuli.library.service.impl;

import com.zzuli.library.domain.LendInfo;
import com.zzuli.library.mapper.BookInfoMapper;
import com.zzuli.library.mapper.LendInfoMapper;
import com.zzuli.library.service.LendAndReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hejjon
 * @date 2019/8/26 14:33
 */
@Service
public class LendAndReturnServiceImpl implements LendAndReturnService {

    @Autowired
    private LendInfoMapper lendInfoMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public int lendBook(long bookId, long readerId) {
        LendInfo lendInfo = new LendInfo();
        lendInfo.setBook_id(bookId);
        lendInfo.setReader_id(readerId);
        int i = lendInfoMapper.insertOneLendInfo(lendInfo);
        // 获取借出前图书的原有数量
        int oldNumber = bookInfoMapper.getBookById(bookId).getNumber();
        int j = bookInfoMapper.updateBookNumber(bookId, oldNumber - 1);
        if (i > 0 && j > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int returnBook(long bookId, long readerId) {
        LendInfo lendInfo = new LendInfo();
        lendInfo.setBook_id(bookId);
        lendInfo.setReader_id(readerId);
        int i = lendInfoMapper.updateLendInfo(lendInfo);
        // 获取借出前图书的原有数量
        int oldNumber = bookInfoMapper.getBookById(bookId).getNumber();
        int j = bookInfoMapper.updateBookNumber(bookId, oldNumber + 1);
        if (i > 0 && j > 0) {
            return 1;
        } else {
            return 0;
        }


    }
}
