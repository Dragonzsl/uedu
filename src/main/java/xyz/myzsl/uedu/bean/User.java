package xyz.myzsl.uedu.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @author shilin
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 学员编号
     */
    private Integer uid;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 注册时间
     */
    private Date createtime;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 头像
     */
    private String picture;

    private static final long serialVersionUID = 1L;
}