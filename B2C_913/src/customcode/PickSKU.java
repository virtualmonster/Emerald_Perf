package customcode;

//import java.util.Arrays;
import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

public class PickSKU implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	public PickSKU() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = args[ 0 ].toString().trim();
		JsonStreamParser p = new JsonStreamParser( json_str );
		int nbr_values = 0;
		String id, identifier, partnumber; 
		String ids = "", identifiers = "", partnumbers = "";
				
		JsonElement e = p.next();
		JsonObject content = e.getAsJsonObject();
		JsonArray oneContent = content.get( "contents" ).getAsJsonArray();
		
		tes.getTestLogManager().reportMessage( "After getting contents" );
				
		JsonElement element;
		JsonObject json_object;
		Iterator<JsonElement> iterator = oneContent.iterator();
		element        = iterator.next();
		if ( element.isJsonNull() ) {
			return "-1";
		}
		json_object = element.getAsJsonObject();
		if ( ! json_object.has( "items" ) ) {
			return "-1";
		}
		JsonArray items = json_object.get( "items" ).getAsJsonArray();
		JsonElement elem;
		Iterator<JsonElement> iter = items.iterator();
		while ( iter.hasNext() ) {
			elem        = iter.next();
			json_object = elem.getAsJsonObject();
			
			id = json_object.get( "id" ).getAsString();
			// tes.getTestLogManager().reportMessage( "id          = " + id );
			if ( id.isEmpty() ) {
				return "-1";
			}
			
			identifier = json_object.get( "name" ).getAsString();
			//identifier = json_object.get( "seo" ).toString().replace("{\"href\":\"/", "").replace("\"}", "");
			// tes.getTestLogManager().reportMessage( "identifier          = " + identifier );
			if ( identifier.isEmpty() ) {
				return "-1";
			}
			
			partnumber = json_object.get( "partNumber" ).getAsString();
			// tes.getTestLogManager().reportMessage( "partnumber          = " + partnumber );
			if ( partnumber.isEmpty() ) {
				return "-1";
			}
			
			nbr_values++;
			ids += id + ",";
			identifiers += identifier + ",";
			partnumbers += partnumber + ",";
		}
		
		if ( nbr_values > 0 ) {
			identifiers  = identifiers.substring( 0, identifiers.length() - 1 );
			ids          = ids.substring( 0, ids.length() - 1 );
			partnumbers = partnumbers.substring( 0, partnumbers.length() - 1 );
			
			// tes.getTestLogManager().reportMessage( "ids          = " + ids );
			// tes.getTestLogManager().reportMessage( "identifiers  = " + identifiers );
			// tes.getTestLogManager().reportMessage( "part_numbers = " + partnumbers );
			
			// Get one random category
			int n = (int) Math.floor( Math.random() * nbr_values );
			String[] a_ids = ids.split( "," );
			String[] a_identifiers = identifiers.split( "," );
			String[] a_part_numbers = partnumbers.split( "," );
			
			// tes.getTestLogManager().reportMessage( "a_ids       = " + Arrays.toString( a_ids ) );
			
			id = a_ids[ n ];
			identifier = a_identifiers[ n ];
			partnumber = a_part_numbers[ n ];
			
			tes.setValue( "sku_identifier", ITestExecutionServices.STORAGE_USER, identifier );
			tes.setValue( "sku_id", ITestExecutionServices.STORAGE_USER, id );
			tes.setValue( "sku_partnumber", ITestExecutionServices.STORAGE_USER, partnumber );
			
			tes.getTestLogManager().reportMessage( "part_number picked = " + partnumber );
			
			return "0";
		}
		else {
			return "-1";
		}
	}
}
