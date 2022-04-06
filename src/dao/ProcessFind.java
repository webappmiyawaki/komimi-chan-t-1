package dao;

import java.sql.Connection;
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

public class ProcessFind implements ProcessFindInterface {

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
            			.talentImdAddress(rs.getString("talent_img_address"))
            			.talentBirthPlace(rs.getString("talent_birth_place"))
            			.talentBirthday(null)
            			.talentBloodType(rs.getString("talent_blood_type"))
            			.talentGroupName(rs.getString("talent_group_name"))
            			.talentInfo08(rs.getString("talent_info08"))
            			.talentFavoriteCount(rnd.nextInt(1000))
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
		return null;
	}

	@Override
	public List<RequestDTO> findAllRequestDTOList() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
