package com.zzuli.library.mapper;

import com.zzuli.library.domain.LendInfo;

import java.util.List;

/**
 * @author hejjon
 * @date 2019/8/22 11:16
 */
public interface LendInfoMapper {

    /**
     * 查询所有借阅信息
     * @return  所有借阅信息集合
     */
    List<LendInfo> listAllLendInfo();

    /**
     * 删除指定流水号的借阅信息
     * @param ser_num   要删除的借阅信息流水号
     * @return  删除成功返回1, 否则返回0
     */
    int deleteLendInfoBySerNum(long ser_num);

    /**
     * 查询指定读者的借阅信息
     * @param reader_id 读者的读者证号码
     * @return  指定读者的借阅信息
     */
    List<LendInfo> listReadersLendInfo(long reader_id);

    /**
     * 查询指定读者的未归还图书的book_id列表
     * @param reader_id 指定读者的id
     * @return  未归还图书的book_id列表
     */
    List<Long> listNoReturnBooksId(long reader_id);

    /**
     * 新增借阅信息 借阅图书
     * @param lendInfo  借阅信息
     * @return  新增成功返回1, 否则返回0
     */
    int insertOneLendInfo(LendInfo lendInfo);

    /**
     * 修改借阅信息 归还图书
     * @param lendInfo  借阅信息
     * @return  更新成功返回1, 否则返回0
     */
    int updateLendInfo(LendInfo lendInfo);


}
