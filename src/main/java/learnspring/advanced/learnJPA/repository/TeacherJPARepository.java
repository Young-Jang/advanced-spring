package learnspring.advanced.learnJPA.repository;

import learnspring.advanced.learnJPA.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJPARepository extends JpaRepository<Teacher,Long> {
}
