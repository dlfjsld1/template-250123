package com.example.template.domain.post.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/write")
    @ResponseBody
    public String showWrite() {
        return """
                <form method="post">
                    <input type="text" name="title" placeholders="제목" />
                    </br>
                    <textarea name="content" placeholders="내용"></textarea>
                    </br>
                    <input type="submit" value="등록" />
                </form>
                """;
    }

    @PostMapping("/write")
    @ResponseBody
    public String doWrite(String title, String content) {
        if(title.isBlank() || title == null) {
            return "제목을 입력해주세요.";
        } else if(content.isBlank() || content == null) {
            return "내용을 입력해주세요.";
        }
        return """
                <h1>게시물 조회</h1>
                <h2>제목 : %s</h2>
                </br>
                <h3>내용 : %s</h3>
                """.formatted(title, content);
    }
}
