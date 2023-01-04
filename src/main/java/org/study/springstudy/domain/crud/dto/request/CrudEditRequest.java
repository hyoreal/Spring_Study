package org.study.springstudy.domain.crud.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CrudEditRequest {
    private String title;
    private String post;
    private String name;

    @Builder
    public CrudEditRequest(String title, String post, String name) {
        this.title = title;
        this.post = post;
        this.name = name;
    }
}
