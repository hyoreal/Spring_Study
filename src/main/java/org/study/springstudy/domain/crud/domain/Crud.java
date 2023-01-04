package org.study.springstudy.domain.crud.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.study.springstudy.domain.crud.dto.request.CrudCreateRequest;
import org.study.springstudy.domain.crud.dto.request.CrudEditRequest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "crud")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", updatable = false)
    private String title;

    @Column(name = "post", updatable = false, columnDefinition = "TEXT")
    private String post;

    @Column(name = "name", updatable = false)
    private String name;

    @CreatedDate
    @Column(name = "date", updatable = false)
    private LocalDateTime date;

    @Builder
    public Crud(Long id, String title, String post, String name) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.name = name;
    }

    public static Crud create(CrudCreateRequest crudCreateRequest) {
        return Crud.builder()
                .id(crudCreateRequest.getId())
                .title(crudCreateRequest.getTitle())
                .post(crudCreateRequest.getPost())
                .name(crudCreateRequest.getName())
                .build();
    }

    public void edit(CrudEditRequest crudEditRequest) {
        this.title = crudEditRequest.getTitle() == null ? this.getTitle() : crudEditRequest.getTitle();
        this.post = crudEditRequest.getPost() == null ? this.getPost() : crudEditRequest.getPost();
        this.name = crudEditRequest.getName() == null ? this.getName() : crudEditRequest.getName();
    }
}
