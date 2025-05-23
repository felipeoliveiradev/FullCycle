package br.com.primeshoes.api.modules.user.Mapper;

import br.com.primeshoes.api.modules.user.Dto.Request.UserCreateDTO;
import br.com.primeshoes.api.modules.user.Dto.Response.UserResponseDTO;
import br.com.primeshoes.api.modules.user.Entity.User;

public class UserMapper {
	
	public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getPassword(),
				user.getRole(),
				user.getCreated_at(),
				user.getUpdated_at()
		);
	}
	public static User toEntity(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setName(userCreateDTO.name());
		user.setEmail(userCreateDTO.email());
		user.setPassword(userCreateDTO.password());
		user.setRole(userCreateDTO.role());
		return user;
	}
}
