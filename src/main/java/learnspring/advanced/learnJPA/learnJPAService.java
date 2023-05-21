package learnspring.advanced.learnJPA;

import learnspring.advanced.learnJPA.repository.StudentJPARepository;
import learnspring.advanced.learnJPA.repository.TeacherJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class learnJPAService {
    private final StudentJPARepository studentJPARepository;
    private final TeacherJPARepository teacherJPARepository;
}
