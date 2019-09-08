package com.zzuli.library.service.impl;

import com.zzuli.library.domain.Admin;
import com.zzuli.library.mapper.AdminMapper;
import com.zzuli.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hejjon
 * @date 2019/8/17 20:33
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin getAdmin(Admin admin) {
        return adminMapper.getAdminByIdAndPwd(admin.getAdmin_id(), admin.getPassword());
    }

    @Override
    public String getPasswordById(long id) {
        return adminMapper.getPasswordById(id);
    }

    @Override
    public int updatePassword(Admin admin) {
        return adminMapper.updatePassword(admin);
    }

}
