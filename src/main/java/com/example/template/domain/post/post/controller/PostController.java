package com.example.template.domain.post.post.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Getter
    @AllArgsConstructor
    public static class WriteForm {
        @NotBlank(message ="제목을 입력하세요.") //<--이게 valid
        @Length(min = 5, message= "제목을 5자 이상 입력하세요.") //<--이게 valid
        private String title;
        @NotBlank(message = "내용을 입력하세요.")
        @Length(min = 10, message = "내용을 10자 이상 입력하세요.")
        private String content;
    }

    @PostMapping("/write")
    @ResponseBody
    public String doWrite(
        @ModelAttribute //인자를 객체로 받겠다
        @Valid //valid를 활성화 시켜줌
        WriteForm form
    ) {

        return """
                <div>
                <h1>게시물 조회</h1>
                <h2>제목 : %s</h2>
                </br>
                <h3>내용 : %s</h3>
                </div>
                """.formatted(form.getTitle(), form.getContent());
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
