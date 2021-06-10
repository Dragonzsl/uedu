package xyz.myzsl.uedu.servlet;

import com.alibaba.fastjson.JSON;
import xyz.myzsl.uedu.bean.User;
import xyz.myzsl.uedu.service.UserService;
import xyz.myzsl.uedu.service.impl.UserServiceImpl;
import xyz.myzsl.uedu.utils.BaseServlet;
import xyz.myzsl.uedu.utils.Page;
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
        System.out.println(username + " " + password);
        //从session中获取实际验证码
        String code = (String) session.getAttribute("code");
        System.out.println(code);
        System.out.println(imageCode);
        if (imageCode != null && imageCode.equals(code)) {
            User user = userService.getUserByUsernameAndPassword(username, password);
            if (user != null) {
                if (user.getStatus() == 2) {
                    //未被启用
                    returnResult.setMessage("当前用户未被启用");
                    returnResult.setStatus(-1);
                } else if (user.getStatus() == 1) {
                    //账号已启用
                    if (user.getRole() == 1) {
                        //是管理员
                        returnResult.setMessage("【" + user.getUsername() + "】登陆成功");
                        returnResult.setStatus(1);
                        returnResult.setData(user);
                        session.setAttribute("userAdminSession", user);
                    } else {
                        //不是管理员
                        returnResult.setMessage("您不是管理员");
                        returnResult.setStatus(-1);
                    }
                }
            } else {
                //查询结果为空
                returnResult.setMessage("用户名或密码错误");
                returnResult.setStatus(-1);
            }
        } else {
            //验证码不正确
            returnResult.setMessage("验证码错误");
            returnResult.setStatus(-1);
        }

        response.getWriter().write(JSON.toJSONString(returnResult));

    }

    protected void doGetUserLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReturnResult returnResult = new ReturnResult();
        User userAdmin = (User) request.getSession().getAttribute("userAdminSession");
        System.out.println(userAdmin);
        if (userAdmin != null) {
            returnResult.setMessage(userAdmin.getUsername());
            returnResult.setStatus(1);
        } else {
            returnResult.setMessage("请先登录");
            returnResult.setStatus(-1);
        }
        response.getWriter().write(JSON.toJSONString(returnResult));
    }

    protected void doLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        ReturnResult returnResult = new ReturnResult("退出成功,即将跳往登陆页面", 1, null);
        response.getWriter().write(JSON.toJSONString(returnResult));
    }

    protected void doPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReturnResult returnResult;
        String search = request.getParameter("search");
        String pageSize = request.getParameter("pageSize");
        String currentPage = request.getParameter("currentPage");
        System.out.println(search + "" + pageSize + "" + currentPage);
        Page<User> page = userService.getUserListForPage(search, pageSize, currentPage);
        System.out.println(page);
        if (page != null && page.getList() != null && page.getList().size() != 0) {
            returnResult = new ReturnResult("查询成功", 1, page);
        } else {
            returnResult = new ReturnResult("查询失败", -1, null);
        }
        response.getWriter().write(JSON.toJSONString(returnResult));
    }

    protected void doAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReturnResult returnResult;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        Integer result = userService.addUser(username, password, name, phone, status, role, age, sex);
        if (result == 1) {
            //添加成功
            returnResult = new ReturnResult("添加成功", 1, null);
        } else {
            returnResult = new ReturnResult("添加失败", -1, null);
        }
        response.getWriter().write(JSON.toJSONString(returnResult));
    }

    protected void doCheckUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = userService.getUserByUsername(username);
        ReturnResult returnResult = new ReturnResult();
        if (user != null){
            returnResult.setMessage("该用户已存在");
            returnResult.setStatus(-1);
        }else {
            returnResult.setStatus(1);
        }
        response.getWriter().write(JSON.toJSONString(returnResult));
    }
}
