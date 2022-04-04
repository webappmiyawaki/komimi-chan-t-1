package sample;

import dto.CommentDTO;
import dto.LoginDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public class CreateSample {
	private static int num=0;
	private String name;
	public CreateSample(){
		num++;
	}
	public CreateSample(String name) {
		this();
		this.name=name;
	}
	public void setNum() {
		num=0;
	}
	public LoginDTO createLoginDTO(){
		return LoginDTO.builder()
				.id(String.format("%s %02d",this.name,num))
				.password(""+num)
				.build();
	}

	public TalentDTO createTalentDTO() {
		return TalentDTO.builder()
				.name(this.name+num)
				.info01(null)
				.info02(null)
				.info03(null)
				.info04(null)
				.info05(null)
				.info06(null)
				.info07(null)
				.info08(null)
				.build();
	}

	public UserDTO createUserDTO() {
		return UserDTO.builder()
				.name(this.name+num)
				.info01(null)
				.info02(null)
				.info03(null)
				.info04(null)
				.info05(null)
				.info06(null)
				.info07(null)
				.info08(null)
				.build();
	}

	public CommentDTO createCommentDTO() {
		return CommentDTO.builder()
				.userId(this.name+num)
				.talentId(null)
				.comment(null)
				.build();
	}

	public RequestDTO createRequestDTO() {
		return RequestDTO.builder()
				.userId(this.name+num)
				.talentId(null)
				.request(null)
				.build();
	}
}
