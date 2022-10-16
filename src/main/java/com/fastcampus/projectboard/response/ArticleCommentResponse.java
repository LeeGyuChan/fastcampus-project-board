package com.fastcampus.projectboard.response;

import com.fastcampus.projectboard.dto.ArticleCommentDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ArticleCommentResponse {

    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final String email;
    private final String nickname;


    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickName) {
        return new ArticleCommentResponse(id, content, createdAt, email, nickName);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto){

        String nickname = dto.getUserAccountDto().getNickname();
        if (nickname == null || nickname.isBlank()){
            nickname = dto.getUserAccountDto().getUserId();
        }

        return new ArticleCommentResponse(

                dto.getId(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getUserAccountDto().getEmail(),
                nickname
        );
    }
}
