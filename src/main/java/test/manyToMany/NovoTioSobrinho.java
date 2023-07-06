package test.manyToMany;

import infra.DAO;
import model.manyToMany.Sobrinho;
import model.manyToMany.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {

		Tio tia1 = new Tio("Renata");
		Tio tio2 = new Tio("Fabio");
		
		Sobrinho sobrinha1 = new Sobrinho("Leticia");
		Sobrinho sobrinho2 = new Sobrinho("Joao Davi");
		//->RELAÇAO BIRIRECIONAL
		tia1.getSobrinhos().add(sobrinha1);
		sobrinha1.getTios().add(tia1);
		
		tia1.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tia1);
		
		tio2.getSobrinhos().add(sobrinha1);
		sobrinha1.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio2);
		
		DAO<Object> dao = new DAO<Object>();
		dao.openTransaction()
		.include(tia1)
		.include(tio2)
		.include(sobrinha1)
		.include(sobrinho2)
		.closeTransaction()
		.closeDAO();
		
		
		
		
	}
}
