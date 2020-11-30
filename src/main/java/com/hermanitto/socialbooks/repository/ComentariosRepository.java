package com.hermanitto.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hermanitto.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {
	
}
