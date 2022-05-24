package by.it.academy.services;

import by.it.academy.repository.entity.Admin;
import by.it.academy.services.dto.*;

import java.util.List;
import java.util.Optional;

import by.it.academy.services.dto.AdminMentorDto;

public interface AdminService {

    List<AdminDto> showAllAdminDto();

    List<AdminCourseDto> allCourseFromAdmin(Integer adminId);

    List<AdminMentorDto> allMentorFromAdmin(Integer mentorId);

    void createAdmin(String nameCourse) throws SecurityException;

    void deleteAdmin(Integer adminId);

    void deleteAdminCourse(int idCourse) throws SecurityException;

    void deleteAdminMentor(int idMentor) throws SecurityException;

    void createCourse(String nameCourse) throws SecurityException;

    AdminDto findById(Integer adminId);

    void updateAdmin(Integer adminId, String newName);

    void createMentor(String nameMentor) throws SecurityException;


    List<Admin> findAllAdmin();

}
