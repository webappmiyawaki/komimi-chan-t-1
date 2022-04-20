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
import dto.HistoryDTO;
import dto.LoginDTO;
import dto.ProductDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;
import dto.UserType;

public class ProcessFind implements ProcessFindInterface {

	@Override
	public LoginDTO findUserType(LoginDTO loginDTO) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info WHERE user_name LIKE ? AND user_password LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, loginDTO.getName());
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
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info WHERE user_name LIKE ? AND user_password LIKE ?";
		Random rnd = new Random();
		UserDTO userDTO;
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, loginDTO.getName());
			pstm.setString(2, loginDTO.getPassword());
			ResultSet rs = pstm.executeQuery();
			rs.next();

			userDTO = UserDTO.builder()
					.userId(rs.getString("user_id"))
					.userName(rs.getString("user_name"))
					.userPass(rs.getString("user_password"))
					.info03(rs.getString("img_address"))
					.userType(UserType.valueOf(rs.getString("user_type").toUpperCase()))
					.build();
		} catch (SQLException e) {
			System.out.println("user base info");
			return null;
		}

		sql = "SELECT * FROM user_favorite "
				+ "WHERE user_id in("
				+ "SELECT user_id "
				+ "FROM user_base_info "
				+ "WHERE user_id LIKE ? "
				+ "AND user_password LIKE ?)";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, userDTO.getUserId());
			pstm.setString(2, userDTO.getUserPass());
			ResultSet rs = pstm.executeQuery();
			rs.next();
			userDTO.setUserFavoriteTalent01(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent02(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent03(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent04(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent05(rs.getString("talent_id"));
		} catch (SQLException e) {
			e.printStackTrace();
			//お気に入り無しで戻り値
			return userDTO;
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> findPersonOthersList() {
		// TODO 自動生成されたメソッド・スタブ
		List<UserDTO> userList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info ORDER BY random() limit 5;";
		try (Connection conn = dbc.getConnection();
				Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
            	userList.add(UserDTO.builder()
    					.userId(rs.getString("user_id"))
    					.userName(rs.getString("user_name"))
    					.userPass(rs.getString("user_password"))
    					.info03(rs.getString("img_address"))
    					.userType(UserType.valueOf(rs.getString("user_type").toUpperCase()))
    					.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	@Override
	public List<TalentDTO> findTalentDTOList(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		List<TalentDTO> talentList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM talent_base_info WHERE talent_id LIKE ?";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);) {
			pstm.setString(1, userDTO.getUserFavoriteTalent01());
			ResultSet rs = pstm.executeQuery(sql);
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
			//もんだいなし
			e.printStackTrace();
		}
		return talentList;
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
		List<CommentDTO> commentList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_favorite WHERE user_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, userDTO.getUserId());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
            	commentList.add(CommentDTO.builder()
    					.userId(rs.getString("user_id"))
    					.talentId(rs.getString("talent_id"))
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
		List<RequestDTO> requestList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_request";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
			Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
            	requestList.add(RequestDTO.builder()
            			.userId(rs.getString("user_id"))
            			.requestText(rs.getString("request_text"))
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return requestList;
	}

	@Override
	public List<ProductDTO> findAnyProductDTOList(String talentDTO) {
		// TODO 自動生成されたメソッド・スタブ
		List<ProductDTO> productList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM product_by_talent WHERE talent_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, talentDTO);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
            	productList.add(ProductDTO.builder()
            			.productId(rs.getString("product_id"))
            			.talentId(rs.getString("talent_id"))
            			.productImg(rs.getString("product_img"))
            			.productType(rs.getString("product_type"))
            			.productName(rs.getString("product_name"))
            			.productPrice(Integer.parseInt(rs.getString("product_price")))
            			.registrationDate(null)
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productList;
	}

	@Override
	public ProductDTO findAnyProductDTO(String productID) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM product_by_talent WHERE product_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, productID);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			return ProductDTO.builder()
            			.productId(rs.getString("product_id"))
            			.talentId(rs.getString("talent_id"))
            			.productImg(rs.getString("product_img"))
            			.productType(rs.getString("product_type"))
            			.productName(rs.getString("product_name"))
            			.productPrice(Integer.parseInt(rs.getString("product_price")))
            			.registrationDate(null)
            			.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<UserDTO> findAllPersonOthersList() {
		// TODO 自動生成されたメソッド・スタブ
		List<UserDTO> userList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info";
		String sql2 = "SELECT * FROM user_favorite "
				+ "WHERE user_id in("
				+ "SELECT user_id "
				+ "FROM user_base_info "
				+ "WHERE user_id LIKE ? "
				+ "AND user_password LIKE ?)";
		try (Connection conn = dbc.getConnection();
				Statement stmt = conn.createStatement();) {

			UserDTO userDTO;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				userDTO =UserDTO.builder()
    					.userId(rs.getString("user_id"))
    					.userName(rs.getString("user_name"))
    					.userPass(rs.getString("user_password"))
    					.info03(rs.getString("img_address"))
    					.userType(UserType.valueOf(rs.getString("user_type").toUpperCase()))
    					.build();

        		try (Connection conn2 = dbc.getConnection();
        				PreparedStatement pstm2 = conn2.prepareStatement(sql2)) {
        			pstm2.setString(1, userDTO.getUserId());
        			pstm2.setString(2, userDTO.getUserPass());
        			ResultSet rs2 = pstm2.executeQuery();
        			StringBuilder sb= new StringBuilder("");
        			while(rs2.next()) {
        				sb.append(rs2.getString("talent_id")+",");
        			};
        			if(sb!=null) {
	        			String[] ary= sb.toString().split(",");
	        			userDTO.setUserFavoriteTalent01(ary[0]);
	        			userDTO.setUserFavoriteTalent02(ary[1]);
	        			userDTO.setUserFavoriteTalent03(ary[2]);
	        			userDTO.setUserFavoriteTalent04(ary[3]);
	        			userDTO.setUserFavoriteTalent05(ary[4]);
        			}
        		} catch (SQLException|ArrayIndexOutOfBoundsException e) {
        			System.out.println("お気に入りのタレント数不足");
        			//お気に入り無しで戻り値
        		}
        		userList.add(userDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return userList;
	}

	@Override
	public List<HistoryDTO> findAnyHistoryDTOList(UserDTO userDTO) {
		// TODO 自動生成されたメソッド・スタブ
		List<HistoryDTO> historyList= new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_purchase_history WHERE user_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, userDTO.getUserId());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
            	historyList.add(HistoryDTO.builder()
            			.productId(rs.getString("product_id"))
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return historyList;
	}

	@Override
	public List<ProductDTO> findAllProductDTOList() {
		// TODO 自動生成されたメソッド・スタブ
		List<ProductDTO> productList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_request";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
			Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
            	productList.add(ProductDTO.builder()
            			.productId(rs.getString("product_id"))
            			.talentId(rs.getString("talent_id"))
            			.productType(rs.getString("product_type"))
            			.productName(rs.getString("product_name"))
            			.productPrice(Integer.parseInt(rs.getString("product_price")))
            			.registrationDate(null)
            			.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productList;
	}

	@Override
	public TalentDTO findTalentDTO(String talentId) {
		// TODO 自動生成されたメソッド・スタブ
		TalentDTO talentDTO=null;
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM talent_base_info WHERE talent_id LIKE ?";
		Random rnd = new Random();
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);) {
			pstm.setString(1, talentId);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			talentDTO=TalentDTO.builder()
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
            			.build();
		} catch (SQLException e) {
			//もんだいなし
			e.printStackTrace();
		}
		return talentDTO;
	}

	@Override
	public UserDTO findPersonOthers(String personOthersID) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_base_info WHERE user_id LIKE ? ";
		Random rnd = new Random();
		UserDTO userDTO;
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, personOthersID);
			ResultSet rs = pstm.executeQuery();
			rs.next();

			userDTO = UserDTO.builder()
					.userId(rs.getString("user_id"))
					.userName(rs.getString("user_name"))
					.userPass(rs.getString("user_password"))
					.info03(rs.getString("img_address"))
					.userType(UserType.valueOf(rs.getString("user_type").toUpperCase()))
					.build();
		} catch (SQLException e) {
			System.out.println("user base info");
			return null;
		}

		sql = "SELECT * FROM user_favorite WHERE user_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, userDTO.getUserId());
			ResultSet rs = pstm.executeQuery();
			rs.next();
			userDTO.setUserFavoriteTalent01(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent02(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent03(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent04(rs.getString("talent_id"));
			rs.next();
			userDTO.setUserFavoriteTalent05(rs.getString("talent_id"));
		} catch (SQLException e) {
			e.printStackTrace();
			//お気に入り無しで戻り値
			return userDTO;
		}
		return userDTO;
	}

	@Override
	public List<CommentDTO> findCommentTalentList(String talentId) {
		// TODO 自動生成されたメソッド・スタブ
		List<CommentDTO> commentList = new ArrayList<>();
		DBConnector dbc = new DBConnector();
		String sql = "SELECT * FROM user_favorite WHERE talent_id LIKE ?";
		try (Connection conn = dbc.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, talentId);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
            	commentList.add(CommentDTO.builder()
    					.userId(rs.getString("user_id"))
    					.talentId(rs.getString("talent_id"))
    					.comment(rs.getString("user_comment"))
    					.build());
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return commentList;
	}

}
