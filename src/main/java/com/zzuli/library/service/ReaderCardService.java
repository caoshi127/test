package com.zzuli.library.service;

import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.domain.ReaderInfo;

/**
 * @author hejjon
 * @date 2019/8/17 21:07
 */
public interface ReaderCardService {

    /**
     * 查询借阅卡
     * @param readerCard   查询条件
     * @return  查询到的借阅卡
     */
    ReaderCard getReaderCard(ReaderCard readerCard);

    /**
     * 修改借阅卡信息
     * @param readerInfo    要修改的读者
     * @return  修改成功返回1, 否则返回0
     */
    int updateReaderCard(ReaderInfo readerInfo);

    /**
     * 移除指定id的读者的借阅卡
     * @param id 指定的id
     * @return  移除成功返回1, 否则返回0
     */
    int removeReaderCard(long id);

    /**
     * 保存读者借阅卡信息
     * @param readerCard    读者借阅卡
     * @return  保存成功返回1, 否则返回0
     */
    int saveReaderCard(ReaderCard readerCard);

    /**
     * 修改读者密码
     * @param readerCard    读者的借阅卡
     * @return  修改成功返回1, 否则返回0
     */
    int updatePassword(ReaderCard readerCard);

}
