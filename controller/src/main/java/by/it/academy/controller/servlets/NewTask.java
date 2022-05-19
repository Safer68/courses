package by.it.academy.controller;

import by.it.academy.services.CourseService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.CourseDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "newTask", value = "/newTask")
public class NewTask extends HttpServlet {
    private final TaskService taskService = ServiceProvider.getInstance().taskService();
    private final CourseService courseService = ServiceProvider.getInstance().getCourseService();
    public static final String COURSES = "courses";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CourseDto> courseDtos = courseService.findAllCourseDto();
        request.getSession().setAttribute(COURSES,courseDtos);
        request.getRequestDispatcher("WEB-INF/view/pages/newTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        Integer course = Integer.valueOf(request.getParameter("Course"));
        taskService.createTask(name, course);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>First</title></head>");
        printWriter.println("<body><h1>Task created!</h1>");
        printWriter.println("</body></html>");
    }
}
