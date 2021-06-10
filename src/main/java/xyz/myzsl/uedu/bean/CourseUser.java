package xyz.myzsl.uedu.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author shilin
 * @TableName course_user
 */
@Data
public class CourseUser implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer cid;

    /**
     * 
     */
    private Integer uid;

    private static final long serialVersionUID = 1L;
}