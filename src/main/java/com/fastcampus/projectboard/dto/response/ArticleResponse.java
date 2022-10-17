package com.fastcampus.projectboard.dto.response;

import com.fastcampus.projectboard.dto.ArticleDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ArticleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String hashtag;
    private final LocalDateTime createdAt;
    private final String email;
    private final String nickname;


    public static ArticleResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickName) {
        return new ArticleResponse(id, title, content, hashtag, createdAt, email, nickName);
    }


    public static ArticleResponse from(ArticleDto dto){

        String nickname = dto.getUserAccountDto().getNickname();
        if (nickname == null || nickname.isBlank()){
            nickname = dto.getUserAccountDto().getUserId();
        }

        return new ArticleResponse(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                dto.getHashtag(),
                dto.getCreatedAt(),
                dto.getUserAccountDto().getEmail(),
                nickname
        );
    }
}
