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
public class HistoryDTO implements Serializable {
	private String historyNo;
	private String userId;
	
	//null
	private Date registrationDate;

	//id→dtoへ
	private String productId;
	private ProductDTO productDTO;
}
