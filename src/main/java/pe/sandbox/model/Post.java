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
@Table(name = "tbl_post")
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="post_id")
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 40)
    private String descripcion;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;


    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
    private List<Comment> comments;
}
