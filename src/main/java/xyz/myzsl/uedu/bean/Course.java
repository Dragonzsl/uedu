package xyz.myzsl.uedu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 课程表
 * @author shilin
 * @TableName course
 */
@Data
public class Course implements Serializable {
    /**
     * 课程编号
     */
    private Integer cid;

    /**
     * 课程名称
     */
    private String coursename;

    /**
     * 课程简介
     */
    private String descs;

    /**
     * 课程类型
     */
    private Integer coursetype;

    /**
     * 课程图片地址
     */
    private String courseimage;

    /**
     * 课程视频地址
     */
    private String coursevideo;

    /**
     * 价格
     */
    private BigDecimal courseprice;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 上传时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}