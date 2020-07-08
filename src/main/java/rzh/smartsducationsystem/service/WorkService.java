package rzh.smartsducationsystem.service;

import rzh.smartsducationsystem.model.Course;
import rzh.smartsducationsystem.model.Teacher;

public interface WorkService {
    void createWork(String jsonData, Course course, Teacher teacher);
}
