package com.ssafy.happyhouse.openApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReverseGeoCode {
	 
    public static void main(String[] args) {
        String clientId = "clientId ";  //clientId 
        String clientSecret = "clientSecret ";  //clientSecret 
         
        try {
        	String str = "126.9774011,37.561261";
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords="+ str +"&output=json"; //json
            //String apiURL = "https://openapi.naver.com/v1/map/geocode.xml?query=" + addr; // xml
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "09vzyngctu");
            con.setRequestProperty("X-NCP-APIGW-API-KEY", "z1VHkKMWkWpnIhz7alV3oXpysduy3SSUgvkXdIEb");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            String result = response.toString();
//            System.out.println(result);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
//            System.out.println(jsonObject);
            JSONArray results = (JSONArray) jsonObject.get("results");
//            System.out.println(results);
            for (int i = 0; i < results.size(); i++) {
				JSONObject object = (JSONObject) results.get(i);
				
				JSONObject code = (JSONObject) object.get("code");
//				System.out.println(code);
//				System.out.println(code.get("type"));
				if(code.get("type").equals("L")) {
					JSONObject region = (JSONObject) object.get("region");
					System.out.println(region);
					JSONObject area1 = (JSONObject) region.get("area1");
					System.out.println(area1.get("name"));
					JSONObject area2 = (JSONObject) region.get("area2");
					System.out.println(area2.get("name"));
					JSONObject area3 = (JSONObject) region.get("area3");
					System.out.println(area3.get("name"));
				}
			}
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
