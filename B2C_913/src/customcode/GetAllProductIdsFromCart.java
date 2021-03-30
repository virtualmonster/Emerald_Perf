package customcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class GetAllProductIdsFromCart implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetAllProductIdsFromCart() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String pattern = "\"productId\":\"(.*?)\"";
		String result = "";
		int nbr_values = 0;
		Pattern r = Pattern.compile( pattern );
		Matcher m = r.matcher( args[ 0 ] );
	    while ( m.find() ) {
	    	// tes.getTestLogManager().reportMessage( m.group( 1 ) );
	    	result += "id=" + m.group( 1 ) +"&";
	    	nbr_values += 1;
	    }
	    if ( nbr_values > 0 ) {
	    	result = result.substring( 0, result.length() - 1 );
		    tes.getTestLogManager().reportMessage( result );
	    }
	    else {
	    	tes.getTestLogManager().reportMessage( "No result" );
	    	result = "-1";
	    }
		return result;
	}
}
