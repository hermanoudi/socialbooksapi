package com.hermanitto.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermanitto.socialbooks.domain.Autor;
import com.hermanitto.socialbooks.repository.AutoresRepository;
import com.hermanitto.socialbooks.services.excpetions.AutorExistenteException;
import com.hermanitto.socialbooks.services.excpetions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		
		if (autor != null && autor.getId() != null) {
			Autor a = autoresRepository.findById(autor.getId()).orElse(null);
			
			if (a != null) {
				throw new AutorExistenteException("O Autor já existe");
			}
		}
		
		return autoresRepository.save(autor);
		
	}
	
	public Autor buscar(Long id) {
		
		Autor autor = autoresRepository.findById(id).orElse(null);
		
		if (autor == null) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado.");
		}
		
		return autor;
	}
	
}
