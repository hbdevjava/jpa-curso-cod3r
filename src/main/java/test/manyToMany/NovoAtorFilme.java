package test.manyToMany;

import java.util.List;

import infra.DAO;
import model.manyToMany.Ator;
import model.manyToMany.Filme;

public class NovoAtorFilme {

	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star Wars", 7.4);
		Filme filmeB = new Filme("O fugitivo", 8.9);
		Filme filmeC = new Filme("Réquiem Para Um Sonho", 6.1);
		Filme filmeD = new Filme("O Brilho Eterno de Uma Mente Sem Lembranças", 7.1);
		Filme filmeE = new Filme("Labirinto do Fauno", 8.1);
		Filme filmeF = new Filme("Bastardos Inglórios", 9.1);
		
		
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atorB = new Ator("Carrie Fisher");
		Ator atorC = new Ator("Ellen Burstyn");
		Ator atorD = new Ator("Jared Leto");
		Ator atorE = new Ator("Jim Carrey");
		Ator atorF = new Ator("Brad Pitt");
		Ator atorG = new Ator("Mélanie Laurent");
		Ator atorH = new Ator("Christoph Waltz");
		
		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atorB);
		filmeB.adicionarAtor(atorA);
		filmeC.adicionarAtor(atorC);
		filmeC.adicionarAtor(atorD);
		filmeF.adicionarAtor(atorF);
		filmeF.adicionarAtor(atorG);
		filmeF.adicionarAtor(atorH);
		
		DAO<Filme> dao = new DAO<Filme>();
		dao.insertTAllTransaction(filmeA);
		/**
		 * PRA INSERIR ATOMICO TENHO QUE -> @ManyToMany(mappedBy = "atores", cascade = CascadeType.PERSIST)
		 * 									private List<Filme> filmes = new ArrayList<>();
		 * 
		 * 									@ManyToMany(cascade = CascadeType.PERSIST)
		 * 									private List<Ator> atores;
		 * EXPLICITAR O METODO cascade = CascadeType.PERSIST
		 * ELE VAI insertTAllTransaction(filmeA) NOTE QUE NELE TEM OS ATORES SO QUE UM DOS ATORES TB ESTER VINCULADO A OUTRO FILME
		 * QUANDO FOR PERSISTIDO ELE TB TRARA O FILMEb
		 * EM RESUMO OS DOIS FILMES SERAO PERSISTIDOS
		 * 
		 * 
		 * */
	
		

	}

}
