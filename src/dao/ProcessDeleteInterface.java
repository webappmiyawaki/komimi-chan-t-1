package dao;

import dto.CommentDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public interface ProcessDeleteInterface {
	/**
	 * ユーザー情報削除用
	 * @param userDTO
	 * @return boolean
	 */
	boolean DeleteUserDTO(UserDTO userDTO);

	/**
	 * タレント情報削除用
	 * @param talentDTO
	 * @return boolean
	 */
	boolean DeleteTalentDTO(TalentDTO talentDTO);

	/**
	 * リクエストデータ削除用
	 * @param requestDTO
	 * @return boolean
	 */
	boolean DeleteRequestDTO(RequestDTO requestDTO);

	/**
	 * コメントデータ削除用
	 * @param commentDTO
	 * @return boolean
	 */
	boolean DeleteCommentDTO(CommentDTO commentDTO);
}
