package br.com.primeshoes.api.modules.product.Entity;

import br.com.primeshoes.api.modules.product.Entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="product_variation")
@Data
@AllArgsConstructor
public class ProductVariation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String color;
	private float size;
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
}
