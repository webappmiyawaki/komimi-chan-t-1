package dao;

import dto.CommentDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public interface ProcessInsertInterface {
	/**
	 * ユーザー情報追加用
	 * @param userDTO
	 * @return boolean
	 */
	boolean InsertUserDTO(UserDTO userDTO);

	/**
	 * タレント情報追加用
	 * @param talentDTO
	 * @return boolean
	 */
	boolean InsertTalentDTO(TalentDTO talentDTO);

	/**
	 * リクエストデータ追加用
	 * @param requestDTO
	 * @return boolean
	 */
	boolean InsertRequestDTO(RequestDTO requestDTO);

	/**
	 * コメントデータ追加用
	 * @param commentDTO
	 * @return boolean
	 */
	boolean InsertCommentDTO(CommentDTO commentDTO);
}
