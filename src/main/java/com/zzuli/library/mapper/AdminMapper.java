package com.zzuli.library.mapper;

import com.zzuli.library.domain.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author hejjon
 * @date 2019/8/17 20:33
 */
public interface AdminMapper {

    /**
     * 通过账号和密码查询管理员
     * @param admin_id            管理员账号
     * @param password      管理员密码
     * @return  获取到的管理员对象
     */
    Admin getAdminByIdAndPwd(@Param("admin_id") long admin_id, @Param("password") String password);

    /**
     * 同过账号获取密码
     * @param admin_id 账号
     * @return  对应账号的密码
     */
    String getPasswordById(long admin_id);

    /**
     * 修改管理员密码
     * @param admin 修改密码后的管理员对象
     * @return  修改成功返回1, 否则返回0
     */
    int updatePassword(Admin admin);


}
