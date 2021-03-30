package customcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class GetMarketingSpotActivityIds implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	/* 
	 * This code generates a string like the following 
	 * id=14033&id=14092&id=14049&id=14103&id=14074&id=14170&id=14148&id=14207
	 * 
	 * It gets the ids from the json file received in parameter
	 * 
	 */
	public GetMarketingSpotActivityIds() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String content = args[ 0 ];
		String marketingSpotActivityIds = "id=";
		
		Pattern pattern = Pattern.compile( "\"baseMarketingSpotActivityName\":\"(.*?)\"" );
		Matcher matcher = pattern.matcher( content );
		while ( matcher.find() ) {
			marketingSpotActivityIds += matcher.group( 1 ) + "&id=";
		}
		
		tes.getTestLogManager().reportMessage( "marketingSpotActivityIds = " + marketingSpotActivityIds );
		
		if ( marketingSpotActivityIds.length() > 3 ) {
			marketingSpotActivityIds = marketingSpotActivityIds.substring( 0, marketingSpotActivityIds.length() - 4 );
		}
		else {
			marketingSpotActivityIds = "";
		}
		return marketingSpotActivityIds;
	}
}
