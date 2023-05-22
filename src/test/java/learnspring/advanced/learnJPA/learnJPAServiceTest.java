package learnspring.advanced.learnJPA;

import learnspring.advanced.learnJPA.repository.StudentJPARepository;
import learnspring.advanced.learnJPA.repository.TeacherJPARepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class learnJPAServiceTest {

    @Autowired
    private StudentJPARepository studentJPARepository;
    @Autowired
    private TeacherJPARepository teacherJPARepository;

    @Test
    @Rollback(false)
    @Order(1)
    void associatedTest(){
        List<String> teacherNameList = new ArrayList<>();
        teacherNameList.add("jang");
        teacherNameList.add("young");
        Student student = new Student("YJ",teacherNameList);
        studentJPARepository.save(student);
    }


    @Test
    @Rollback(false)
    @Order(2)
    void associatedfindByTest(){
        Optional<Student> student = studentJPARepository.findById(1L);
        student.ifPresent(student1 -> {
            assertEquals(student.get().getEnrollments().get(0).getTeacherId(),"jang");
            assertEquals(student.get().getEnrollments().get(1).getTeacherId(),"young");
        });
    }

}