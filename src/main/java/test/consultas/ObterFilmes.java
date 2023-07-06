package test.consultas;

import java.util.List;

import infra.DAO;
import model.manyToMany.Ator;
import model.manyToMany.Filme;

public class ObterFilmes {

	public static void main(String[] args) {
		
		DAO<Filme> daoFilme = new DAO(Filme.class);//-> DAO(Filme.class) referencia a classe -> DAO<Filme>;
		List<Filme> filmes = daoFilme.consultar("filmesNotasMaiorQue", "nota", 9.0);
		
		for (Filme filme : filmes) {
			System.out.println("Filme: "+filme.getNome());
			System.out.println();
			for (Ator ator : filme.getAtores()) {
				System.out.println("Ator: " + ator.getNome());
			}
			
		}
		
		
		
		
		
		
	}

}
