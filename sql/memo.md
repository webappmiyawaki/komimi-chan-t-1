sampledata

- product_by_talent
- pi.InsertProductDTO(productDTO);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\product_talent.csv"
ProductDTO productDTO = ProductDTO.builder()
						  .productId(productAry[0])
						  .talentId(productAry[1])
						  .productType(productAry[2])
						  .productName(productAry[3])
						  .productPrice(Integer.parseInt(productAry[4]))
						  .registrationDate(null)
						  .build();



- talent_base_info
- pi.InsertTalentDTO(talent);
- "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\talentdata0411.csv"
TalentDTO talent = TalentDTO.builder()
						  .talentId(talentAry[0])
						  .talentName(talentAry[1])
						  .talentImgAddress(talentAry[2])
						  .talentBirthPlace(talentAry[3])
						  .talentBirthday(null)
						  .talentBloodType(talentAry[5])
						  .talentGroupName(talentAry[6])
						  .talentFavoriteCount(1000)
						  .twitterAddress(talentAry[8])
						  .youtubeAddress(talentAry[9])
						  .tiktokAddress(talentAry[10])
						  .build();


- talent_live_info
- pi.InsertTalentDTO(talent);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\talent_live_info.csv";
TalentDTO talent = TalentDTO.builder()
						  .talentId(talentAry[0])
						  .talentLiveInf01(talentAry[1])
						  .talentLiveInf02(talentAry[2])
						  .talentLiveInf03(talentAry[3])
						  .talentLiveInf04(talentAry[4])
						  .talentLiveInf05(talentAry[5])
						  .build();

- user_base_info
- pi.InsertUserDTO(userDTO);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_data.csv"; 
 UserDTO userDTO = UserDTO.builder()
						  .userId(userAry[0])
						  .userName(userAry[1])
						  .userPass(userAry[2])
						  .info03(userAry[3])
						  .user_type(UserType.valueOf(userAry[4].toUpperCase()))
						  .build();


- user_favorite
- pi.InsertCommentDTO(comment);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_comment.csv"
CommentDTO comment = CommentDTO.builder()
						  .userId(commentAry[0])
						  .talentId(commentAry[1])
						  .comment(commentAry[2])
						  .build();

- user_purchase_history
- pi.InsertHistoryDTO(historyDTO);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_history.csv"
HistoryDTO historyDTO = HistoryDTO.builder()
						  .userId(historyAry[0])
						  .productId(historyAry[1])
						  .registrationDate(null)
						  .build();


- user_request
-  pi.InsertRequestDTO(request);
"C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_request.csv"
						  RequestDTO request = RequestDTO.builder()
						  .userId(requestAry[0])
						  .requestText(requestAry[1])
						  .build();