package pl.coderslab.controller.edit;

import pl.coderslab.models.User;
import pl.coderslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-user")
public class EditUser extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer groupId = Integer.parseInt(request.getParameter("group_id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = new User(id, groupId, username, email);
        userDao.update(user);
        response.sendRedirect(getServletContext().getContextPath() + "/read-users-admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        getServletContext().getRequestDispatcher("/WEB-INF/edit_user_form.jsp").forward(request, response);

    }
}
