package model;

import dao.ProcessFind;
import dto.LoginDTO;

public class LoginCheck {
	public LoginDTO isLoginDTO(LoginDTO loginDTO) {
		ProcessFind pf = new ProcessFind();
		if(loginDTO.getName()==""||loginDTO.getPassword()=="")return null;
		return pf.findUserType(loginDTO);
	}
}
