package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CommentDTO;
import dto.HistoryDTO;
import dto.ProductDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public class ProcessInsert implements ProcessInsertInterface {

	@Override
	public boolean InsertUserDTO(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO user_base_info(user_id,user_name,user_password,img_address) VALUES (?, ?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, userDTO.getUserId());
			pstm.setString(2, userDTO.getUserName());
			pstm.setString(3, userDTO.getUserPass());
			pstm.setString(4, userDTO.getInfo03());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean InsertTalentDTO(TalentDTO talentDTO) {
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO talent_base_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, talentDTO.getTalentId());
			pstm.setString(2, talentDTO.getTalentName());
			pstm.setString(3, talentDTO.getTalentImgAddress());
			pstm.setString(4, talentDTO.getTalentBirthPlace());
			pstm.setDate(5, talentDTO.getTalentBirthday());
			pstm.setString(6, talentDTO.getTalentBloodType());
			pstm.setString(7, talentDTO.getTalentGroupName());
			pstm.setString(8, talentDTO.getTalentInfo08());
			pstm.setString(9, talentDTO.getTwitterAddress());
			pstm.setString(10, talentDTO.getYoutubeAddress());
			pstm.setString(11, talentDTO.getTiktokAddress());
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
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO user_request(user_id,request_text) VALUES (?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, requestDTO.getUserId());
			pstm.setString(2, requestDTO.getRequestText());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean InsertCommentDTO(CommentDTO commentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO user_favorite(user_id,talent_id,user_comment) VALUES (?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, commentDTO.getUserId());
			pstm.setString(2, commentDTO.getTalentId());
			pstm.setString(3, commentDTO.getComment());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean InsertProductDTO(ProductDTO productDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO product_by_talent(product_id,talent_id,product_type,product_name,product_price,registration_date) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, productDTO.getProductId());
			pstm.setString(2, productDTO.getTalentId());
			pstm.setString(3, productDTO.getProductType());
			pstm.setString(4, productDTO.getProductName());
			pstm.setInt(5, productDTO.getProductPrice());
			pstm.setDate(6, productDTO.getRegistrationDate());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean InsertHistoryDTO(HistoryDTO historyDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "INSERT INTO user_purchase_history(user_id, product_id, registration_data) VALUES (?, ?, ?)";
		try (Connection conn = dbc.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, historyDTO.getUserId());
			pstm.setString(2, historyDTO.getProductId());
			pstm.setDate(3, historyDTO.getRegistrationDate());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
