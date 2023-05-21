package learnspring.advanced.learnJPA.repository;

import learnspring.advanced.learnJPA.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<Student,Long> {
}
