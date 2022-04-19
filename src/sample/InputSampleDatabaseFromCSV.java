package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import dao.ProcessInsert;
import dto.CommentDTO;
import dto.HistoryDTO;
import dto.ProductDTO;
import dto.RequestDTO;
import dto.TalentDTO;
import dto.UserDTO;
import dto.UserType;

public class InputSampleDatabaseFromCSV implements InputSampleDatabaseFromCSVInterface {
	public boolean userBaseInfo() {
		  // CSVファイルを読み込み1行ずつ出力
//		  BufferedReader br = null;
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\userdata0418.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] userAry; //11列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  userAry = line.split(",");
						  System.out.println(Arrays.toString(userAry));
						  UserDTO userDTO = UserDTO.builder()
						  .userId(userAry[0])
						  .userName(userAry[1])
						  .userPass(userAry[2])
						  .info03(userAry[3])
						  .userType(UserType.valueOf(userAry[4].toUpperCase()))
						  .build();
						  System.out.println(userDTO);
						  pi.insertUserDTO(userDTO);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean userFavorite() {
		  // CSVファイルを読み込み1行ずつ出力
//		  BufferedReader br = null;
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\commentdata0418.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] commentAry; //3列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  commentAry = line.split(",");
						  System.out.println(Arrays.toString(commentAry));
						  CommentDTO comment = CommentDTO.builder()
						  .userId(commentAry[0])
						  .talentId(commentAry[1])
						  .comment(commentAry[2])
						  .build();
						  System.out.println(comment);
						  pi.insertCommentDTO(comment);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean userRequest() {
		// TODO 自動生成されたメソッド・スタブ
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_request0419.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] requestAry; //3列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  requestAry = line.split(",");
						  System.out.println(Arrays.toString(requestAry));
						  RequestDTO request = RequestDTO.builder()
						  .userId(requestAry[0])
						  .requestText(requestAry[1])
						  .build();
						  System.out.println(request);
						  pi.insertRequestDTO(request);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean userPurchaseHistory() {
		// TODO 自動生成されたメソッド・スタブ
		String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\user_purchase_history0419.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] historyAry; //3列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  historyAry = line.split(",");
						  System.out.println(Arrays.toString(historyAry));
						  HistoryDTO historyDTO = HistoryDTO.builder()
						  .userId(historyAry[0])
						  .productId(historyAry[1])
						  .registrationDate(null)
						  .build();
						  System.out.println(historyDTO);
						  pi.insertHistoryDTO(historyDTO);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean TalentBaseInfo() {
		// TODO 自動生成されたメソッド・スタブ
		  // CSVファイルを読み込み1行ずつ出力
//		  BufferedReader br = null;
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\talent_base_info0420.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] talentAry=new String[11]; //11列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  talentAry = line.split(",");
						  System.out.println(Arrays.toString(talentAry));
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
						  System.out.println(talent);
						  pi.insertTalentDTO(talent);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean TalentLiveInfo() {
		// TODO 自動生成されたメソッド・スタブ
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\talent_live_info.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] talentAry; //5列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  talentAry = line.split(",");
						  System.out.println(Arrays.toString(talentAry));
						  TalentDTO talent = TalentDTO.builder()
						  .talentId(talentAry[0])
						  .talentLiveInf01(talentAry[1])
						  .talentLiveInf02(talentAry[2])
						  .talentLiveInf03(talentAry[3])
						  .talentLiveInf04(talentAry[4])
						  .talentLiveInf05(talentAry[5])
						  .build();
						  System.out.println(talent);
						  pi.insertTalentDTO2Live(talent);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	}

	@Override
	public boolean ProductByTalent() {
		// TODO 自動生成されたメソッド・スタブ
		String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\product_by_talent0419.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] productAry; //3列
		  ProcessInsert pi = new ProcessInsert();
		  File file = new File(file_name);
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) {
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  productAry = line.split(",");
						  System.out.println(Arrays.toString(productAry));
						  ProductDTO productDTO = ProductDTO.builder()
						  .productId(productAry[0])
						  .talentId(productAry[1])
						  .productType(productAry[2])
						  .productName(productAry[3])
						  .productPrice(Integer.parseInt(productAry[4]))
						  .registrationDate(null)
						  .build();
						  System.out.println(productDTO);
						  pi.insertProductDTO(productDTO);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
			  return false;
		  }
		return true;
	};


}
