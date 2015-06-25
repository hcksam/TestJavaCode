package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class testGetHttp {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8003/PCCWTestProject/HKTHomePage/suggest.json");
		URLConnection uc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		String jsData = "";
		String line;
		while ((line = in.readLine()) != null) {
			jsData += line;
		}

		JSONObject json = new JSONObject(jsData);
		JSONObject response = json.getJSONObject("response");
		JSONArray docs = response.getJSONArray("docs");
		String[] sugs = new String[docs.length()];
		for (int i = 0; i < docs.length(); i++) {
			sugs[i] = docs.getJSONObject(i).getString("suggestion");
			System.out.println(sugs[i]);
		}
		
		in.close();
	}
}
