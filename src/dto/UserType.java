package dto;

public enum UserType {
	GENERAL("一般"),
	TALENT_MANAGER("タレント"),
	OPERATION_MANAGER("運営");

	private final String bunrui;

	private UserType(String bunrui) {
		this.bunrui = bunrui;
	}

	public String getBunrui() {
		return bunrui;
	}
}