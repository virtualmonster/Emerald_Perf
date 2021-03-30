package customcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class GetAllProductIds implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetAllProductIds() {}
	
	/* 
	 * This code generates a string like the following 
	 * id=14033&id=14092&id=14049&id=14103&id=14074&id=14170&id=14148&id=14207
	 * 
	 * It gets the ids from the json file received in parameter
	 * 
	 */
	
	public String exec(ITestExecutionServices tes, String[] args) {
		String content = args[ 0 ];
		String productIds = "id=";
		
		Pattern pattern = Pattern.compile( "\"productId\":\"(.*?)\"" );
		Matcher matcher = pattern.matcher( content );
		while ( matcher.find() ) {
			productIds += matcher.group( 1 ) + "&id=";
		}
		
		tes.getTestLogManager().reportMessage( "productIds = " + productIds );
		
		if ( productIds.length() > 3 ) {
			productIds = productIds.substring( 0, productIds.length() - 4 );
		}
		else {
			productIds = "-1";
		}
		return productIds;
	}
}
