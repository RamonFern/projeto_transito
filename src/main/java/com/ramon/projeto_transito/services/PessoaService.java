package com.ramon.projeto_transito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.projeto_transito.domain.Pessoa;
import com.ramon.projeto_transito.repositories.PessoaRepository;
import com.ramon.projeto_transito.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
                          "Objeto não encontrado! id " + id + ", Tipo: " + Pessoa.class.getName()));
	}
}
