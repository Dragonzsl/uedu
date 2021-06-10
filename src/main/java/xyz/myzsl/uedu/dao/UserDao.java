package xyz.myzsl.uedu.dao;

import xyz.myzsl.uedu.bean.User;

import java.util.List;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:54:07
 */
public interface UserDao {

    /**
     * 通过用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 分页查询
     *
     * @param search      查询条件
     * @param pageSize    每页显示记录数
     * @param currentPage 当前页
     * @return List<User>
     */
    List<User> queryUserListLimit(String search, Integer pageSize, Integer currentPage);

    /**
     * 根据查询条件查询记录数
     *
     * @param search 查询条件
     * @return 记录数
     */
    Long queryCount(String search);

    /**
     * 添加用户
     *
     * @param username 用户名
     * @param password 密码
     * @param name     真实姓名
     * @param phone    手机号
     * @param status   户状态 1：启用 2：禁用
     * @param role     用户角色  1：管理员 2：普通用户
     * @param age      年龄
     * @param sex      性别
     * @return 添加成功 - 1 ，失败 - 0
     */
    Integer insertUser(String username, String password, String name, String phone, String status, String role, String age, String sex);

    /**
     * 根据用户名查询用户
     * @param username 用户真实姓名
     * @return User
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户id删除用户
     *
     * @param uids 用户id
     * @return 删除成功 - 1 ，失败 - 0
     */
    Integer deleteUserByUids(String[] uids);
}
