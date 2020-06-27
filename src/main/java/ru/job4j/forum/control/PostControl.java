package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @RequestMapping(value="/post/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "post";
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String save(@ModelAttribute Post post) {
        return "create";
    }

    @RequestMapping(value="/post/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Post post) {
        //posts.create(post);
        //return "redirect:/post/" + post.getId();
        return "redirect:/index";
    }
}