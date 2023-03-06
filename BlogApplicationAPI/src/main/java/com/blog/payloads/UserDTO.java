package com.blog.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDTO {
	private Integer userId;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String name;
	
	@NotEmpty
	private String password;
	
	@Email(message = "write the email in valid format")
	private String email;
	
	private String about;
}
