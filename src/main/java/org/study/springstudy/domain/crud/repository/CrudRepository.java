package org.study.springstudy.domain.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.study.springstudy.domain.crud.domain.Crud;

@Repository
public interface CrudRepository extends JpaRepository<Crud, Long> {
}
