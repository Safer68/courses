package by.it.academy.services.impl;

import by.it.academy.repository.dao.*;
import by.it.academy.repository.entity.Admin;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.entity.Task;
import by.it.academy.repository.util.HibernateUtil;
import by.it.academy.services.AdminService;
import by.it.academy.services.dto.AdminCourseDto;
import by.it.academy.services.dto.AdminDto;
import by.it.academy.services.dto.AdminMentorDto;
import by.it.academy.services.dto.TaskDto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {

    @Override
    public List<AdminDto> showAllAdminDto() {
        List<AdminDto> result = null;
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        result = adminDao.findAll().stream()
                .map(AdminDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return result;
    }

    @Override
    public AdminDto findById(Integer adminId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        AdminDto adminDto = new AdminDto(adminDao.findById(adminId));
        adminDao.closeDao();
        return adminDto;
    }

    @Override
    public void updateAdmin(Integer adminId, String newName) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        Admin admin = adminDao.findById(adminId);
        admin.setAdminName(newName);
        adminDao.update(admin);
        adminDao.closeDao();
    }


    @Override
    public List<AdminCourseDto> allCourseFromAdmin(Integer adminId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        List<AdminCourseDto> courseFromAdmin = null;
        courseFromAdmin = adminDao.showAllCourseAdmin(adminId).stream()
                .map(AdminCourseDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return courseFromAdmin;
    }

    @Override
    public List<AdminMentorDto> allMentorFromAdmin(Integer mentorId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        List<AdminMentorDto> mentorFromAdmin = null;
        mentorFromAdmin = adminDao.showAllMentorAdmin(mentorId).stream()
                .map(AdminMentorDto::new)
                .collect(Collectors.toList());
        adminDao.closeDao();
        return mentorFromAdmin;
    }

    @Override
    public void createAdmin(String nameCourse)
            throws SecurityException {
        EntityDao<Admin> adminEntityDao = DaoProvider.getInstance().getAdminDao();
        Admin newAdmin = Admin.builder()
                .adminName(nameCourse)
                .build();
        adminEntityDao.save(newAdmin);
        adminEntityDao.closeDao();
    }

    public void deleteAdmin(Integer adminId) {
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        adminDao.delete(adminId);
        adminDao.closeDao();
    }


    @Override
    public void createCourse(String nameCourse)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        Course course = Course.builder()
                .courseProgram(nameCourse)
                .build();
        courseEntityDao.save(course);
        courseEntityDao.closeDao();
    }

    /**
     * @param idCourse
     */
    @Override
    public void deleteCourseById(int idCourse)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        List<Course> listCourse = courseEntityDao.findAll();
        for (int i = 0; i < listCourse.size(); i++) {
            System.out.println((listCourse.get(i)).toString());
        }
        System.out.println(
                "Choose id of a mentor which do you prefer dismiss:");

        if (courseEntityDao.findById(idCourse) != null) {
            courseEntityDao.delete(idCourse);
            System.out.println("Course deleted with a input id.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void deleteCourseByName()
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        List<Course> listCourse = courseEntityDao.findAll();
        for (int i = 0; i < listCourse.size(); i++) {
            System.out.println((listCourse.get(i)).toString());
        }
        System.out.println(
                "Choose id of a course which do you prefer dismiss:");
        Scanner scanner = new Scanner(System.in);
        int idCourse = scanner.nextInt();

        if (courseEntityDao.findById(idCourse) != null) {
            courseEntityDao.delete(idCourse);
            System.out.println("Course deleted.");
        }

        courseEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void createMentor(String nameMentor)
            throws SecurityException {
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        Mentor mentor = Mentor.builder()
                .mentorName(nameMentor)
                .build();
        mentorEntityDao.save(mentor);
        mentorEntityDao.closeDao();
    }

    /**
     * @param idMentor
     */
    @Override
    public void deleteMentorById(int idMentor)
            throws SecurityException {
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        if (mentorEntityDao.findById(idMentor) != null) {
            mentorEntityDao.delete(idMentor);
            System.out.println("Mentor deleted with a input id.");
        } else {
            System.out.println("Mentor doesn't exist!");
        }
        mentorEntityDao.closeDao();
    }


    /**
     *
     */
    @Override
    public void deleteMentorByName()
            throws SecurityException {
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        List<Mentor> listMentor = mentorEntityDao.findAll();
        for (int i = 0; i < listMentor.size(); i++) {
            System.out.println((listMentor.get(i)).toString());
        }
        System.out.println(
                "Choose id of a mentor which do you prefer dismiss:");
        Scanner scanner = new Scanner(System.in);
        int idMentor = scanner.nextInt();
        if (mentorEntityDao.findById(idMentor) != null) {
            List<Course> courseList = getListMentor(mentorEntityDao
                    .findById(idMentor).getMentorName());
            for (Course course : courseList) {
                course.setMentorField(null);
                EntityDao<Course> courseEntityDao =
                        DaoProvider.getInstance().getCourseDao();
                courseEntityDao.update(course);
            }
            mentorEntityDao.delete(idMentor);
            System.out.println("Mentor deleted.");
        }
        mentorEntityDao.closeDao();
    }

    /**
     *
     */
    @Override
    public void insertMentorToCourse(int idCourse, int idMentor)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        if (courseEntityDao.findById(idCourse) != null
                && mentorEntityDao.findById(idMentor) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Mentor mentor = mentorEntityDao.findById(idMentor);
            course.setMentorField(mentor);
            courseEntityDao.save(course);
            System.out.println("Mentor was added on course");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    /**
     * @param idAdmin
     */
    @Override
    public void takeCourseForControl(int idAdmin)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        EntityDao<Admin> adminEntityDao =
                DaoProvider.getInstance().getAdminDao();
        System.out.println("Введите id курса:");
        Scanner scanner = new Scanner(System.in);
        int idCourse = scanner.nextInt();
        if (courseEntityDao.findById(idCourse) != null
                && adminEntityDao.findById(idAdmin) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Admin admin = adminEntityDao.findById(idAdmin);
            course.setAdminField(admin);
            courseEntityDao.save(course);
            System.out.println("Admin was added on course");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();

    }

    @Override
    public void updateMentorToCourse(int idCourse, int idMentor)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        EntityDao<Mentor> mentorEntityDao =
                DaoProvider.getInstance().getMentorDao();
        if (courseEntityDao.findById(idCourse) != null
                && mentorEntityDao.findById(idMentor) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Mentor mentor = mentorEntityDao.findById(idMentor);
            course.setMentorField(mentor);
            courseEntityDao.update(course);
            System.out.println("Update mentor.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    @Override
    public void updateAdminToCourse(int idCourse, int idAdmin)
            throws SecurityException {
        EntityDao<Course> courseEntityDao =
                DaoProvider.getInstance().getCourseDao();
        EntityDao<Admin> adminEntityDao =
                DaoProvider.getInstance().getAdminDao();
        if (courseEntityDao.findById(idCourse) != null
                && adminEntityDao.findById(idAdmin) != null) {
            Course course = courseEntityDao.findById(idCourse);
            Admin admin = adminEntityDao.findById(idAdmin);
            course.setAdminField(admin);
            courseEntityDao.update(course);
            System.out.println("Update admin.");
        } else {
            System.out.println("Course doesn't exist!");
        }
        courseEntityDao.closeDao();
    }

    private List<Course> getListMentor(String mentor)
            throws SecurityException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager
                .createQuery("SELECT E.courses FROM Mentor E " +
                        "WHERE E.mentorName = :mentor");
        query.setParameter("mentor", mentor);
        List<Course> courseList = query.getResultList();
        entityManager.close();
        return courseList;
    }


    @Override
    public List<Admin> findAllAdmin() {
        List<Admin> admins = null;
        AdminDao adminDao = DaoProvider.getInstance().getAdminDao();
        admins = adminDao.findAll();
        adminDao.closeDao();
        return admins;
    }

}
