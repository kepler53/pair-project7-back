package com.ssafy.happyhouse.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.ibatis.session.SqlSessionException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;
import com.ssafy.happyhouse.mapper.HouseMapper;
//import com.ssafy.happyhouse.mapper.PreProcessMapper;
//import com.ssafy.preprocess.mapper.PreProcessMapper;
import com.ssafy.happyhouse.dto.ConvenienceDto;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public String addHouseDeal(HouseDealDto houseDealDto) {
		int result = template.getMapper(HouseMapper.class).addHouseDeal(houseDealDto);
		if(result >0) {
			return "됐어";
		}
		else {
			throw new SqlSessionException();
		}
	}

	@Override
	public String getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addHouseRent(HouseRentDto houseRentDto) {
		
		String address = houseRentDto.getHouserent_address();
//		String address = "경기도 성남시 분당구 불정로 6 그린팩토리";
		String[] parse = address.split(" ");
 		String city = parse[0];
 		String gu = parse[1];
 		String dong = parse[2];
 		String lat = "";
 		String lng = "";
 		
 		System.out.println(city);
 		System.out.println(gu);
 		System.out.println(dong);
// 		System.out.println(lat);
// 		System.out.println(lng);
		
        try {
        	String addr = URLEncoder.encode(address, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" +addr; //json
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
				
//				System.out.println(object.get("x"));
//				System.out.println(object.get("y"));
				lat = (String)object.get("y");
				lng = (String)object.get("x");
			}
        } catch (Exception e) {
            System.out.println(e);
        }
        houseRentDto.setHouserent_city(city);
        houseRentDto.setHouserent_gu(gu); 		
        houseRentDto.setHouserent_dong(dong);
 		houseRentDto.setHouserent_lat(lat);
 		houseRentDto.setHouserent_lng(lng);
 		
// 		System.out.println(lat+" "+lng);
 		
 		//지수 계산
		int jisu = 0;
		
		int coffee = template.getMapper(HouseMapper.class).getCoffee(lat, lng,"커피");
//		System.out.println(coffee);
		int convenience = template.getMapper(HouseMapper.class).getConv(lat,lng);
//		System.out.println(convenience);
		int school = template.getMapper(HouseMapper.class).getSchool(lat,lng);
//		System.out.println(school);
		int station = template.getMapper(HouseMapper.class).getStation(lat,lng);
//		System.out.println(station);
		int police = template.getMapper(HouseMapper.class).getPolice(lat, lng);
//		System.out.println(police);
		if(coffee>0) {
			jisu += 25;
		}if(convenience>0) {
			jisu += 25;
		}
		if(school>0) {
			jisu += 10;
		}
		if(station>0) {
			jisu += 30;
		}
		if(police>0) {
			jisu += 25;
		}
		int cctv =0;
		
//		System.out.println(jisu);
		
 		houseRentDto.setJisu(jisu);
 		
 		System.out.println(houseRentDto);
 		
 		
 		int result = template.getMapper(HouseMapper.class).addHouseRent(houseRentDto);
 		
 		
 		int no = houseRentDto.getNo();
 		System.out.println(no);
 		
 		ConvenienceDto convDto = new ConvenienceDto(no, coffee, convenience, school, cctv, police);
 		int insertconv = template.getMapper(HouseMapper.class).insertConv(convDto);
 		
 		
 		
		
		
		return null;
	}
	
	

}
