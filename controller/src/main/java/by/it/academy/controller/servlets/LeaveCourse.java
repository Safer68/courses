package by.it.academy.controller.servlets;

import by.it.academy.services.ServiceProvider;
import by.it.academy.services.StudentService;
import by.it.academy.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "leaveCourse", value = "/leaveCourse")
public class LeaveCourse extends HttpServlet {
    private final StudentService studentService = ServiceProvider.getInstance().getStudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer studentId = Integer.valueOf(request.getParameter("studentId"));
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));

        studentService.leaveCourse(studentId,courseId);

        response.sendRedirect(request.getContextPath() + "/studentCourses?studentId=" + studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
