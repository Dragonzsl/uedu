package xyz.myzsl.uedu.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author shilin
 * @TableName coursedetail
 */
@Data
public class CourseDetail implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String startData;

    /**
     * 
     */
    private Integer cid;

    private static final long serialVersionUID = 1L;
}