package dto;

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
public class UserDTO {
	String userId;
	String userName;
	String userPass;
	String info03;
	String userLikeTalent01;
	String userLikeTalent02;
	String userLikeTalent03;
	String userLikeTalent04;
	String userLikeTalent05;
}
