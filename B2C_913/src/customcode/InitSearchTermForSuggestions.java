//*-------------------------------------------------------------------
//* Licensed Materials - Property of HCL Technologies
//*
//* HCL Commerce
//* HCL OneTest Performance
//*-------------------------------------------------------------------
//* The sample contained herein is provided to you "AS IS".
//*
//* It is provided by HCL Commerce to demonstrate the use of HCL OneTest
//* Performance with the "Emerald" store.
//* 
//* The sample includes a selected number of scenarios. It must be 
//* extended to match the function and use of your store.
//*
//*---------------------------------------------------------------------

package customcode;

import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;
public class InitSearchTermForSuggestions implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public InitSearchTermForSuggestions() {}

	/**
	 * This custom code returns the 1st 2 characters of the search term and initial
	 * Help menu and select 'Extending Rational Performance Tester functionality' -> 'Extending test execution with custom code'
	 */
	public String exec(ITestExecutionServices tes, String[] args) {
		String searchterm = args[ 0 ];
		String partial_searchterm = args[ 1 ];
		int l = partial_searchterm.length();
		
		tes.getTestLogManager().reportMessage( "partial_searchterm = " + partial_searchterm );
				
		if ( partial_searchterm.isEmpty() ) {
			if ( searchterm.length() <= 2 ) {
				partial_searchterm = searchterm;
			}
			else {
				partial_searchterm = searchterm.substring( 0, 2 );
			}
		}
		else {
			partial_searchterm = searchterm.substring( 0, l + 1 );
		}
		
		if ( searchterm.equals( partial_searchterm ) ) {
			tes.getLoopControl().breakLoop();
		}
		tes.setValue( "partial_searchterm", ITestExecutionServices.STORAGE_USER, partial_searchterm );
		tes.getTestLogManager().reportMessage( "partial_searchterm = " + partial_searchterm );
		return partial_searchterm;
    }
}
