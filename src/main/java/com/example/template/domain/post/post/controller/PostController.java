package com.example.template.domain.post.post.controller;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
@Validated
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
    public String doWrite(
        @NotBlank
        @Length(min = 5)
        String title, //null이면 안 되고 5글자 이상이어야 함
        @NotBlank
        @Length(min = 10)
        String content //null이면 안되고 10글자 이사이어야 함
    ) {

//
//        if(title.isBlank() || title == null) {
//            return getFromHtml("제목을 입력해주세요.");
//        }
//        if(content.isBlank() || content == null) {
//            return getFromHtml("내용을 입력해주세요.");
//        }
//        if(title.length() < 5) {
//            return getFromHtml("제목을 5자 이상 입력해주세요.");
//        }
//        if(content.length() < 10) {
//            return getFromHtml("내용을 10자 이상 입력해주세요.");
//        }

        return """
                <div>
                <h1>게시물 조회</h1>
                <h2>제목 : %s</h2>
                </br>
                <h3>내용 : %s</h3>
                </div>
                """.formatted(title, content);
    }

    private String getFromHtml(String errorMsg) {

        return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholders="제목" />
                    </br>
                    <textarea name="content" placeholders="내용"></textarea>
                    </br>
                    <input type="submit" value="등록" />
                </form>
                """.formatted(errorMsg);

    }
}
