package xyz.myzsl.uedu.dao.impl;

import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.dao.UserDao;
import xyz.myzsl.uedu.utils.BaseDao;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:54:17
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {

        return queryOne("select * from user where username=? and password=?", username, password);
    }
}
