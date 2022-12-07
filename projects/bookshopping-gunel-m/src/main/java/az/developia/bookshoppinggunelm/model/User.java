package az.developia.bookshoppinggunelm.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	@Size(min = 1, message = "Username  must be minimum 1 character!")
	@Size(max = 30, message = "Username  must be maximum 30 characters!")
	@NotEmpty(message = "Must be filled!")
	private String username;
	@Size(min = 1, message = "Password  must be minimum 1 character!")
	@Size(max = 30, message = "Password  must be maximum 30 characters!")
	@NotEmpty(message = "Must be filled!")
	private String password;

}
