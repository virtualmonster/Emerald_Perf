package customcode;

//import java.util.Arrays;
import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

public class PickProduct implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public PickProduct() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = args[ 0 ].toString().trim();
		
		JsonStreamParser p = new JsonStreamParser( json_str );
		String id, partnumber, seo, type;
		String searched_id, searched_type, searched_item;
		String ids = "", seos = "", partnumbers = "";
		//JsonElement seo;
		
		// Because the resultset is different, I needed to look for different key depending on which resultset I get. This test is the decision
		if ( json_str.indexOf( "catalogEntryTypeCode" ) == -1 ) {
			searched_type = "type";
			searched_id   = "id";
			searched_item = "product";
			tes.getTestLogManager().reportMessage( "We didn't find 'catalogEntryTypeCode' in the json file" );
		}
		else {
			searched_type = "catalogEntryTypeCode";
			searched_id   = "uniqueID";
			searched_item = "ProductBean";
			tes.getTestLogManager().reportMessage( "We did find 'catalogEntryTypeCode' in the json file" );
		}
		
		// Get content json object
		JsonElement e = p.next();
		JsonObject content = e.getAsJsonObject();
		JsonArray oneContent = content.get( "contents" ).getAsJsonArray();

		int nbr_values = 0;
		JsonElement elem;
		JsonObject json_object;
		Iterator<JsonElement> iterator = oneContent.iterator();
		while ( iterator.hasNext() ) {
			elem        = iterator.next();
			json_object = elem.getAsJsonObject();
						
			type = json_object.get( searched_type ).getAsString();
			//tes.getTestLogManager().reportMessage( "type         = " + type );
			
			if ( type.equals( searched_item ) ) {
				id = json_object.get( searched_id ).getAsString();
				// tes.getTestLogManager().reportMessage( "id         = " + id );
				
				seo = json_object.get( "name" ).getAsString();
				//seo = json_object.get( "seo" ).toString().replace("{\"href\":\"/", "").replace("\"}", "");
				// tes.getTestLogManager().reportMessage( "seo         = " + seo );
				
				partnumber = json_object.get( "partNumber" ).getAsString();
				// tes.getTestLogManager().reportMessage( "partnumber         = " + partnumber );
				
				nbr_values++;
				ids += id + ",";
				seos += seo + ",";
				partnumbers += partnumber + ",";
			}
		}
		if ( nbr_values > 0 ) {
			seos         = seos.substring( 0, seos.length() - 1 );
			ids          = ids.substring( 0, ids.length() - 1 );
			partnumbers = partnumbers.substring( 0, partnumbers.length() - 1 );
			
			// tes.getTestLogManager().reportMessage( "ids         = " + ids );
			// tes.getTestLogManager().reportMessage( "identifiers = " + seos );
			// tes.getTestLogManager().reportMessage( "part_numbers = " + partnumbers );
			
			// Get one random category
			//int n = (int) Math.floor( Math.random() * nbr_values );
			
			String[] a_ids = ids.split( "," );
			String[] a_seos = seos.split( "," );
			String[] a_part_numbers = partnumbers.split( "," );
			
			// tes.getTestLogManager().reportMessage( "a_ids       = " + Arrays.toString( a_ids ) );
			
			// Check if we have to include 80/20
			int i;
			if ( args[ 1 ] == "1" ) {
				i = ( int )( Math.floor( a_ids.length * Math.pow( Math.random(), 7 ) ) );
			}
			else if ( args[ 1 ] == "0" ) {
				i = (int) Math.floor( Math.random() * a_ids.length );
			}
			else { 
				return "-1";
			}
			
			id = a_ids[ i ];
			seo = a_seos[ i ];
			partnumber = a_part_numbers[ i ];
			
			tes.setValue( "product_identifier", ITestExecutionServices.STORAGE_USER, seo );
			tes.setValue( "product_id", ITestExecutionServices.STORAGE_USER, id );
			tes.setValue( "part_number", ITestExecutionServices.STORAGE_USER, partnumber );
			
			tes.getTestLogManager().reportMessage( "id         = " + id );
			tes.getTestLogManager().reportMessage( "identifier = " + seo );
			tes.getTestLogManager().reportMessage( "part_number = " + partnumber );
					
			return "true";
		}
		else {
			return "false";
		}
	}
}
