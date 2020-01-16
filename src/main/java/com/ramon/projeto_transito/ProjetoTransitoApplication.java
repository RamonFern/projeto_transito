package com.ramon.projeto_transito;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ramon.projeto_transito.domain.Categoria;
import com.ramon.projeto_transito.domain.Cidade;
import com.ramon.projeto_transito.domain.Endereco;
import com.ramon.projeto_transito.domain.Estado;
import com.ramon.projeto_transito.domain.Pessoa;
import com.ramon.projeto_transito.domain.Veiculo;
import com.ramon.projeto_transito.domain.enums.TipoPessoa;
import com.ramon.projeto_transito.repositories.CategoriaRepository;
import com.ramon.projeto_transito.repositories.CidadeRepository;
import com.ramon.projeto_transito.repositories.EnderecoRepository;
import com.ramon.projeto_transito.repositories.EstadoRepository;
import com.ramon.projeto_transito.repositories.PessoaRepository;
import com.ramon.projeto_transito.repositories.VeiculoRepository;

@SpringBootApplication
public class ProjetoTransitoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTransitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Veiculo de Passageiros");
		Categoria cat2 = new Categoria(null, "Veículo de Carga");
		Categoria cat3 = new Categoria(null, "Veículo de duas rodas");
		Categoria cat4 = new Categoria(null, "Veículos eletricos");
		Categoria cat5 = new Categoria(null, "Tratores");
		Categoria cat6 = new Categoria(null, "Mixto");
		Categoria cat7 = new Categoria(null, "Veículo de propulsão animal");
		
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
		categoriaRepository.save(cat3);
		categoriaRepository.save(cat4);
		categoriaRepository.save(cat5);
		categoriaRepository.save(cat6);
		categoriaRepository.save(cat7);
		
	    // categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		
		veiculoRepository.save(v1);
		veiculoRepository.save(v2);
		veiculoRepository.save(v3);
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);

		estadoRepository.save(est1);
		estadoRepository.save(est2);

		cidadeRepository.save(c1);
		cidadeRepository.save(c2);
		cidadeRepository.save(c3);
		
		Pessoa pess = new Pessoa(null, "Maria Silva", "maria@gmail.com", "45346333564", TipoPessoa.CONDUTORINFRATOR);

		//cli1.getTelefones().addAll(Arrays.asList("234231144","32523423"));
		pess.getTelefones().add("222222222");
		pess.getTelefones().add("333333333");

		Endereco e1 = new Endereco(null, "Rua Flores", "342", "Apto 32", "Jardim", "65150-000", pess, c1);
		Endereco e2 = new Endereco(null, "Rua Pr. Cícero", "100", "casa 05", "Vila Formosa", "2390-400", pess, c2);

		//cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		pess.getEnderecos().add(e1);
		pess.getEnderecos().add(e2);

		pessoaRepository.save(pess);
		enderecoRepository.save(e1);
		enderecoRepository.save(e2);
		
	}
		
}


