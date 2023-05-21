package learnspring.advanced.learnJPA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@Table(name = "students")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String name, List<String> teacherName){
        this.name = name;
        this.enrollments = teacherName.stream().map(n->new Enrollment(name,n)).collect(Collectors.toList());
    }

}
