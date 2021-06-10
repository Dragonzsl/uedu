package xyz.myzsl.uedu.servlet;

import com.alibaba.fastjson.JSON;
import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.service.UserService;
import xyz.myzsl.uedu.service.impl.UserServiceImpl;
import xyz.myzsl.uedu.utils.BaseServlet;
import xyz.myzsl.uedu.utils.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2021-06-09 20:54:07
 */
@WebServlet(urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void doAdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession();

        ReturnResult returnResult = new ReturnResult();

        //获取前端数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String imageCode = request.getParameter("imageCode");

        //从session中获取实际验证码
        String code = (String) session.getAttribute("code");
        if (imageCode != null && imageCode.equals(code)){
            User user = userService.getUserByUsernameAndPassword(username,password);
            if (user != null){
                if (user.getStatus() == 2){
                    //未被启用
                    returnResult.setMessage("当前用户未被启用");
                    returnResult.setStatus(-1);
                }else if (user.getStatus() == 1){
                    //账号已启用
                    if (user.getRole() == 1){
                        //是管理员
                        returnResult.setMessage("【"+user.getUsername()+"】登陆成功");
                        returnResult.setStatus(1);
                        returnResult.setData(user);
                        session.setAttribute("userSession", user);
                    }else {
                        //不是管理员
                        returnResult.setMessage("您不是管理员");
                        returnResult.setStatus(-1);
                    }
                }
            }else {
                //查询结果为空
                returnResult.setMessage("用户名或密码错误");
                returnResult.setStatus(-1);
            }
        }else {
            //验证码不正确
            returnResult.setMessage("验证码错误");
            returnResult.setStatus(-1);
        }

        response.getWriter().write(JSON.toJSONString(returnResult));

    }
}
