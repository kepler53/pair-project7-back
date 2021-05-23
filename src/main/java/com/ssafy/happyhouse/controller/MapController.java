package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.LegalCodeDto;
import com.ssafy.happyhouse.dto.MapDto;
import com.ssafy.happyhouse.service.MapService;

@CrossOrigin(origins = "*", allowedHeaders = "X-AUTH-TOKEN",maxAge = 3600)
@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private MapService mapservice;
	
	@GetMapping("/{str}")
	public ResponseEntity<MapDto> getMapInfo(@PathVariable("str") String address){
		
		MapDto mapDto = new MapDto();
		
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
				
				mapDto.setLatitude((String)object.get("y"));
				mapDto.setLongtitude((String)object.get("x"));
			}
        } catch (Exception e) {
            System.out.println(e);
        }
		
//      System.out.println(mapDto);
		return new ResponseEntity<MapDto>(mapDto,HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<HouseDealDto>> getHouseList(@RequestParam(value = "lng") String lng, @RequestParam(value = "lat") String lat){
		
		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
		String dong = "";
		
		try {
        	String str = lng + "," + lat;
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
//					System.out.println(region);
					JSONObject area1 = (JSONObject) region.get("area1");
//					System.out.println(area1.get("name"));
					JSONObject area2 = (JSONObject) region.get("area2");
//					System.out.println(area2.get("name"));
					JSONObject area3 = (JSONObject) region.get("area3");
//					System.out.println(area3.get("name"));
					dong = (String) area3.get("name");
					
				}
			}
        } catch (Exception e) {
            System.out.println(e);
        }
			
		System.out.println(dong);
		
		list = mapservice.getHouseList(dong);
		
		System.out.println(list.size());
		
		
		return new ResponseEntity<List<HouseDealDto>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/legalcode")
	public ResponseEntity<LegalCodeDto> getLegalCode(@RequestParam(value = "lng") String lng, @RequestParam(value = "lat") String lat){
//		System.out.println(lng+","+lat);
		String legalcode = "";
		String city = "";
		String gu = "";
		String dong = "";
		try {
        	String str = lng + "," + lat;
        	System.out.println(str);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords="+ str +"&output=json&orders=legalcode"; //json
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
            for (int i = 0; i < results.size(); i++) {
            	JSONObject object = (JSONObject) results.get(i);
//            	System.out.println(object);
            	JSONObject code =  (JSONObject) object.get("code");
//            	System.out.println(code);
//            	System.out.println(code.get("id"));
            	legalcode = (String) code.get("id");
            	legalcode = legalcode.substring(0, 5);
//            	System.out.println(legalcode);
            	
				if(code.get("type").equals("L")) {
					JSONObject region = (JSONObject) object.get("region");
//					System.out.println(region);
					JSONObject area1 = (JSONObject) region.get("area1");
//					System.out.println(area1.get("name"));
					JSONObject area2 = (JSONObject) region.get("area2");
//					System.out.println(area2.get("name"));
					JSONObject area3 = (JSONObject) region.get("area3");
//					System.out.println(area3.get("name"));
					city = (String) area1.get("name");
					gu = (String) area2.get("name");
					dong = (String) area3.get("name");
					
				}
			}
        } catch (Exception e) {
            System.out.println(e);
        }
		
		LegalCodeDto legalCodeDto = new LegalCodeDto(legalcode,city,gu,dong);
		System.out.println(legalCodeDto);
		
		return new ResponseEntity<LegalCodeDto>(legalCodeDto,HttpStatus.OK);
	}
}
