package sample;

import java.util.List;

import dao.ProcessFind;
import dto.TalentDTO;

public class FindTest {
	public static void main(String[] args) {
		ProcessFind pf = new ProcessFind();
		List<TalentDTO> talentList = pf.findAllTalentDTOList();
		for(TalentDTO t:talentList) {
			System.out.println(t);
		}
	}
}
