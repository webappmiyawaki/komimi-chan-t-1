package dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Builder
public class TalentDTO implements Serializable{
	private String talentId;
	private String talentName;
	private String talentImgAddress;
	private String talentBirthPlace;
	private Date talentBirthday;
	private String talentBloodType;
	private String talentGroupName;
	private String talentInfo08;
	private String twitterAddress;
	private String youtubeAddress;
	private String tiktokAddress;
	private int talentFavoriteCount;
	private String talentLiveInf01;
	private String talentLiveInf02;
	private String talentLiveInf03;
	private String talentLiveInf04;
	private String talentLiveInf05;
	private ProductDTO product01;
	private ProductDTO product02;
	private ProductDTO product03;
	private ProductDTO product04;
	private ProductDTO product05;

	public String ToString() {
		return String.format("img:%s group:%s name:%s",this.talentImgAddress,this.talentGroupName,this.talentName);
	}
}

