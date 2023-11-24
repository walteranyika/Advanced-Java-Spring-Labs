package platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingonetomany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writers")
@NoArgsConstructor
@AllArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;

    @OneToMany
    @JoinColumn(name = "writer_id")
    private List<Post> posts;
}
