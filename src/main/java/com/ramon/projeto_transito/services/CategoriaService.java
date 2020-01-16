package com.ramon.projeto_transito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.projeto_transito.domain.Categoria;
import com.ramon.projeto_transito.repositories.CategoriaRepository;
import com.ramon.projeto_transito.services.exceptions.DataIntegrityExceptions;
import com.ramon.projeto_transito.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id " + id + ", Tipo: " + Categoria.class.getName()));	
}	
	
		
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);		
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}catch (DataIntegrityExceptions e) {
			throw new DataIntegrityExceptions("Não é possível excluir uma Categoria que possui Veículos.");
		}
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
