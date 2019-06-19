package pl.coderslab.controller.add;

import pl.coderslab.model.Classes.Group;
import pl.coderslab.model.Dao.ExerciseDao;
import pl.coderslab.model.Dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-group")
public class addGroup extends HttpServlet {
    private GroupDao groupDao = new GroupDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String groupName = request.getParameter("name");
        Group group = new Group(groupName);
        groupDao.create(group);

        response.sendRedirect(getServletContext().getContextPath() + "/read-groups-admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
getServletContext().getRequestDispatcher("/WEB-INF/add_group_form.jsp").forward(request, response);
    }
}
