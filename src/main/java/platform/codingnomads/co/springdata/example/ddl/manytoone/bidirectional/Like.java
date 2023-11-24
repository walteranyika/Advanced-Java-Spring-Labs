package platform.codingnomads.co.springdata.example.ddl.manytoone.bidirectional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import platform.codingnomads.co.springdata.example.ddl.manytoone.unidirectional.usingmanytoone.Post;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Post post;
}
