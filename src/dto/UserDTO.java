package dto;

import java.io.Serializable;

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
public class UserDTO implements Serializable{
	private String userId;
	private String userName;
	private String userPass;
	private String info03;
	private UserType userType;
	private String userFavoriteTalent01;
	private String userFavoriteTalent02;
	private String userFavoriteTalent03;
	private String userFavoriteTalent04;
	private String userFavoriteTalent05;
}
