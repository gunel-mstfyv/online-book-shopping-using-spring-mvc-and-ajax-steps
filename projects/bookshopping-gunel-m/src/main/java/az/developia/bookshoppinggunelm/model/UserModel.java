package az.developia.bookshoppinggunelm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class UserModel {

@Size(min=1,message="Price minimum must be 1!")
@Size(max=30,message="Price maximum must be 30!")
@NotEmpty(message="Must be filled!")
private String username;
@Size(min=1,message="Price minimum must be 1!")
@Size(max=30,message="Price maximum must be 30!")
@NotEmpty(message="Must be filled!")
private String password;

}
