package dao;

import java.util.List;

import dto.CommentDTO;
import dto.LoginDTO;
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
	 * 似ているユーザー情報取得
	 * メイン、マイページ、有名人情報ページ用
	 * @param UserDTO
	 * @return List<UserDTO> or null
	 */
	List<UserDTO> findPersonOthersList(UserDTO userDTO);

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
	 * 登録されているすべてのリクエスト取得
	 * 管理ページ用
	 * @param void
	 * @return List<RequestDTO> or null
	 */
	List<RequestDTO> findAllRequestDTOList();

}
