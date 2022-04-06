package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CommentDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public class ProcessInsert implements ProcessInsertInterface {

	@Override
	public boolean InsertUserDTO(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean InsertTalentDTO(TalentDTO talentDTO) {
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO talent_base_info VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, talentDTO.getTalentId());
			pstm.setString(2, talentDTO.getTalentName());
			pstm.setString(3, talentDTO.getTalentImdAddress());
			pstm.setString(4, talentDTO.getTalentBirthPlace());
			pstm.setDate(5, talentDTO.getTalentBirthday());
			pstm.setString(6, talentDTO.getTalentBloodType());
			pstm.setString(7, talentDTO.getTalentGroupName());
			pstm.setString(8, talentDTO.getTalentInfo08());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean InsertRequestDTO(RequestDTO requestDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean InsertCommentDTO(CommentDTO commentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
