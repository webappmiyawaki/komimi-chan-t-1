package dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProductDTO implements Serializable {
	private String productId;
	private String talentId;
	private String productType;
	private String productName;
	private int productPrice;
	private Date registrationDate;
}
