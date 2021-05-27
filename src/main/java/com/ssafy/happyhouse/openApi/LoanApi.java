package com.ssafy.happyhouse.openApi;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.IOException;
 
public class LoanApi {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://finlife.fss.or.kr/finlifeapi/mortgageLoanProductsSearch.json"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("auth","UTF-8") + "=e02267cc0010c7591b851262096a5c49"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("topFinGrpNo","UTF-8") + "=" + "050000"); /*은행정보 권역코드*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String result = sb.toString();

//        System.out.println(result);
        
        try {
//        	System.out.println("여기오긴했니");
        	JSONParser jsonParser = new JSONParser();
        	
        	JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

        	JSONObject json = (JSONObject)jsonObject.get("result");
        	
        	JSONArray productArray = (JSONArray)  json.get("optionList");
        	System.out.println(productArray.size());
//        	System.out.println(productArray);
            for(int i=0; i<productArray.size(); i++){
            	 

                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject productObject = (JSONObject) productArray.get(i);
//                System.out.println(productObject);	
                System.out.println(productObject.get("dcls_month"));
            }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
