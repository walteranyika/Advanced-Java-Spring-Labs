package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "licenses")
@NoArgsConstructor
@Getter
@Setter
public class Licence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String number;

    private Date expiryDate;


}
