package sample;

public class TestCreateMain {
	public static void main(String[] args) {

		//LoginDTO
		for(int i=0;i<10;i++) {
			CreateSample createSample = new CreateSample();
			System.out.println(createSample.createLoginDTO());
		}

		//UserDTO
		for(int i=0;i<10;i++) {
			CreateSample createSample = new CreateSample();
			System.out.println(createSample.createUserDTO());
		}

		//TalentDTO
		for(int i=0;i<10;i++) {
			CreateSample createSample = new CreateSample();
			System.out.println(createSample.createTalentDTO());
		}

		//CommentDTO
		for(int i=0;i<10;i++) {
			CreateSample createSample = new CreateSample();
			System.out.println(createSample.createCommentDTO());
		}
	}
}
