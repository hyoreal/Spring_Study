package org.study.springstudy.domain.crud.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CrudCreateRequest {
    private Long id;
    private String title;
    private String post;
    private String name;

    @Builder
    public CrudCreateRequest(Long id, String title, String post, String name) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.name = name;
    }
}
