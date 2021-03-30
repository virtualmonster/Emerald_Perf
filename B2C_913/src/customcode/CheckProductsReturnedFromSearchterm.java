package customcode;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class CheckProductsReturnedFromSearchterm implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public CheckProductsReturnedFromSearchterm() {}

	/**
	 * The resultset will be like the following, in case search returned something or doesn't find anything to return
	 * Found 
	 *    { ... ,"facets":[],"total":null}
     * No found
	 *    { ... ,"facets":[],"total": 6}
	 * 
	 * This function search for work "total" and will clean the string after it to see if it's null or a number 
	 * With this, we'll avoid running the subsequent requests and/or trying to find a product and add to cart
	 */
	
	public String exec(ITestExecutionServices tes, String[] args) {
		String s = args[ 0 ];
		String result;
		int i = s.indexOf( "\"total\":" );
		if ( i == -1 ) {
			tes.getTestLogManager().reportMessage( "Something wrong with the reponse. The word \"total\" was not found and it should be there" );
			result = "false";
		}
		else {
			s = s.substring( i + 8 ).replace( "}", "" );
			
			if ( s.equals( "null" ) ) { 
				result = "false";
				tes.getTestLogManager().reportMessage( "No product returned" );
			}
			else {
				result = "true";
				tes.getTestLogManager().reportMessage( "String after entry word = " + s );
			}
		}
		return result;
	}
}