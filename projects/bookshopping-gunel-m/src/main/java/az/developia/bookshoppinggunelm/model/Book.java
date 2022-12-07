package az.developia.bookshoppinggunelm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Must be filled!")
	@Size(min = 2, message = "Minimum 2 characters must be entered!")
	@Size(max = 30, message = "Maximum 30 characters must be entered!")
	private String name;
	@Column(columnDefinition = "VARCHAR (300)")
	@Size(max = 300, message = "Maximum 300 characters must be entered!")
	private String description;
	@Min(value = 0, message = "Price minimum must be 0!")
	@Max(value = 1000, message = "Price maximum must be 1000!")
	@NotNull(message = "Must be filled!")
	private Double price;
	@Column(columnDefinition = "VARCHAR (30)")
	@Size(max = 30, message = "Maximum 30 characters must be entered!")
	private String author;
	@Min(value = 0, message = "Minimum must be 0!")
	@Max(value = 10000, message = "Maximum must be 10000!")
	private Integer pageCount;
	private String image;
	private String username;
}
