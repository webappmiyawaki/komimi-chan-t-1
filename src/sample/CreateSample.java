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
		return TalentDTO.builder().build();
	}

	public UserDTO createUserDTO() {
		return UserDTO.builder().build();
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
