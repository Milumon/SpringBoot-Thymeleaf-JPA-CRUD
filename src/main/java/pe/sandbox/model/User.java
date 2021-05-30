package pe.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="user_id")
    private Long id;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 30)
    private String nickname;

    @Column(length = 40)
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Post> posts;

}
