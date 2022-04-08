package dto;

import java.io.Serializable;

public class UserInfo implements Serializable{
	public UserInfo(String userId, int userPurchase,String userResult) {
		this.userId = userId;
		this.userPurchase = userPurchase;
		this.userResult = userResult;
	}
	public UserInfo() {
		super();
		this.userId=null;
		this.userPurchase=0;
		this.userResult=null;
	}
	private String userId;
	private int userPurchase;
	private String userResult;
	public String getUserResult() {
		return this.userResult;
	}
	public UserInfo setUserResult(String userResult) {
		this.userResult = userResult;
		return this;
	}

	public String getUserId() {
		return this.userId;
	}
	public UserInfo setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public int getUserPurchase() {
		return this.userPurchase;
	}
	public UserInfo setUserPurchase(int userPurchase) {
		this.userPurchase = userPurchase;
		return this;
	}
}
