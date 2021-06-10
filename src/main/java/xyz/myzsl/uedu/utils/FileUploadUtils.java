package xyz.myzsl.uedu.utils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtils {
    public  static String uploadPic(Part part) throws IOException {
        //获取上传图片名
        String pic = part.getSubmittedFileName();
        //确定上传到服务器的哪个路径下
        String path = "E:\\test\\myedu\\eduFile";
        File file = new File(path);
        if (!file.exists()){
            //判断上传的路径是存在， 如果不存在则创建
            file.mkdir();
        }
        //为了避免文件名过长可以先判断文件的长度，过长的话就截取一部分
        if(pic.length()>20){
            pic=pic.substring(pic.length()-5,pic.length());
        }
        //为了避免文件名重复，可以给文件重新命名
        //上传操作:E:\edupic\1.jpg
        pic = UUID.randomUUID()+pic;
        part.write(path+"/"+ pic);
        return  pic;
    }
}
