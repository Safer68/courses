package by.it.academy.controller.addon;

import by.it.academy.repository.entity.Admin;
import by.it.academy.services.AdminService;
import by.it.academy.services.ServiceProvider;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.CourseDto;
import by.it.academy.services.dto.TaskDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "updateAdmin", value = "/updateUpdate")
public class UpdateAdmin extends HttpServlet {
//    private final AdminService adminService = ServiceProvider.getInstance().getAdminService();
//    private final String ADMIN = "admin";
//    Integer adminId;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        adminId = Integer.valueOf(request.getParameter("adminId"));
//        AdminDto admin = adminService.findById(adminId);
//        List<Admin> adminList = adminService.findAllAdmin();
//        request.getSession().setAttribute(ADMIN,admin);
//        request.getRequestDispatcher("WEB-INF/view/pages/updateAdmin.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String newNameAdmin = request.getParameter("Name");
//        adminService.updateAdmin(adminId,newNameAdmin);
//        request.getRequestDispatcher("/home?pageName=admin").forward(request, response);
    }
}
