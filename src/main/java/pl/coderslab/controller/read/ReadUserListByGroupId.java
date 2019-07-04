package pl.coderslab.controller.read;

import pl.coderslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/group-users")
public class ReadUserListByGroupId extends HttpServlet {


    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer groupId = Integer.parseInt(request.getParameter("groupId"));
        request.setAttribute("user_list_by_group_id", userDao.findAllByGroupID(groupId));
        getServletContext().getRequestDispatcher("/WEB-INF/user_list_by_group_id.jsp").forward(request, response);
    }
}
