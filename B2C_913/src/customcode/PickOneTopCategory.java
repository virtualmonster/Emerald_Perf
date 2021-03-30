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
public class PickOneTopCategory implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public PickOneTopCategory() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = args[ 0 ];
		JsonStreamParser p = new JsonStreamParser( json_str );
		JsonElement e;
		if ( p.hasNext() ) {
			e = p.next();
		}
		else {
			tes.getTestLogManager().reportMessage( "Error in the request's reponse" );
			return "-1";
		}
		JsonObject suggestionView = e.getAsJsonObject();
		JsonArray OneSuggestionView = suggestionView.get( "suggestionView" ).getAsJsonArray();
		JsonElement elem;
		Iterator<JsonElement> iterator = OneSuggestionView.iterator();
		String value, name, path;
		String values = "", names = "";
		elem = iterator.next();
		JsonObject entry = elem.getAsJsonObject();
		JsonArray OneEntry = entry.get( "entry" ).getAsJsonArray();
		JsonObject json_object;
		Iterator<JsonElement> entry_iterator = OneEntry.iterator();
		while ( entry_iterator.hasNext() ) {
			elem        = entry_iterator.next();
			json_object = elem.getAsJsonObject();
			
			value = json_object.get( "value" ).getAsString();
			name  = json_object.get( "name" ).getAsString();
			path  = json_object.get( "fullPath" ).getAsString();
			
			// tes.getTestLogManager().reportMessage( "value = " + value + ", name = " + name + ", path = " + path );
			
			if ( path.indexOf( ">" ) != -1 ) {
				break;
			}
			
			values += value + ",";
			names  += name + ",";
		}
		if ( values.length() == 0 ) {
			tes.getTestLogManager().reportMessage( "No top categories found" );
			return "-1";
		}
		
		tes.getTestLogManager().reportMessage( "values = " + values );
		tes.getTestLogManager().reportMessage( "names  = " + names );
		
		values = values.substring( 0, values.length() - 1 );
		names  = names.substring( 0, names.length() - 1 );
		String [] a_values = values.split( "," );
		String [] a_names  = names.split( "," );
		
		// Check if we have to include 80/20
		int i;
		if ( args[ 1 ] == "1" ) {
			i = ( int )( Math.floor( a_values.length * Math.pow( Math.random(), 7 ) ) );
			tes.getTestLogManager().reportMessage( "i = " +  String.valueOf( i )  );
		}
		else if ( args[ 1 ] == "0" ) {
			i = (int) Math.floor( Math.random() * a_values.length );
			tes.getTestLogManager().reportMessage( "i = " +  String.valueOf( i )  );
		}
		else { 
			return "-1";
		}
		
		tes.setValue( "category_name", ITestExecutionServices.STORAGE_USER, a_names[ i ] );
		tes.setValue( "category_id", ITestExecutionServices.STORAGE_USER, a_values[ i ] );
		tes.setValue( "category_name_lower", ITestExecutionServices.STORAGE_USER, a_names[ i ].toLowerCase() );
		tes.setValue( "category_name_espot", ITestExecutionServices.STORAGE_USER, a_names[ i ] + "Hero" );
		
		tes.getTestLogManager().reportMessage( "Category picked = " + a_names[ i ] );
	
		return "0";
	}
}
