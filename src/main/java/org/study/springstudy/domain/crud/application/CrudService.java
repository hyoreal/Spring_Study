package org.study.springstudy.domain.crud.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.study.springstudy.domain.crud.domain.Crud;
import org.study.springstudy.domain.crud.dto.request.CrudCreateRequest;
import org.study.springstudy.domain.crud.dto.request.CrudEditRequest;
import org.study.springstudy.domain.crud.repository.CrudRepository;

import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class CrudService {
    private final CrudRepository crudRepository;

    @Transactional
    public Crud create(CrudCreateRequest crudCreateRequest) {
        Crud crud = Crud.create(crudCreateRequest);
        return crudRepository.save(crud);
    }

    @Transactional
    public Crud edit(Long id, CrudEditRequest crudEditRequest) {
        Crud crud = crudRepository.findById(id).orElseThrow();
        crud.edit(crudEditRequest);
        return crudRepository.save(crud);
    }

    @Transactional(readOnly = true)
    public Crud readOne(Long id) {
        return crudRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Crud> read() {
        return crudRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Crud crud = crudRepository.findById(id).orElseThrow();
        crudRepository.delete(crud);
    }
}
