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
		String sql01 = "DELETE FROM user_base_info WHERE user_id=?";
		String sql02 = "DELETE FROM user_request user_id=?";
		String sql03 = "DELETE FROM user_purchase_history WHERE user_id=?";
		String sql04 = "DELETE FROM user_favorite WHERE user_id=?";

		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm01 = conn.prepareStatement(sql01);
				PreparedStatement pstm02 = conn.prepareStatement(sql02);
				PreparedStatement pstm03 = conn.prepareStatement(sql03);
				PreparedStatement pstm04 = conn.prepareStatement(sql04);) {
			conn.setAutoCommit(false);
			pstm01.setString(1, userDTO.getUserId());
			pstm01.executeUpdate();
			pstm02.setString(1, userDTO.getUserId());
			pstm02.executeUpdate();
			pstm03.setString(1, userDTO.getUserId());
			pstm03.executeUpdate();
			pstm04.setString(1, userDTO.getUserId());
			pstm04.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteTalentDTO(TalentDTO talentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		String sql01 = "DELETE FROM talent_base_info WHERE talent_id=?";
		String sql02 = "DELETE FROM talent_live_info WHERE talent_id=?";
		String sql03 = "DELETE FROM product_by_talent WHERE talent_id=?";
		String sql04 = "DELETE FROM user_favorite WHERE talent_id=?";
		try (Connection conn = dbc.getConnection();

				PreparedStatement pstm01 = conn.prepareStatement(sql01);
				PreparedStatement pstm02 = conn.prepareStatement(sql02);
				PreparedStatement pstm03 = conn.prepareStatement(sql03);
				PreparedStatement pstm04 = conn.prepareStatement(sql04);) {
			conn.setAutoCommit(false);
			pstm01.setString(1, talentDTO.getTalentId());
			pstm02.setString(1, talentDTO.getTalentId());
			pstm03.setString(1, talentDTO.getTalentId());
			pstm04.setString(1, talentDTO.getTalentId());
            conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteRequestDTO(RequestDTO requestDTO) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "DELETE FROM user_request WHERE request_no=?";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);) {
			pstm.setString(1, requestDTO.getRequestText());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean DeleteCommentDTO(CommentDTO commentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "DELETE FROM user_favorite WHERE user_id=? AND talent_id=?";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);) {
			pstm.setString(1, commentDTO.getUserId());
			pstm.setString(2, commentDTO.getTalentId());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
