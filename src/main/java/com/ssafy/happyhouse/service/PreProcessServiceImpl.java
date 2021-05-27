package com.ssafy.happyhouse.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseRentDto;
import com.ssafy.happyhouse.mapper.PreProcessMapper;

@Service
public class PreProcessServiceImpl implements PreProcessService {

	@Autowired
	private SqlSessionTemplate template;

	@Override
	public String preproces() {
		
		List<HouseRentDto> plist = template.getMapper(PreProcessMapper.class).getHouseRent();
		
		System.out.println(plist.size());
		System.out.println(plist.get(1));
		
		
		for (int j = 1000; j < plist.size(); j++) {
			String address = plist.get(j).getHouserent_address();
			String lat = "";
			String lng = "";
			
	        try {
	            String addr = URLEncoder.encode(address, "UTF-8");  //주소입력
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
//	          System.out.println(result);
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
	            
	            JSONArray addresses = (JSONArray) jsonObject.get("addresses");
//	            int size = addresses.size();
//	            System.out.println(addresses);
	            for (int i = 0; i < addresses.size(); i++) {
					JSONObject object = (JSONObject) addresses.get(i);
					
//					System.out.println(object.get("x"));
//					System.out.println(object.get("y"));
					
					lat = (String)object.get("y");
					lng = (String)object.get("x");
					
					System.out.println("y"+(String)object.get("y")); //y lat
					System.out.println("x"+(String)object.get("x")); //x lng
				}
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println(lat+" "+lng);
			
	        int reulst = template.getMapper(PreProcessMapper.class).updateHouseRent(lat, lng, address);
		}
		
        
		
		return null;
	}
	
	
}
