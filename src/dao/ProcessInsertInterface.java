package dao;

import dto.CommentDTO;
import dto.HistoryDTO;
import dto.ProductDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;

public interface ProcessInsertInterface {
	/**
	 * ユーザー情報追加用
	 * @param userDTO
	 * @return boolean
	 */
	boolean insertUserDTO(UserDTO userDTO);

	/**
	 * タレント情報追加用
	 * @param talentDTO
	 * @return boolean
	 */
	boolean insertTalentDTO(TalentDTO talentDTO);

	public boolean insertTalentDTO2Live(TalentDTO talentDTO);

	/**
	 * リクエストデータ追加用
	 * @param requestDTO
	 * @return boolean
	 */
	boolean insertRequestDTO(RequestDTO requestDTO);

	/**
	 * コメントデータ追加用
	 * @param commentDTO
	 * @return boolean
	 */
	boolean insertCommentDTO(CommentDTO commentDTO);

	/**
	 * 商品データ追加用
	 * @param ProductDTO
	 * @return boolean
	 */
	boolean insertProductDTO(ProductDTO ProductDTO);

	/**
	 * 商品データ追加用
	 * @param ProductDTO
	 * @return boolean
	 */
	boolean insertHistoryDTO(HistoryDTO historyDTO);
}
