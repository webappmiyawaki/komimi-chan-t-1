package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CommentDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public class ProcessDelete implements ProcessDeleteInterface {
	DBConnector dbc = new DBConnector();
	@Override
	public boolean DeleteUserDTO(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		String sqlToTable1 = "DELETE FROM table1 WHERE user_id=?";
		String sqlToTable2 = "DELETE FROM table2 WHERE user_id=?";

		try (Connection conn = dbc.getConnection();
				PreparedStatement pstmToTable1 = conn.prepareStatement(sqlToTable1);
				PreparedStatement pstmToTable2 = conn.prepareStatement(sqlToTable2)) {
			pstmToTable1.setString(1, userDTO.getUserName());
			pstmToTable1.executeUpdate();
			pstmToTable2.setString(1, userDTO.getUserName());
			pstmToTable2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteTalentDTO(TalentDTO talentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean DeleteRequestDTO(RequestDTO requestDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean DeleteCommentDTO(CommentDTO commentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
