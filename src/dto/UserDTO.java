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
	private String userLikeTalent01;
	private String userLikeTalent02;
	private String userLikeTalent03;
	private String userLikeTalent04;
	private String userLikeTalent05;
}
