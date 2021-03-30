package customcode;

import java.util.Random;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */

public class SetNumberOfItemsInCart implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public SetNumberOfItemsInCart() {}
	// If a user set the argument to 0, 1 or < 0, the returned value will be 1 
	public String exec(ITestExecutionServices tes, String[] args) {
		String ns;
		int arg_int = Integer.parseInt( args[ 0 ] );
		if ( arg_int == 1 || arg_int <= 0 ) {
			tes.setValue( "current_nbr_items_in_cart", ITestExecutionServices.STORAGE_USER, "1" );
			ns = "1";
		}
		else if ( args[ 1 ] == "0" ) {
			int min = 1; 
			int max = arg_int;
			Random randomGenerator = new Random();
			int n = randomGenerator.nextInt( max - min + 1 ) + min;
			if ( n == 0 ) { 
				n = 1;
			}
			ns = String.valueOf( n );
			tes.setValue( "current_nbr_items_in_cart", ITestExecutionServices.STORAGE_USER, ns );
		}
		else {
			ns = args[ 0 ];
			tes.setValue( "current_nbr_items_in_cart", ITestExecutionServices.STORAGE_USER, ns );
		}
		tes.getTestLogManager().reportMessage( "current_nbr_items_in_cart = " + ns );
		return "0";
	}
}
