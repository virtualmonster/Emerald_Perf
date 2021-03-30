package customcode;

import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author Noureddine
 */
public class GetAddressesName implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetAddressesName() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = args[ 0 ];
		String result = "-1";
		
		if ( json_str.length() < 5 ) {
			tes.getTestLogManager().reportMessage( "Empty or short request's reponse" );
			return result;
		}
		
		if ( json_str.indexOf( "contact" ) == -1 ) {
			tes.getTestLogManager().reportMessage( "No address found" );
			return result;
		}
		
		// tes.getTestLogManager().reportMessage( "length is bigger than 5 and contact exist in json" );
		
		JsonStreamParser p = new JsonStreamParser( json_str );
		JsonElement e;
		if ( p.hasNext() ) {
			e = p.next();
		}
		else {
			tes.getTestLogManager().reportMessage( "Error in the request's reponse" );
			return result;
		}
		JsonObject contents = e.getAsJsonObject();
		JsonArray Contacts = contents.get( "contact" ).getAsJsonArray();
		JsonElement elem;
		JsonObject json_object;
		Iterator<JsonElement> iterator = Contacts.iterator();
		String name;
		String names = "";
		int count = 0;

		while ( iterator.hasNext() ) {
			elem        = iterator.next();
			json_object = elem.getAsJsonObject();
			name = json_object.get( "nickName" ).getAsString();
			// tes.getTestLogManager().reportMessage( " nickName = " + name );
			names += name + ",";
			
			// In worst case, we'll exist the loop after 10 iterations
			count++;
			if ( count > 10 ) {
				break;
			}
		}
		if ( count > 0 ) {
			names = names.substring( 0, names.length() - 1 );
			String [] a_names = names.split( "," );
			int i = (int) Math.floor( Math.random() * a_names.length );
			result = a_names[ i ];
			
		}
		else {
			tes.getTestLogManager().reportMessage( "There is no address to pick" );
		}
		return result;
	}
}
