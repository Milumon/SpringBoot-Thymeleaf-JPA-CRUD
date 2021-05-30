package pe.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.sandbox.model.User;
import pe.sandbox.repository.UserRepository;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public void createOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
