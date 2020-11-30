package com.hermanitto.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hermanitto.socialbooks.domain.Comentario;
import com.hermanitto.socialbooks.domain.Livro;
import com.hermanitto.socialbooks.repository.ComentariosRepository;
import com.hermanitto.socialbooks.repository.LivrosRepository;
import com.hermanitto.socialbooks.services.excpetions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentarioRepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("O Livro não pode ser encontrado.");
		}
		
		return livro;
	}
	
	public void deletar(Long id) {
		
		try {
			
			livrosRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado");
		}
		
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		
		return livrosRepository.save(livro);
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	} 
	
	private void verificarExistencia(Livro livro){
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long idLivro, Comentario comentario) {
		Livro livro = buscar(idLivro);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentarioRepository.save(comentario);
		
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
	
	
}
