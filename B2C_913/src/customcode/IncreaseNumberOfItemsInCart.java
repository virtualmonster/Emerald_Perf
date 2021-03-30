package customcode;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

public class IncreaseNumberOfItemsInCart implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	public IncreaseNumberOfItemsInCart() {}

	public String exec(ITestExecutionServices tes, String[] args) {
		int n = Integer.parseInt( args[ 0 ] ) - 1;
		tes.setValue( "current_nbr_items_in_cart", ITestExecutionServices.STORAGE_USER, String.valueOf( n ) );
		//tes.setValue( "local_nbr_items", ITestExecutionServices.STORAGE_USER, String.valueOf( n ) );
		
		tes.getTestLogManager().reportMessage( "local_nbr_items = " + String.valueOf( n ) );
		
		if ( n <= 0 ) {
			tes.getLoopControl().breakLoop();
		}
		return String.valueOf( n );
	}
}
