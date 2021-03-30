package customcode;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;
import java.util.Random;

public class GetEmail implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	public GetEmail() {}

	public String exec(ITestExecutionServices tes, String[] args) {
		String[] characters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
				                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		Random rand = new Random();
		// email id between min and max
		int min = 6, max = 17;
		// Length of the email id
		int len = rand.nextInt( ( max - min ) + 1 ) + min;
		int ic;
		// Build email id
		String email = ""; 
		for ( int i = 0; i < len; i++ ) {
			ic = rand.nextInt( characters.length - 1 );
			email += characters[ ic ];
		}
		email = email + "@" + args[ 0 ];
		tes.getTestLogManager().reportMessage( "email = " + email );
		tes.setValue( "email1", ITestExecutionServices.STORAGE_USER, email );
		
		// Build nickname
		String nickname = ""; 
		for ( int i = 0; i < len; i++ ) {
			ic = rand.nextInt( characters.length - 1 );
			nickname += characters[ ic ];
		}
		tes.getTestLogManager().reportMessage( "nickname = " + nickname );
		tes.setValue( "nickname", ITestExecutionServices.STORAGE_USER, nickname );
		
		return null;
	}
}
