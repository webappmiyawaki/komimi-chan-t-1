package dao;

import dto.CommentDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public interface ProcessUpdateInterface {
	/**
	 * ユーザー情報修正用
	 * @param userDTO
	 * @return boolean
	 */
	boolean InsertUserDTO(UserDTO userDTO);

	/**
	 * タレント情報修正用
	 * @param talentDTO
	 * @return boolean
	 */
	boolean InsertTalentDTO(TalentDTO talentDTO);

	/**
	 * リクエストデータ修正用
	 * @param requestDTO
	 * @return boolean
	 */
	boolean InsertRequestDTO(RequestDTO requestDTO);

	/**
	 * コメントデータ修正用
	 * @param commentDTO
	 * @return boolean
	 */
	boolean InsertCommentDTO(CommentDTO commentDTO);
}
