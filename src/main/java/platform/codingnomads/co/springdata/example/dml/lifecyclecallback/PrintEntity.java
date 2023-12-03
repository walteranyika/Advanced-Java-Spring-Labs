package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Transient
    private String formattedTitle;
    // write your methods here

    @PrePersist
    @PreUpdate
    private void fixTittleCasing(){
        System.out.println("CAPITALIZING TITLE BEFORE PERSISTING");
        this.title = title.trim().toUpperCase();
    }

    @PostLoad
    private void formattedTitle(){
        formattedTitle = this.getTitle() +" "+id;
    }
}
