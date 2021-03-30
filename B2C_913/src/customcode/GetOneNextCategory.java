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
public class GetOneNextCategory implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	public GetOneNextCategory() {}

	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = args[ 0 ];
		String ret;
		if ( json_str.length() < 5 ) {
			tes.getTestLogManager().reportMessage( "Empty or short request's reponse" );
			tes.getLoopControl().breakLoop();
			return "Error";
		}
		JsonStreamParser p = new JsonStreamParser( json_str );
		JsonElement e;
		if ( p.hasNext() ) {
			e = p.next();
		}
		else {
			tes.getTestLogManager().reportMessage( "Error in the request's reponse" );
			tes.getLoopControl().breakLoop();
			return "Error";
		}
		JsonObject contents = e.getAsJsonObject();
		JsonArray OneContents = contents.get( "contents" ).getAsJsonArray();
		JsonElement elem;
		JsonObject json_object, links;
		Iterator<JsonElement> iterator = OneContents.iterator();
		String id, name;
		String ids = "", names = "";
		
		int count = 0;
			
		boolean already_tested = false;
		while ( iterator.hasNext() ) {
			elem        = iterator.next();
			json_object = elem.getAsJsonObject();
			
			if ( ! already_tested ) {
				links = json_object.get( "links" ).getAsJsonObject();
				if ( ! links.has( "children" ) ) {
					tes.getLoopControl().breakLoop();
					ret = "EndLoop";
				}
				already_tested = true;
			}
			
			id   = json_object.get( "id" ).getAsString();
			name = json_object.get( "name" ).getAsString();
			
			tes.getTestLogManager().reportMessage( " name = " + name );
			
			ids   += id + ",";
			names += name + ",";
			
			// In worst case, we'll exist the loop after 10 iterations
			count++;
			tes.getTestLogManager().reportMessage( " count = " + String.valueOf( count ) );
			if ( count > 10 ) {
				tes.getLoopControl().breakLoop();
				ret = "EndLoop";
				break;
			}
		}
		if ( ids.length() == 0 ) {
			ret = "Error";
		}
		else {
			ids   = ids.substring( 0, ids.length() - 1 );
			names = names.substring( 0, names.length() - 1 );
			String [] a_ids   = ids.split( "," );
			String [] a_names = names.split( "," );
			
			//int i = (int) Math.floor( Math.random() * a_ids.length );
			
			// Check if we have to include 80/20
			int i;
			if ( args[ 1 ] == "1" ) {
				i = ( int )( Math.floor( a_ids.length * Math.pow( Math.random(), 7 ) ) );
			}
			else if ( args[ 1 ] == "0" ) {
				i = (int) Math.floor( Math.random() * a_ids.length );
			}
			else { 
				return "Error";
			}
			
			tes.setValue( "category_name", ITestExecutionServices.STORAGE_USER, a_names[ i ] );
			tes.setValue( "category_id", ITestExecutionServices.STORAGE_USER, a_ids[ i ] );
			tes.setValue( "category_name_lower", ITestExecutionServices.STORAGE_USER, a_names[ i ].toLowerCase() );
			tes.setValue( "category_name_espot", ITestExecutionServices.STORAGE_USER, a_names[ i ] + "Hero" );
			
			tes.getTestLogManager().reportMessage( "Category picked = " + a_names[ i ] );
			
			ret = "Continue";
		}
		return ret;
	}
}
