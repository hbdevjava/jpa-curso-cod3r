package model.oneToone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "assentos")
public class Assento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="assento") //-> A RELACAO ONETOONE ESTA MAPEADA NO ATRIBUTO "ASSENTO" NA Classe CLIENTE:  private Assento assento;
	private String name;
	
	@OneToOne(mappedBy = "assento")
	private Cliente cliente;//-> É CRIADO UM ATRIBUTO, ANOTADO COM O ATRIBUTO QUE ESTA SENDO MAPEADO NA OUTRA CLASSE,
	//ASSIM CONSIGO A PARIR DE ASSENTO CHEGAR NO CLIENTE QUE TEM AQUELE ASSENTO
	
	public Assento() {

	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Assento(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
