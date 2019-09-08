package com.zzuli.library.service;

import com.zzuli.library.domain.Admin;

/**
 * @author hejjon
 * @date 2019/8/17 20:28
 */
public interface AdminService {

    /**
     * 查询管理员详细信息
     * @param admin 管理员部分信息
     * @return  被查询管理员全部信息
     */
    Admin getAdmin(Admin admin);

    String getPasswordById(long id);


    /**
     * 修改管理员密码
     * @param admin 修改密码后的管理员对象
     * @return  修改成功返回1, 否则返回0
     */
    int updatePassword(Admin admin);

}
