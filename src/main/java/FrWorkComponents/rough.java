package FrWorkComponents;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class rough {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			createJson();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			readJson("C:\\Users\\vngan\\sample.json");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void createJson() throws FileNotFoundException {

		JSONObject jo = new JSONObject();

		jo.put("FirstName", "Venkat");
		jo.put("LastName", "Ganji");

		Map<String, String> addr = new HashMap<String, String>();

		addr.put("StreetName", "abc");
		addr.put("Colony", "Brindavan Colony");
		addr.put("City", "Hyderabad");
		addr.put("Pin", "505054");

		jo.put("Address", addr);

		JSONArray ja = new JSONArray();

		Map<String, String> ph1 = new HashMap<String, String>();

		ph1.put("type", "Landline");
		ph1.put("number", "123-5789-0990");
		Map<String, String> ph2 = new HashMap<String, String>();

		ph2.put("type", "Mobilr");
		ph2.put("number", "900-0900-890");

		ja.add(ph1);
		ja.add(ph2);

		jo.put("Phone", ja);

		PrintWriter pe = new PrintWriter("C:\\Users\\vngan\\sample.json");
		pe.write(jo.toJSONString());

		pe.flush();
		pe.close();

		System.out.println("Json Created");
	}

	@SuppressWarnings("unchecked")
	static void readJson(String path) throws ParseException, FileNotFoundException, IOException

	{
		JSONParser jp = new JSONParser();

		JSONObject obj = (JSONObject) jp.parse(new FileReader(path));

		System.out.println(obj.get("FirstName"));

		Map<String, String> adr = (Map) (obj.get("Address"));

		for (Entry m : adr.entrySet())
			System.out.println(m.getKey() + ":" + m.getValue());

		JSONArray js = (JSONArray) (obj.get("Phone"));

		Iterator itr = js.iterator();

		while (itr.hasNext())

		{
			Iterator<Map.Entry> itr2= ((Map) itr.next()).entrySet().iterator();
			
			while (itr2.hasNext()) {
				Map.Entry phd = itr2.next();
				System.out.println(phd.getKey()+":"+phd.getValue());
			}
		}

	}
}
