package dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TalentDTO implements Serializable{
	private String talentId;
	private String talentName;
	private String talentImdAddress;
	private String talentBirthPlace;
	private Date talentBirthday;
	private String talentBloodType;
	private String talentGroupName;
	private String talentInfo08;
	private int talentFavoriteCount;
	private String talentLiveInf01;
	private String talentLiveInf02;
	private String talentLiveInf03;
	private String talentLiveInf04;
	private String talentLiveInf05;
}
