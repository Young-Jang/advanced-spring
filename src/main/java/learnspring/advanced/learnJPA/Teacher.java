package learnspring.advanced.learnJPA;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private List<Enrollment> enrollments = new ArrayList<>();


    public Teacher(String name, List<String> studentName){
        this.name = name;
        this.enrollments = studentName.stream().map(n->new Enrollment(n,name)).collect(Collectors.toList());
    }
    // 생성자, getter, setter, 기타 메소드
}
