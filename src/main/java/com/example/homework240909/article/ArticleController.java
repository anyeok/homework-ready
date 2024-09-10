package com.example.homework240909.article;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String articlelist(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return  "article_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
    @GetMapping("/create")
    public String articleCreate() {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate (@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        this.articleService.create(subject, content);
        return "redirect:/article/list";
    }
}
