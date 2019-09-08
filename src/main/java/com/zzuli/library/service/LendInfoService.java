package com.zzuli.library.service;

import com.zzuli.library.domain.LendInfo;

import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/22 11:29
 */
public interface LendInfoService {

    /**
     * 查询所有借阅信息
     * @return 所有借阅信息集合
     */
    List<LendInfo> listAllLendInfo();

    /**
     * 查询指定读者的借阅信息
     * @param readerId 读者的读者证号
     * @return  指定读者的借阅信息
     */
    List<LendInfo> listReadersLendInfo(long readerId);

    /**
     * 删除指定流水号的借阅信息
     * @param serNum 指定的流水号
     * @return  删除成功返回1, 否则返回0
     */
    int removeLendInfo(long serNum);

    /**
     * 查询指定读者的未归还图书的book_id列表
     * @param readerId 指定读者的reader_id
     * @return  未归还图书的book_id列表
     */
    List<Long> listNoReturnBooksId(long readerId);




}
