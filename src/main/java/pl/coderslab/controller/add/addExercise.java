package pl.coderslab.controller.add;

import pl.coderslab.model.Classes.Exercise;
import pl.coderslab.model.Classes.User;
import pl.coderslab.model.Dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-exercise")
public class addExercise extends HttpServlet {
    private ExerciseDao exerciseDao = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exercise exercise = new Exercise(title, description);
        exerciseDao.create(exercise);

        response.sendRedirect(getServletContext().getContextPath() + "/read-exercises-admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/add_exercise_form.jsp").forward(request, response);

    }
}
