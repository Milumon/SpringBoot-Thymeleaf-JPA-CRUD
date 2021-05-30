package pe.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.sandbox.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
