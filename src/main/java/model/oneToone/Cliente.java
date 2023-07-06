package model.oneToone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "assento_id", unique = true)//-> CONSTREIN 
	private Assento assento;//-> assento esta sendo monitorado na classe cliente garantindo a bidirecionalidade;
	
	 	
	public Cliente() {
		
	}

	public Cliente(String name, Assento assento) {
		this.name = name;
		this.assento = assento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
