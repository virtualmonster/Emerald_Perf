package customcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class GetAllPartNumbers implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetAllPartNumbers() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String content = args[ 0 ];
		String partNumbers = "";
		
		Pattern pattern = Pattern.compile( "\"productPartNumber\":\"(.*?)\"" );
		Matcher matcher = pattern.matcher( content );
		while ( matcher.find() ) {
			partNumbers += matcher.group( 1 ) + ",";
		}
		
		tes.getTestLogManager().reportMessage( "partNumbers = " + partNumbers );
		
		if ( partNumbers.length() > 0 ) {
			partNumbers = partNumbers.substring( 0, partNumbers.length() - 1 );
		}
		return partNumbers;
	}
}
