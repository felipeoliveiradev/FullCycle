package br.com.primeshoes.api.modules.order.Mapper;

import br.com.primeshoes.api.modules.order.Dto.Request.OrderCreateDTO;
import br.com.primeshoes.api.modules.order.Dto.Response.OrderResponseDTO;
import br.com.primeshoes.api.modules.order.Entity.Order;

public class OrderMapper {
	
	public static OrderResponseDTO toDTO(Order order) {
        return new OrderResponseDTO(
				order.getId(),
				order.getUser(),
				order.getTotalPrice(),
				order.getStatus(),
				order.getPaymentMethod(),
				order.getTrackingCode(),
				order.getCreated_at(),
				order.getUpdated_at()
		);
	}
	
	public static Order toEntity(OrderCreateDTO orderCreateDTO) {
		Order order = new Order();
		order.setUser(orderCreateDTO.user());
		order.setTotalPrice(orderCreateDTO.totalPrice());
		
		return order;
	}
}
