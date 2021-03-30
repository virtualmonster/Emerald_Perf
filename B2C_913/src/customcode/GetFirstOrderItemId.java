package customcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine Brahimi
 */
public class GetFirstOrderItemId implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetFirstOrderItemId() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String pattern = "\"orderItemId\":\"([0-9]+?)\",";
		String result = "";
		Pattern r = Pattern.compile( pattern );
		Matcher m = r.matcher( args[ 0 ] );
	    if ( m.find() ) {
	    	tes.getTestLogManager().reportMessage( "First order item id = " + m.group( 1 ) );
	    	result = m.group( 1 );
	    }
	    else {
	    	tes.getTestLogManager().reportMessage( "No result" );
	    	result = "-1";
	    }
		return result;
	}
}
