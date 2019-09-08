package com.zzuli.library.service;

import com.zzuli.library.domain.ReaderInfo;

import java.util.List;

public interface ReaderInfoService {

    /**
     * 获取读者信息
     * @param readerInfo    查询条件
     * @return  要查询的读者完整信息
     */
    ReaderInfo getReaderInfo(ReaderInfo readerInfo);

    /**
     * 查询所有读者信息
     * @return  所有读者信息列表
     */
    List<ReaderInfo> listAllReaderInfo();

    /**
     * 通过id查询读者信息
     * @param readerId  读者id
     * @return  读者信息
     */
    ReaderInfo getReaderInfoById(long readerId);

    /**
     * 通过读者的其它信息获取读者证号
     * @param readerInfo    除reader_id以外的所有信息
     * @return  读者证号 reader_id
     */
    long getReaderId(ReaderInfo readerInfo);


    /**
     * 修改指定读者的信息
     * @param readerInfo    指定的读者
     * @return  修改成功返回1, 否则返回0
     */
    int updateReaderInfo(ReaderInfo readerInfo);

    /**
     * 移除指定id的读者信息
     * @param id    指定读者的id
     * @return  移除成功返回1, 否则返回0
     */
    int removeReaderInfo(long id);

    /**
     * 保存读者信息
     * @param readerInfo    读者信息
     * @return  保存成功返回1, 否则返回0
     */
    int saveReaderInfo(ReaderInfo readerInfo);

}
