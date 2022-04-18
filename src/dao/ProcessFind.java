package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dto.CommentDTO;
import dto.LoginDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;
import dto.UserType;

public class ProcessFind implements ProcessFindInterface {

	@Override
	public LoginDTO findUserType(LoginDTO loginDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info WHERE user_id LIKE ? AND user_password LIKE ?";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, loginDTO.getId());
			pstm.setString(2, loginDTO.getPassword());
			ResultSet rs = pstm.executeQuery();
			rs.next();
			String userType = rs.getString("user_type");
			loginDTO.setUserType(UserType.valueOf(userType.toUpperCase()));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return loginDTO;
	}

	@Override
	public UserDTO findPersonMyself(LoginDTO loginDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<UserDTO> findPersonOthersList(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<TalentDTO> findTalentDTOList(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ

		return null;
	}

	@Override
	public List<TalentDTO> findAllTalentDTOList() {
		List<TalentDTO> talentList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM talent_base_info";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
			Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
            	talentList.add(TalentDTO.builder()
            			.talentId(rs.getString("talent_id"))
            			.talentName(rs.getString("talent_name"))
            			.talentImgAddress(rs.getString("talent_img_address"))
            			.talentBirthPlace(rs.getString("talent_birth_place"))
            			.talentBirthday(null)
            			.talentBloodType(rs.getString("talent_blood_type"))
            			.talentGroupName(rs.getString("talent_group_name"))
            			.talentInfo08(rs.getString("talent_info08"))
            			.talentFavoriteCount(rnd.nextInt(1000))
            			.twitterAddress(rs.getString("twitter_address"))
            			.youtubeAddress(rs.getString("youtube_address"))
            			.tiktokAddress(rs.getString("tiktok_address"))
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return talentList;
	}

	@Override
	public List<CommentDTO> findCommentDTOList(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<CommentDTO> findAllCommentDTOList() {
		// TODO 自動生成されたメソッド・スタブ
		List<CommentDTO> commentList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_favorite";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
			Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
            	commentList.add(CommentDTO.builder()
            			.talentId(rs.getString("talent_id"))
            			.userId(rs.getString("user_id"))
            			.comment(rs.getString("user_comment"))
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return commentList;
	}

	@Override
	public List<RequestDTO> findAllRequestDTOList() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
