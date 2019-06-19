package pl.coderslab.controller.read;

import pl.coderslab.model.Dao.SolutionDao;
import pl.coderslab.model.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-details")
public class readUserDetails extends HttpServlet {
    private UserDao userDao = new UserDao();
    private SolutionDao solutionDao = new SolutionDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        request.setAttribute("user_details", userDao.loadById(userId));
        request.setAttribute("list_of_user_solutions", solutionDao.findAllByUserId(userId));
        getServletContext().getRequestDispatcher("/WEB-INF/user_details.jsp").forward(request, response);
    }
}
