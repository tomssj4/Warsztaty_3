package pl.coderslab.controller.edit;

import pl.coderslab.model.Classes.Exercise;
import pl.coderslab.model.Dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-exercise")
public class editExercise extends HttpServlet {
    private ExerciseDao exerciseDao = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exercise exercise = new Exercise(id, title, description);
        exerciseDao.update(exercise);

        response.sendRedirect(getServletContext().getContextPath() + "/read-exercises-admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        getServletContext().getRequestDispatcher("/WEB-INF/edit_exercise_form.jsp").forward(request, response);
    }
}
