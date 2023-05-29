package learnspring.advanced.learnJPA;

import learnspring.advanced.learnJPA.repository.StudentJPARepository;
import learnspring.advanced.learnJPA.repository.TeacherJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LearnJPAService {
    private final StudentJPARepository studentJPARepository;
    private final TeacherJPARepository teacherJPARepository;

    @Transactional
    public Student saveStudent(){
        List<String> teacherNameList = new ArrayList<>();
        teacherNameList.add("jang");
        teacherNameList.add("young");
        Student student = new Student("YJ",teacherNameList);
        return studentJPARepository.save(student);
    }

    @Transactional
    public Teacher saveTeacher(){
        List<String> studentNameList = new ArrayList<>();
        studentNameList.add("YJ");
        Teacher teacher = new Teacher("jang",studentNameList);
        return teacherJPARepository.save(teacher);
    }
}
