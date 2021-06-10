package xyz.myzsl.uedu.service;

import xyz.myzsl.uedu.bean.User;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:54:07
 */
public interface UserService {

    /**
     * 通过用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User getUserByUsernameAndPassword(String username, String password);
}
