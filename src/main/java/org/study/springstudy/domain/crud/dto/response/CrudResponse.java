package org.study.springstudy.domain.crud.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CrudResponse {
    private String title;
    private String post;
    private String name;

    @Builder
    public CrudResponse(String title, String post, String name) {
        this.title = title;
        this.post = post;
        this.name = name;
    }
}
