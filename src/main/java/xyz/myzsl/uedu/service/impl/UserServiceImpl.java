package xyz.myzsl.uedu.service.impl;

import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.dao.UserDao;
import xyz.myzsl.uedu.dao.impl.UserDaoImpl;
import xyz.myzsl.uedu.service.UserService;
import xyz.myzsl.uedu.utils.Page;

import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:56:10
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        return userDao.queryUserByUsernameAndPassword(username, password);

    }

    @Override
    public Page<User> getUserListForPage(String search, String pageSize, String currentPage) {


        List<User> users = userDao.queryUserListLimit(search, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        Long count = userDao.queryCount(search);
        System.out.println("count" + count);
        Page<User> page = new Page<>();
        page.setList(users);
        page.setPageNo(Integer.parseInt(currentPage));
        page.setTotalRecord(count.intValue());

        return page;
    }

    @Override
    public Integer addUser(String username, String password, String name, String phone, String status, String role, String age, String sex) {

        return userDao.insertUser(username, password, name, phone, status, role, age, sex);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }
}
