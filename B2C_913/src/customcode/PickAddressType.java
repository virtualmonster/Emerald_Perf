package customcode;

import java.util.Random;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class PickAddressType implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	public PickAddressType() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String[] addr_types = { "ShippingAndBilling", "Shipping", "Billing" };
		Random r = new Random();
		int low = 0;
		int high = addr_types.length - 1;
		int i = r.nextInt( high - low ) + low;
		return addr_types[ i ];
	}
}
