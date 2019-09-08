package com.zzuli.library.mapper;

import com.zzuli.library.domain.ReaderCard;
import com.zzuli.library.domain.ReaderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author hejjon
 * @date 2019/8/17 21:06
 */
public interface ReaderCardMapper {

    /**
     * 通过账号和密码查询借阅卡
     * @param reader_id        读者账号/借阅卡号
     * @param password  读者密码
     * @return          查询到的读者信息
     */
    ReaderCard getReaderCardByIdAndPwd(@Param("reader_id") long reader_id, @Param("password") String password);

    /**
     * 修改读者的借阅卡信息
     * @param readerInfo    要修改的读者
     * @return  修改成功返回1, 否则返回0
     */
    int updateReaderCard(ReaderInfo readerInfo);

    /**
     * 删除指定id读者的借阅卡
     * @param reader_id 指定读者的id
     * @return 删除成功返回1, 否则返回0
     */
    int deleteReaderCard(long reader_id);

    /**
     * 新增读者借阅卡
     * @param readerCard    新增对象
     * @return  新增成功返回1, 否则返回0
     */
    int insertReaderCard(ReaderCard readerCard);

    /**
     * 修改读者密码
     * @param readerCard    读者的借阅卡
     * @return  修改成功返回1, 否则返回0
     */
    int updatePassword(ReaderCard readerCard);

}
