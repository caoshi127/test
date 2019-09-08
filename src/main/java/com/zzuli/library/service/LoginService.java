package com.zzuli.library.service;

import java.util.Map;

/**
 * @author hejjon
 * @date 2019/8/18 14:57
 */
public interface LoginService {

    /**
     *  匹配用户
     *  前端传来用户账号和密码, 判别该用户是管理员还是读者
     * @param id        用户账号
     * @param password  用户密码
     * @return  ("isAdmin", Admin对象) -> 是管理员; ("isReader", ReaderInfo对象) -> 是读者
     */
    Map<String, Object> matchUser(long id, String password);


}
