package xyz.myzsl.uedu.dao.impl;

import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.dao.UserDao;
import xyz.myzsl.uedu.utils.BaseDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<User> queryUserListLimit(String search, Integer pageSize, Integer currentPage) {
        return queryListWithLimit("select * from user where username like ? limit ?,?",
                "%" + search + "%", (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public Long queryCount(String search) {

        return queryCount("select count(*) from user where username like ?","%" + search + "%");

    }

    @Override
    public Integer insertUser(String username, String password, String name, String phone, String status, String role, String age, String sex) {

        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        return update("insert into user(name,phone,age,sex,username,password,status,createtime,role) values (?,?,?,?,?,?,?,?,?)",
                name,phone,age,sex,username,password,status,format,role);
    }

    @Override
    public User queryUserByUsername(String username) {
        return queryOne("select * from user where username = ?", username);
    }

}
