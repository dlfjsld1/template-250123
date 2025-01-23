package com.example.template.domain.post.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/write")
    @ResponseBody
    public String write() {
        return """
                <form action="/showWrite">
                    <input type="text" name="title" placeholders="제목" />
                    </br>
                    <textarea name="content" placeholders="내용"></textarea>
                    </br>
                    <input type="submit" value="등록" />
                </form>
                """;
    }
}
