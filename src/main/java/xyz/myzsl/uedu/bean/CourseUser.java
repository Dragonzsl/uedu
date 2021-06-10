package xyz.myzsl.uedu.bean;

public class CourseUser {
    private int id;
    private int cid;
    private int uid;
    //添加两个临时属性,主要在显示的时候的时候，不参与其他的操作
    private Course c;
    private User u;


    public CourseUser() {
    }

    public CourseUser(int cid, int uid) {
        this.cid = cid;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
