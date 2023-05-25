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
public class learnJPAService {
    private final StudentJPARepository studentJPARepository;
    private final TeacherJPARepository teacherJPARepository;

    @Transactional
    public void saveTestData(){
        List<String> teacherNameList = new ArrayList<>();
        teacherNameList.add("jang");
        teacherNameList.add("young");
        Student student = new Student("YJ",teacherNameList);
        studentJPARepository.save(student);
    }
}
