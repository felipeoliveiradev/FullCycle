package br.com.primeshoes.api.modules.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.modules.product.Dto.Request.ProductCreateDTO;
import br.com.primeshoes.api.modules.product.Dto.Response.ProductResponseDTO;
import br.com.primeshoes.api.modules.product.Dto.Request.ProductUpdateDTO;
import br.com.primeshoes.api.modules.product.Service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductCreateDTO productCreateDTO) {
		return new ResponseEntity<>(productService.store(productCreateDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> list() {
		return new ResponseEntity<>(productService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id_product}")
	public ResponseEntity<ProductResponseDTO> show(@PathVariable long id_product) {
		try {
			return new ResponseEntity<>(productService.show(id_product), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductUpdateDTO productUpdateDTO) {
		try {
			return new ResponseEntity<>(productService.update(productUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_product}")
	public ResponseEntity<String> destroy(@PathVariable long id_product) {
		try {
			productService.destroy(id_product);
			return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
