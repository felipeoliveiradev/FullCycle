package br.com.primeshoes.api.modules.order;

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

import br.com.primeshoes.api.modules.order.Dto.Request.OrderCreateDTO;
import br.com.primeshoes.api.modules.order.Dto.Response.OrderResponseDTO;
import br.com.primeshoes.api.modules.order.Dto.Request.OrderUpdateDTO;
import br.com.primeshoes.api.modules.order.Service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponseDTO> create(@RequestBody OrderCreateDTO orderCreateDTO) {
		return new ResponseEntity<>(orderService.store(orderCreateDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> list() {
		return new ResponseEntity<>(orderService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id_order}")
	public ResponseEntity<OrderResponseDTO> show(@PathVariable long id_order) {
		try {
			return new ResponseEntity<>(orderService.show(id_order), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping
	public ResponseEntity<OrderResponseDTO> update(@RequestBody OrderUpdateDTO orderUpdateDTO) {
		try {
			return new ResponseEntity<>(orderService.update(orderUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_order}")
	public ResponseEntity<String> destroy(@PathVariable long id_order) {
		try {
			orderService.destroy(id_order);
			return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
