package com.hermanitto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hermanitto.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{


}
