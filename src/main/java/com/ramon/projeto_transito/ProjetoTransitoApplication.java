package com.ramon.projeto_transito;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ramon.projeto_transito.domain.Categoria;
import com.ramon.projeto_transito.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetoTransitoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTransitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Veiculo de Passageiros");
		Categoria cat2 = new Categoria(null, "Veículo de Carga");
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
		
	    // categoriaRepository.save(Arrays.asList(cat1, cat2));
		
	}

}
