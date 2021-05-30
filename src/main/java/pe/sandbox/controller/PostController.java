package pe.sandbox.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.sandbox.model.Post;
import pe.sandbox.service.PostService;
import pe.sandbox.service.UserService;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/posts")
    public String postList(Model model){
        model.addAttribute("posts",postService.findAll() );
        return "post";
    }

    @GetMapping("/posts/add")
    public String postAdd(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("users", userService.findAll());
        return "post-add";
    }

    @PostMapping("/posts/save")
    public String postSave(Post post){
        postService.createOrUpdate(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String postEdit(@PathVariable Long id, Model model){
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "post-add";
    }

    @GetMapping("posts/delete/{id}")
    public String postDelete(@PathVariable Long id){
        postService.delete(id);
        return "redirect:/posts";
    }
}
