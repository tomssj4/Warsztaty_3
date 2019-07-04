package pl.coderslab.controller.read;

import pl.coderslab.dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/read-groups")
public class ReadAllGroups extends HttpServlet {
    private GroupDao groupDao = new GroupDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("group_list", groupDao.loadAll());
        getServletContext().getRequestDispatcher("/WEB-INF/group_list.jsp").forward(request, response);
    }
}
