package com.ssafy.happyhouse.openApi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 네이버 기계번역 (Papago SMT) API 예제
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class GeoCode {
 
    public static void main(String[] args) {
        String clientId = "clientId ";  //clientId 
        String clientSecret = "clientSecret ";  //clientSecret 
         
        try {
            String addr = URLEncoder.encode("서울시 동작구", "UTF-8");  //주소입력
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr; //json
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
//          System.out.println(result);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            
            JSONArray addresses = (JSONArray) jsonObject.get("addresses");
//            int size = addresses.size();
//            System.out.println(addresses);
            for (int i = 0; i < addresses.size(); i++) {
				JSONObject object = (JSONObject) addresses.get(i);
				
				System.out.println(object.get("x"));
				System.out.println(object.get("y"));
			}
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}