package platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "fruits")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private  boolean sweet;
}
