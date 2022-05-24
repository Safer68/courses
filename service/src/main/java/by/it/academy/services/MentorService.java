package by.it.academy.services;

import by.it.academy.repository.entity.Assessment;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.entity.Task;

import java.util.List;
import java.util.Optional;

public interface MentorService {
    void createTask(int courseId, Task task) throws SecurityException;

    void createAssessment(int taskId, Assessment assessment) throws SecurityException;

    void updateAssessment(Assessment assessment) throws SecurityException;

    List<Mentor> findAllMentor();

    void deleteById(Integer id);

    void save(String name, String[] courses, String[] admin);

    void update(String mentorId, String name, String[] courses, String[] admin);

    Optional<Mentor> findMentorById(Integer id);
}
