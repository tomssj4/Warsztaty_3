package pl.coderslab.controller.read;

import pl.coderslab.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solution-details")
public class ReadSolutionDetails extends HttpServlet {
    private SolutionDao solutionDao = new SolutionDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer solutionId = Integer.parseInt(request.getParameter("solutionId"));
        request.setAttribute("solution", solutionDao.loadById(solutionId));
        getServletContext().getRequestDispatcher("/WEB-INF/solution_details.jsp").forward(request, response);

    }
}
