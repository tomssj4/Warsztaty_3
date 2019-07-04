package pl.coderslab.controller.edit;

import pl.coderslab.models.Group;
import pl.coderslab.dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-group")
public class EditGroup extends HttpServlet {
    private GroupDao groupDao = new GroupDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String groupName = request.getParameter("name");
        Group group = new Group(id, groupName);
        groupDao.update(group);
        response.sendRedirect(getServletContext().getContextPath() + "/read-groups-admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        getServletContext().getRequestDispatcher("/WEB-INF/edit_group_form.jsp").forward(request, response);
    }
}
