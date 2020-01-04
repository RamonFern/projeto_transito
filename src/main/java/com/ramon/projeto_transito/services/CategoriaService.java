package com.ramon.projeto_transito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.projeto_transito.domain.Categoria;
import com.ramon.projeto_transito.repositories.CategoriaRepository;
import com.ramon.projeto_transito.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
                          "Objeto não encontrado! id " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
