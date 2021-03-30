package customcode;

import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

public class GetNextCategory implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {
	public GetNextCategory() {}
	public String exec(ITestExecutionServices tes, String[] args) {
		String json_str = "{\r\n" + 
				"	\"contents\": [\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory1\",\r\n" + 
				"			\"id\": \"3074457345616677668\",\r\n" + 
				"			\"children\": \"SecondCategory1,SecondCategory2,SecondCategory3,SecondCategory4,SecondCategory5\",\r\n" + 
				"			\"ids\": \"3074457345616677674,3074457345616677675,3074457345616677676,3074457345616677677,3074457345616677678\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory2\",\r\n" + 
				"			\"id\": \"3074457345616677669\",\r\n" + 
				"			\"children\": \"SecondCategory6,SecondCategory7,SecondCategory8,SecondCategory9,SecondCategory10\",\r\n" + 
				"			\"ids\": \"3074457345616677679,3074457345616677680,3074457345616677681,3074457345616677682,3074457345616677683\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory3\",\r\n" + 
				"			\"id\": \"3074457345616677670\",\r\n" + 
				"			\"children\": \"SecondCategory11,SecondCategory12,SecondCategory13,SecondCategory14,SecondCategory15\",\r\n" + 
				"			\"ids\": \"3074457345616677684,3074457345616677685,3074457345616677686,3074457345616677687,3074457345616677688\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory4\",\r\n" + 
				"			\"id\": \"3074457345616677671\",\r\n" + 
				"			\"children\": \"SecondCategory16,SecondCategory17,SecondCategory18,SecondCategory19,SecondCategory20\",\r\n" + 
				"			\"ids\": \"3074457345616677689,3074457345616677690,3074457345616677691,3074457345616677692,3074457345616677693\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory5\",\r\n" + 
				"			\"id\": \"3074457345616677672\",\r\n" + 
				"			\"children\": \"SecondCategory21,SecondCategory22,SecondCategory23,SecondCategory24,SecondCategory25\",\r\n" + 
				"			\"ids\": \"3074457345616677694,3074457345616677695,3074457345616677696,3074457345616677697,3074457345616677698\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"TopCategory6\",\r\n" + 
				"			\"id\": \"3074457345616677673\",\r\n" + 
				"			\"children\": \"SecondCategory26,SecondCategory27,SecondCategory28,SecondCategory29,SecondCategory30\",\r\n" + 
				"			\"ids\": \"3074457345616677699,3074457345616677700,3074457345616677701,3074457345616677702,3074457345616677703\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory1\",\r\n" + 
				"			\"id\": \"3074457345616677674\",\r\n" + 
				"			\"children\": \"ThirdCategory1,ThirdCategory2,ThirdCategory3,ThirdCategory4\",\r\n" + 
				"			\"ids\": \"3074457345616677704,3074457345616677705,3074457345616677706,3074457345616677707\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory2\",\r\n" + 
				"			\"id\": \"3074457345616677675\",\r\n" + 
				"			\"children\": \"ThirdCategory5,ThirdCategory6,ThirdCategory7,ThirdCategory8\",\r\n" + 
				"			\"ids\": \"3074457345616677708,3074457345616677709,3074457345616677710,3074457345616677711\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory3\",\r\n" + 
				"			\"id\": \"3074457345616677676\",\r\n" + 
				"			\"children\": \"ThirdCategory9,ThirdCategory10,ThirdCategory11,ThirdCategory12\",\r\n" + 
				"			\"ids\": \"3074457345616677712,3074457345616677713,3074457345616677714,3074457345616677715\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory4\",\r\n" + 
				"			\"id\": \"3074457345616677677\",\r\n" + 
				"			\"children\": \"ThirdCategory13,ThirdCategory14,ThirdCategory15,ThirdCategory16\",\r\n" + 
				"			\"ids\": \"3074457345616677716,3074457345616677717,3074457345616677718,3074457345616677719\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory5\",\r\n" + 
				"			\"id\": \"3074457345616677678\",\r\n" + 
				"			\"children\": \"ThirdCategory17,ThirdCategory18,ThirdCategory19,ThirdCategory20\",\r\n" + 
				"			\"ids\": \"3074457345616677720,3074457345616677721,3074457345616677722,3074457345616677723\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory6\",\r\n" + 
				"			\"id\": \"3074457345616677679\",\r\n" + 
				"			\"children\": \"ThirdCategory21,ThirdCategory22,ThirdCategory23,ThirdCategory24\",\r\n" + 
				"			\"ids\": \"3074457345616677724,3074457345616677725,3074457345616677726,3074457345616677727\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory7\",\r\n" + 
				"			\"id\": \"3074457345616677680\",\r\n" + 
				"			\"children\": \"ThirdCategory25,ThirdCategory26,ThirdCategory27,ThirdCategory28\",\r\n" + 
				"			\"ids\": \"3074457345616677728,3074457345616677729,3074457345616677730,3074457345616677731\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory8\",\r\n" + 
				"			\"id\": \"3074457345616677681\",\r\n" + 
				"			\"children\": \"ThirdCategory29,ThirdCategory30,ThirdCategory31,ThirdCategory32\",\r\n" + 
				"			\"ids\": \"3074457345616677732,3074457345616677733,3074457345616677734,3074457345616677735\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory9\",\r\n" + 
				"			\"id\": \"3074457345616677682\",\r\n" + 
				"			\"children\": \"ThirdCategory33,ThirdCategory34,ThirdCategory35,ThirdCategory36\",\r\n" + 
				"			\"ids\": \"3074457345616677736,3074457345616677737,3074457345616677738,3074457345616677739\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory10\",\r\n" + 
				"			\"id\": \"3074457345616677683\",\r\n" + 
				"			\"children\": \"ThirdCategory37,ThirdCategory38,ThirdCategory39,ThirdCategory40\",\r\n" + 
				"			\"ids\": \"3074457345616677740,3074457345616677741,3074457345616677742,3074457345616677743\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory11\",\r\n" + 
				"			\"id\": \"3074457345616677684\",\r\n" + 
				"			\"children\": \"ThirdCategory41,ThirdCategory42,ThirdCategory43,ThirdCategory44\",\r\n" + 
				"			\"ids\": \"3074457345616677744,3074457345616677745,3074457345616677746,3074457345616677747\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory12\",\r\n" + 
				"			\"id\": \"3074457345616677685\",\r\n" + 
				"			\"children\": \"ThirdCategory45,ThirdCategory46,ThirdCategory47,ThirdCategory48\",\r\n" + 
				"			\"ids\": \"3074457345616677748,3074457345616677749,3074457345616677750,3074457345616677751\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory13\",\r\n" + 
				"			\"id\": \"3074457345616677686\",\r\n" + 
				"			\"children\": \"ThirdCategory49,ThirdCategory50,ThirdCategory51,ThirdCategory52\",\r\n" + 
				"			\"ids\": \"3074457345616677752,3074457345616677753,3074457345616677754,3074457345616677755\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory14\",\r\n" + 
				"			\"id\": \"3074457345616677687\",\r\n" + 
				"			\"children\": \"ThirdCategory53,ThirdCategory54,ThirdCategory55,ThirdCategory56\",\r\n" + 
				"			\"ids\": \"3074457345616677756,3074457345616677757,3074457345616677758,3074457345616677759\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory15\",\r\n" + 
				"			\"id\": \"3074457345616677688\",\r\n" + 
				"			\"children\": \"ThirdCategory57,ThirdCategory58,ThirdCategory59,ThirdCategory60\",\r\n" + 
				"			\"ids\": \"3074457345616677760,3074457345616677761,3074457345616677762,3074457345616677763\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory16\",\r\n" + 
				"			\"id\": \"3074457345616677689\",\r\n" + 
				"			\"children\": \"ThirdCategory61,ThirdCategory62,ThirdCategory63,ThirdCategory64\",\r\n" + 
				"			\"ids\": \"3074457345616677764,3074457345616677765,3074457345616677766,3074457345616677767\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory17\",\r\n" + 
				"			\"id\": \"3074457345616677690\",\r\n" + 
				"			\"children\": \"ThirdCategory65,ThirdCategory66,ThirdCategory67,ThirdCategory68\",\r\n" + 
				"			\"ids\": \"3074457345616677768,3074457345616677769,3074457345616677770,3074457345616677771\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory18\",\r\n" + 
				"			\"id\": \"3074457345616677691\",\r\n" + 
				"			\"children\": \"ThirdCategory69,ThirdCategory70,ThirdCategory71,ThirdCategory72\",\r\n" + 
				"			\"ids\": \"3074457345616677772,3074457345616677773,3074457345616677774,3074457345616677775\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory19\",\r\n" + 
				"			\"id\": \"3074457345616677692\",\r\n" + 
				"			\"children\": \"ThirdCategory73,ThirdCategory74,ThirdCategory75,ThirdCategory76\",\r\n" + 
				"			\"ids\": \"3074457345616677776,3074457345616677777,3074457345616677778,3074457345616677779\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory20\",\r\n" + 
				"			\"id\": \"3074457345616677693\",\r\n" + 
				"			\"children\": \"ThirdCategory77,ThirdCategory78,ThirdCategory79,ThirdCategory80\",\r\n" + 
				"			\"ids\": \"3074457345616677780,3074457345616677781,3074457345616677782,3074457345616677783\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory21\",\r\n" + 
				"			\"id\": \"3074457345616677694\",\r\n" + 
				"			\"children\": \"ThirdCategory81,ThirdCategory82,ThirdCategory83,ThirdCategory84\",\r\n" + 
				"			\"ids\": \"3074457345616677784,3074457345616677785,3074457345616677786,3074457345616677787\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory22\",\r\n" + 
				"			\"id\": \"3074457345616677695\",\r\n" + 
				"			\"children\": \"ThirdCategory85,ThirdCategory86,ThirdCategory87,ThirdCategory88\",\r\n" + 
				"			\"ids\": \"3074457345616677788,3074457345616677789,3074457345616677790,3074457345616677791\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory23\",\r\n" + 
				"			\"id\": \"3074457345616677696\",\r\n" + 
				"			\"children\": \"ThirdCategory89,ThirdCategory90,ThirdCategory91,ThirdCategory92\",\r\n" + 
				"			\"ids\": \"3074457345616677792,3074457345616677793,3074457345616677794,3074457345616677795\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory24\",\r\n" + 
				"			\"id\": \"3074457345616677697\",\r\n" + 
				"			\"children\": \"ThirdCategory93,ThirdCategory94,ThirdCategory95,ThirdCategory96\",\r\n" + 
				"			\"ids\": \"3074457345616677796,3074457345616677797,3074457345616677798,3074457345616677799\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory25\",\r\n" + 
				"			\"id\": \"3074457345616677698\",\r\n" + 
				"			\"children\": \"ThirdCategory97,ThirdCategory98,ThirdCategory99,ThirdCategory100\",\r\n" + 
				"			\"ids\": \"3074457345616677800,3074457345616677801,3074457345616677802,3074457345616677803\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory26\",\r\n" + 
				"			\"id\": \"3074457345616677699\",\r\n" + 
				"			\"children\": \"ThirdCategory101,ThirdCategory102,ThirdCategory103,ThirdCategory104\",\r\n" + 
				"			\"ids\": \"3074457345616677804,3074457345616677805,3074457345616677806,3074457345616677807\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory27\",\r\n" + 
				"			\"id\": \"3074457345616677700\",\r\n" + 
				"			\"children\": \"ThirdCategory105,ThirdCategory106,ThirdCategory107,ThirdCategory108\",\r\n" + 
				"			\"ids\": \"3074457345616677808,3074457345616677809,3074457345616677810,3074457345616677811\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory28\",\r\n" + 
				"			\"id\": \"3074457345616677701\",\r\n" + 
				"			\"children\": \"ThirdCategory109,ThirdCategory110,ThirdCategory111,ThirdCategory112\",\r\n" + 
				"			\"ids\": \"3074457345616677812,3074457345616677813,3074457345616677814,3074457345616677815\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory29\",\r\n" + 
				"			\"id\": \"3074457345616677702\",\r\n" + 
				"			\"children\": \"ThirdCategory113,ThirdCategory114,ThirdCategory115,ThirdCategory116\",\r\n" + 
				"			\"ids\": \"3074457345616677816,3074457345616677817,3074457345616677818,3074457345616677819\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"name\": \"SecondCategory30\",\r\n" + 
				"			\"id\": \"3074457345616677703\",\r\n" + 
				"			\"children\": \"ThirdCategory117,ThirdCategory118,ThirdCategory119,ThirdCategory120\",\r\n" + 
				"			\"ids\": \"3074457345616677820,3074457345616677821,3074457345616677822,3074457345616677823\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}\r\n" + 
				"";
		
		String current_category = args[ 0 ];
		
		tes.getTestLogManager().reportMessage( "1st character from current_category = " + current_category.substring(0, 5) );
		
		if ( current_category.substring(0, 5).equals("Third" ) ) {
			tes.getLoopControl().breakLoop();
		}
		
		json_str = json_str.toString().trim();
		
		JsonStreamParser p = new JsonStreamParser( json_str );
				
		String children, ids, name;
		
		// Get content json object
		JsonElement e = p.next();
		JsonObject categoryContent = e.getAsJsonObject();
		JsonArray oneCategoryContent = categoryContent.get( "contents" ).getAsJsonArray();
		JsonElement elem;
		JsonObject json_object;
		Iterator<JsonElement> iterator = oneCategoryContent.iterator();
		while ( iterator.hasNext() ) {
			elem        = iterator.next();
			json_object = elem.getAsJsonObject();
			
			name = json_object.get( "name" ).getAsString();
			//tes.getTestLogManager().reportMessage( "Checking category = " + name );
			
			if ( name.equals( current_category ) ) {
				children = json_object.get( "children" ).getAsString();
				tes.getTestLogManager().reportMessage( "We'll pick one of those = " + children );
				
				ids = json_object.get( "ids" ).getAsString();
				
				String [] a_children = children.split( "," );
				String [] a_ids = ids.split( "," );
				
				int n = (int) Math.floor( Math.random() * a_children.length );
				tes.setValue( "category_name", ITestExecutionServices.STORAGE_USER, a_children[ n ] );
				tes.setValue( "category_id", ITestExecutionServices.STORAGE_USER, a_ids[ n ] );
				tes.setValue( "category_name_lower", ITestExecutionServices.STORAGE_USER, a_children[ n ].toLowerCase() );
				tes.setValue( "category_name_espot", ITestExecutionServices.STORAGE_USER, a_children[ n ] + "Hero" );
				
				tes.getTestLogManager().reportMessage( "Category picked = " + a_children[ n ] );
				break;
			}
		}
		return null;
	}
}
