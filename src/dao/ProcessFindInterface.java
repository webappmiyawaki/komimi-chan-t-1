package dao;

import java.util.List;

import dto.CommentDTO;
import dto.HistoryDTO;
import dto.LoginDTO;
import dto.ProductDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public interface ProcessFindInterface {

	/**
	 * 自分のユーザー情報取得
	 * マイページ用
	 * @param loginDTO
	 * @return LoginDTO or null
	 */
	LoginDTO findUserType(LoginDTO loginDTO);

	/**
	 * 自分のユーザー情報取得
	 * マイページ用
	 * @param loginDTO
	 * @return UserDTO or null
	 */
	UserDTO findPersonMyself(LoginDTO loginDTO);

	/**
	 * おすすめのユーザー情報取得
	 * @param String
	 * @return UserDTO or null
	 */
	UserDTO findPersonOthers(String personOthersID);

	/**
	 * タレント情報取得
	 * マイページ用
	 * @param String
	 * @return TalentDTO or null
	 */
	TalentDTO findTalentDTO(String talentId);

	/**
	 * 似ているユーザー情報取得
	 * メイン、マイページ、有名人情報ページ用
	 * @param UserDTO
	 * @return List<UserDTO> or null
	 */
	List<UserDTO> findPersonOthersList(CommentDTO commentDTO);

	/**
	 * 似ているユーザー情報取得
	 * メイン、マイページ、有名人情報ページ用
	 * @param UserDTO
	 * @return List<UserDTO> or null
	 */
	List<UserDTO> findAllPersonOthersList();

	/**
	 * お気に入りにしているタレント取得
	 * マイページ、似ているユーザーページ用
	 * @param userDTO
	 * @return List<TalentDTO> or null
	 */
	List<TalentDTO> findTalentDTOList(UserDTO userDTO);

	/**
	 * 登録されている全てのタレント取得
	 * 管理ページ用
	 * @param void
	 * @return List<UserDTO> or null
	 */
	List<TalentDTO> findAllTalentDTOList();

	/**
	 * コメントリスト取得
	 * マイページ、似ているユーザーページ用
	 * @param UserDTO
	 * @return List<CommentDTO> or null
	 */
	List<CommentDTO> findCommentDTOList(UserDTO userDTO);

	/**
	 * 登録されているすべてのタレント取得
	 * 管理ページ用
	 * @param void
	 * @return List<CommentDTO> or null
	 */
	List<CommentDTO> findAllCommentDTOList();

	/**
	 * タレントのコメント取得
	 * @param String
	 * @return List<CommentDTO> or null
	 */
	List<CommentDTO> findCommentTalentList(String talentId);

	/**
	 * 登録されているすべてのリクエスト取得
	 * 管理ページ用
	 * @param void
	 * @return List<RequestDTO> or null
	 */
	List<RequestDTO> findAllRequestDTOList();

	/**
	 * タレントが出品している商品リスト取得
	 * 管理ページ用
	 * @param void
	 * @return List<RequestDTO> or null
	 */
	List<ProductDTO> findAnyProductDTOList(TalentDTO talentDTO);

	/**
	 * 全ての商品リスト取得
	 * 管理ページ用
	 * @param void
	 * @return List<ProductDTO> or null
	 */
	List<ProductDTO> findAllProductDTOList();

	/**
	 * 個人の商品購買履歴
	 * @param userDTO
	 * @return List<HistoryDTO> or null
	 */
	List<HistoryDTO> findAnyHistoryDTOList(UserDTO userDTO);
}
