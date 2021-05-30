package pe.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.sandbox.model.Comment;
import pe.sandbox.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createOrUpdate(Comment comment){
        commentRepository.save(comment);
    }

    public void delete(Long id){
        commentRepository.deleteById(id);
    }

    public Comment findById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
}
