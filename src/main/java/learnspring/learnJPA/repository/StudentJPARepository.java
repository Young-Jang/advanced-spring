package learnspring.learnJPA.repository;

import learnspring.learnJPA.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<Student,Long> {
}
