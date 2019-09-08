package com.zzuli.library.mapper;

import com.zzuli.library.domain.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/18 16:22
 */
public interface ReaderInfoMapper {

    /**
     * 通过读者账号查询读者信息
     * @param reader_id    读者账号
     * @return  查询到的读者信息
     */
    ReaderInfo getReaderInfoById(long reader_id);

    /**
     * 查询所有读者信息
     * @return  全部读者信息列表
     */
    List<ReaderInfo> listAllReaderInfo();


    /**
     * 查询读者的读者证号
     * @param readerInfo    读者信息
     * @return  读者证号
     */
    long getReaderId(ReaderInfo readerInfo);

    /**
     * 修改指定读者信息
     * @param readerInfo    指定需要修改的读者
     * @return  修改成功返回1, 否则返回0
     */
    int updateReaderInfo(ReaderInfo readerInfo);

    /**
     * 删除指定id的读者信息
     * @param reader_id 指定读者的id
     * @return  删除成功返回1, 否则返回0
     */
    int deleteReaderInfo(long reader_id);

    /**
     * 新增读者信息
     * @param readerInfo 新增的读者
     * @return  新增成功返回1, 否则返回0
     */
    int insertReaderInfo(ReaderInfo readerInfo);




}
