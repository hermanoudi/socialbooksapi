package com.hermanitto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hermanitto.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
