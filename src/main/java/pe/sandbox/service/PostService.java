package pe.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.sandbox.model.Post;
import pe.sandbox.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void createOrUpdate(Post post){
        postRepository.save(post);
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }

    public Post findById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

}
