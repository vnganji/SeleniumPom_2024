package FrWorkComponents;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import org.checkerframework.checker.units.qual.m;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class rough1 {
	
	public static void main(String[] args) {
		
		
		try {
			createJson();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			writeJson();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void createJson() throws FileNotFoundException {
		
		JSONObject jo = new JSONObject();
		jo.put("name","mysql");
		jo.put("type","database");
		
		PrintWriter pw = new PrintWriter("C:\\Users\\vngan\\db.json");
		pw.write(jo.toJSONString());
		
		pw.flush();
		pw.close();
		
		
		
	}
	static void writeJson() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		JSONObject obj=  (JSONObject) parser.parse(new FileReader("C:\\Users\\vngan\\db.json"));
		
		HashMap<String,String> hmap = new HashMap<String,String>();
		
		
		for (Object m :obj.entrySet())
		{
			Entry m1 = (Entry) m;
			hmap.put((String) m1.getKey(), (String) m1.getValue());
			
		}
			System.out.println(hmap);
	}

}
