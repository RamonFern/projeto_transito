package com.ramon.projeto_transito;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ramon.projeto_transito.domain.Categoria;
import com.ramon.projeto_transito.domain.Veiculo;
import com.ramon.projeto_transito.repositories.CategoriaRepository;
import com.ramon.projeto_transito.repositories.VeiculoRepository;

@SpringBootApplication
public class ProjetoTransitoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTransitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Veiculo de Passageiros");
		Categoria cat2 = new Categoria(null, "Veículo de Carga");
		
		Veiculo v1 = new Veiculo(null, "HGT-1234","HONDA CIVIC", 2000.00);
		Veiculo v2 = new Veiculo(null, "XZC-9078","F-250", 800.00);
		Veiculo v3 = new Veiculo(null, "EGR-0890","ONIBUS CARGUEIRO", 80.00);

		cat1.getVeiculos().add(v1);
		cat1.getVeiculos().add(v2);
		cat1.getVeiculos().add(v3);
		//cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getVeiculos().add(v2);
		cat2.getVeiculos().add(v3);

		v1.getCategorias().add(cat1);
		v2.getCategorias().add(cat1);
		v2.getCategorias().add(cat2);
		v3.getCategorias().add(cat1);
		v3.getCategorias().add(cat2);
		
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
		
	    // categoriaRepository.save(Arrays.asList(cat1, cat2));
		
		veiculoRepository.save(v1);
		veiculoRepository.save(v2);
		veiculoRepository.save(v3);
	}
		
}


