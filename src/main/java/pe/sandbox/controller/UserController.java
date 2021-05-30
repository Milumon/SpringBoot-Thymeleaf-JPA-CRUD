package pe.sandbox.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.sandbox.model.User;
import pe.sandbox.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "user";
    }

    @GetMapping("/users/add")
    public String userAdd(Model model){
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/users/save")
    public String userSave(User user){
        userService.createOrUpdate(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")

    public String userDelete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";

    }

    @GetMapping("users/edit/{id}")
    public String userEdit(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user-add";
    }

    
}
