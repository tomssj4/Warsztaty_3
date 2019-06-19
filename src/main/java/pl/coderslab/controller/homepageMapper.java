package pl.coderslab.controller;

import pl.coderslab.model.Classes.Solution;
import pl.coderslab.model.Dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/")
public class homepageMapper extends HttpServlet {
    private SolutionDao solutionDao = new SolutionDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String createdTime = String.format("%tF tT", LocalDateTime.now());
        Solution solution = new Solution(createdTime, "", "aaa", 1, 1);
        try {
            request.setAttribute("recent_solution_list", solutionDao.findRecent(Integer.parseInt(getServletContext().getInitParameter("number-solutions"))));
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
