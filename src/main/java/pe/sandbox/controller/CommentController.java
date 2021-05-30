package pe.sandbox.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.sandbox.model.Comment;
import pe.sandbox.service.CommentService;
import pe.sandbox.service.PostService;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("/comments")
    public String commentList(Model model){
        model.addAttribute("comments",commentService.findAll() );
        return "comment";
    }

    @GetMapping("/comments/add")
    public String commentAdd(Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("posts", postService.findAll());
        return "comment-add";
    }

    @PostMapping("/comments/save")
    public String commentSave(Comment comment){
        commentService.createOrUpdate(comment);
        return "redirect:/comments";
    }

    @GetMapping("/comments/edit/{id}")
    public String commentEdit(@PathVariable Long id, Model model){
        model.addAttribute("comment", commentService.findById(id));
        model.addAttribute("posts", postService.findAll());
        return "comment-add";
    }

    @GetMapping("comments/delete/{id}")
    public String commentDelete(@PathVariable Long id){
        commentService.delete(id);
        return "redirect:/comments";
    }
    
}
