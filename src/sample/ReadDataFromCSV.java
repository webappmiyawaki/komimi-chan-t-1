package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.UUID;

import dao.ProcessInsert;
import dto.TalentDTO;

public class ReadDataFromCSV {
	public static void main(String[] args) {
		read();
	}
	public static void read() {
		  // CSVファイルを読み込み1行ずつ出力
		  BufferedReader br = null;
		  String file_name = "C:\\pleiades\\workspace\\komimi-chan-t-1\\sql\\talentdata.csv"; // 入力ファイル
		  String line; // 読み込み行
		  String[] talentAry; //8列
		  ProcessInsert pi = new ProcessInsert();
		  try {
			  File file = new File(file_name);
			  br = new BufferedReader(new FileReader(file));
			  int counter = 0;
			  while ((line = br.readLine()) != null) {
				  if(counter!=0) {
					  try {
						  talentAry = line.split(",");
						  System.out.println(Arrays.toString(talentAry));
	//					  SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	//					  System.out.println(talentAry[4]);
	//					  String formattedDate = sdFormat.format(talentAry[4]);
	//					  System.out.println(formattedDate);
	//
	//					  //渡す日付の形式は「yyyy-[m]m-[d]d」です。
	//					  java.sql.Date talentDate = java.sql.Date.valueOf(talentAry[4]);

						  UUID uuid = UUID.randomUUID();
						  TalentDTO talent = TalentDTO.builder()
						  .talentId(uuid.toString())
						  .talentName(talentAry[1])
						  .talentImdAddress(talentAry[2])
						  .talentBirthPlace(talentAry[3])
						  .talentBirthday(null)
						  .talentBloodType(talentAry[5])
						  .talentGroupName(talentAry[6])
						  .talentFavoriteCount(1000)
						  .build();
						  System.out.println(talent);
						  pi.InsertTalentDTO(talent);
					  }catch(IllegalArgumentException e) {
						  System.out.println("変換エラーなので飛ばす");
					  }
				  }
				  counter++;
			  }
		  }catch(Exception e) {
			  System.out.println(e);
		  }
	}
}
