package com.zzuli.library.service.impl;

import com.zzuli.library.mapper.AdminMapper;
import com.zzuli.library.mapper.ReaderCardMapper;
import com.zzuli.library.mapper.ReaderInfoMapper;
import com.zzuli.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hejjon
 * @date 2019/8/18 16:04
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Autowired
    private ReaderInfoMapper readerInfoMapper;


    /**
     * 对用户的账号和密码进行匹配.
     * @param id        用户账号
     * @param password  用户密码
     * @return  isAdmin-Admin对象 或 isReader-Reader对象
     */
    @Override
    public Map<String, Object> matchUser(long id, String password) {
        // System.out.println("LoginServiceImpl.matchUser" + " id=" + id + "---" + "password = " + password);
        Map<String, Object> result = null;
        Object obj = null;

        if ((obj = adminMapper.getAdminByIdAndPwd(id, password)) != null) {
            result = new HashMap<>();
            result.put("isAdmin", obj);
        } else if ((obj = readerCardMapper.getReaderCardByIdAndPwd(id, password)) != null) {
            result = new HashMap<>();
            result.put("isReader", obj);
            // System.out.println("LoginServiceImpl.matchUser---" + result);
        } else {
            return null;
        }
        return result;
    }
}
