package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name= "products")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="names", nullable = false)
	private String name;
	@Column(name="prices", nullable = false)
	private Double price;
	
	Produto(){
		
	}

	public Produto(String name, Double price) {
		this.name = name;
		this.price = price;
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

	public Double getPreco() {
		return price;
	}

	public void setPreco(Double preco) {
		this.price = preco;
	}

	@Override
	public String toString() {
		return "Product id: " + id + " name:  " + name +  "  price: " + price;
	}
	
	

}
