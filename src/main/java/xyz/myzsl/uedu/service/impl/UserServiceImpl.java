package xyz.myzsl.uedu.service.impl;

import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.dao.UserDao;
import xyz.myzsl.uedu.dao.impl.UserDaoImpl;
import xyz.myzsl.uedu.service.UserService;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:56:10
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        return userDao.queryUserByUsernameAndPassword(username,password);

    }
}
