package by.it.academy.controller.addon;

import by.it.academy.controller.command.impl.AdminCommand;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminCourseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCourseDeleteServlet",
        urlPatterns = {"/adminCourseDelete"})
public class AdminCourseDeleteServlet extends HttpServlet {

    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/pages/adminCourseDelete.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("cancel") != null) {
            request.getRequestDispatcher("/home?pageName=adminCourse").forward(request, response);
        } else {
            Integer idAdminCourseForDelete = Integer.valueOf(request.getParameter("deleteAdminCourse"));
            adminService.deleteAdminCourse(idAdminCourseForDelete);
            request.getRequestDispatcher("/home?pageName=adminCourse").forward(request, response);
        }
    }

    }
