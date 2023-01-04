package org.study.springstudy.domain.crud.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.springstudy.domain.crud.application.CrudService;
import org.study.springstudy.domain.crud.domain.Crud;
import org.study.springstudy.domain.crud.dto.request.CrudCreateRequest;
import org.study.springstudy.domain.crud.dto.request.CrudEditRequest;
import org.study.springstudy.domain.crud.dto.response.CrudResponse;

@RestController
@RequiredArgsConstructor
public class CrudController {
    private final CrudService crudService;

    @PostMapping("/crud")
    public ResponseEntity<CrudResponse> create(@RequestBody CrudCreateRequest crudCreateRequest) {
        Crud crud = crudService.create(crudCreateRequest);
        CrudResponse response = CrudResponse.builder()
                .title(crud.getTitle())
                .post(crud.getPost())
                .name(crud.getName())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/crud/{id}")
    public ResponseEntity<CrudResponse> edit(@PathVariable Long id, @RequestBody CrudEditRequest crudEditRequest) {
        Crud crud = crudService.edit(id, crudEditRequest);
        CrudResponse response = CrudResponse.builder()
                .title(crud.getTitle())
                .post(crud.getPost())
                .name(crud.getName())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/crud")
    public ResponseEntity readAll() {
        return new ResponseEntity(crudService.read(), HttpStatus.OK);
    }

    @GetMapping("/crud/{id}")
    public ResponseEntity<CrudResponse> readOne(@PathVariable Long id) {
        Crud crud = crudService.readOne(id);
        CrudResponse response = CrudResponse.builder()
                .title(crud.getTitle())
                .post(crud.getPost())
                .name(crud.getName())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/crud/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        crudService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
