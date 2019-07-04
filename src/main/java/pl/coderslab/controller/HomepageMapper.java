package pl.coderslab.controller;

import pl.coderslab.models.Solution;
import pl.coderslab.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/")
public class HomepageMapper extends HttpServlet {
    private SolutionDao solutionDao = new SolutionDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("recent_solution_list", solutionDao.findRecent(Integer.parseInt(getServletContext().getInitParameter("number-solutions"))));
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
