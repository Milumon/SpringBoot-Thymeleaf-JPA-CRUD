package pe.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "tbl_comment")
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id")
    private Long id;
    @Column(length = 150)
    private String commentPost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Column(name="post_id")
    private Long idPost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "post_id",insertable = false,updatable = false)
    private Post post;

}
