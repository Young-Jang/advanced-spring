package learnspring.learnJPA.repository;

import learnspring.learnJPA.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJPARepository extends JpaRepository<Teacher,Long> {
}
