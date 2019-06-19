package pl.coderslab.controller.Admin;

import pl.coderslab.model.Dao.ExerciseDao;
import pl.coderslab.model.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/read-exercises-admin")
public class readAllExercisesAdmin extends HttpServlet {
    private ExerciseDao exerciseDao = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("exercise_list", exerciseDao.findAllExercises());
            getServletContext().getRequestDispatcher("/WEB-INF/exercise_list_admin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
