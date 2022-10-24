package com.laundry_m.mvc.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laundry_m.mvc.controller.UsersController;
import com.laundry_m.mvc.vo.Users;

public class InsertUserView {
	private static Properties properties = new Properties();
	private static Scanner sc = new Scanner(System.in);
	private static UsersController usersController = new UsersController();
	
	private final static String ID = "^[0-9a-zA-Z]*$";
	//private final static String PASSWORD = "^[0-9]*$";
	private final static String NAME = "^[가-힣]*$";
	private final static String PHONE = "^[0-9]*$";
	static {
        String resource = "config/apiInfo.properties";
        
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	/**
	 * 회원가입 폼 메뉴
	 * */
	public static void insertUserForm() {
		String id = null;
		while (true) {
			System.out.print("\n아이디 입력 > ");
			id = sc.nextLine();
			if (id.length() > 6) {
				System.out.println("아이디는 6글자 이내로 입력해주세요.");
			} else if (!id.matches(ID)) {
				System.out.println("아이디는 알파벳 소문자와 숫자만 입력해주세요.");
			} else {
				break;
			}
		}
	
		String password = null;
		while (true) {
			System.out.print("비밀번호 입력 > ");
			password = sc.nextLine();
			
			//if (password.length() < 4 || !password.matches(PASSWORD)) {
			if (password.length() < 4) {
				System.out.println("비밀번호는 네 글자 이상 입력해주세요.\n");
			} else {
				break;
			}
		}
	
		String checkPwd = null;
		while (true) {
			System.out.print("비밀번호 확인 > ");
			checkPwd = sc.nextLine();
			
			if (!password.equals(checkPwd)) {
				System.out.println("비밀번호와 비밀번호 확인이 다릅니다.\n");
			} else {
				break;
			}
		}
	
		String name = null;
		while (true) {
			System.out.print("이름 입력 > ");
			name = sc.nextLine();
			
			if (!name.matches(NAME)) {
				System.out.println("이름은 한글만 입력해주세요.\n");
			} else {
				break;
			}
		}
	
		String phone = null;
		while (true) {
			System.out.print("전화번호 입력 > ");
			phone = sc.nextLine();
			
			if (!phone.matches(PHONE) || phone.length() == 11 == false) {
				System.out.println("전화번호는 -없이 숫자 11자리로 입력해주세요.\n");
			} else {
				break;
			}
		}
		
		String type = null;
		while (true) {
			System.out.println("회원 유형 선택 > ");
			System.out.println("[ 1. 회원 | 2. 점주 ]");
			int selectNum = Integer.parseInt(sc.nextLine());
			
			if (selectNum == 1) {
				type = "회원";
				break;
			} else if (selectNum == 2) {
				type = "점주";
				break;
			} else {
				System.out.println("번호를 다시 선택해주세요. \n");
			}
		}
		
		String address = null;
		String address2 = null;
		double latitude = 0f;
		double longtitude = 0f;
		
		while (true) {
			System.out.println("주소 입력 > ");
			System.out.println("거주중인 구을 입력해주세요 > ");
			StringBuffer buffer = new StringBuffer();
			buffer.append("서울특별시 ");
			String gu = sc.nextLine();
			
			if (!gu.equals("강남구")&&!gu.equals("강동구")&&!gu.equals("강서구")&&!gu.equals("강북구")&&!gu.equals("관악구")
					&&!gu.equals("광진구")&&!gu.equals("구로구")&&!gu.equals("금천구")&&!gu.equals("노원구")&&!gu.equals("동대문구")
					&&!gu.equals("도봉구")&&!gu.equals("동작구")&&!gu.equals("마포구")&&!gu.equals("서대문구")&&!gu.equals("성동구")
					&&!gu.equals("성북구")&&!gu.equals("서초구")&&!gu.equals("송파구")&&!gu.equals("영등포구")&&!gu.equals("용산구")
					&&!gu.equals("양천구")&&!gu.equals("은평구")&&!gu.equals("종로구")&&!gu.equals("중구")&&!gu.equals("중랑구")) {
				System.out.println("거주중인 구 정보를 정확히 입력해주세요. \n");
			} else {
				buffer.append(gu + " ");
				System.out.println("그 외 상세주소를 입력해주세요(도로명주소) > ");
				buffer.append(sc.nextLine());
				address = buffer.toString();
				
				String lati = getXYMapfromJson(getKakaoApiFromAddress(address)).get("y");
				String longti = getXYMapfromJson(getKakaoApiFromAddress(address)).get("x");
				latitude = Double.parseDouble(lati);
				longtitude = Double.parseDouble(longti);
				//System.out.println(lati);
				//System.out.println(longti);
				break;
			}
			
		}
		String state = "N";
		usersController.insertUser(new Users(id, password, name, phone, type, address, state, latitude, longtitude));
	}
	
	public static String getKakaoApiFromAddress(String roadFullAddr) {
	    String apiKey = properties.getProperty("apiKey");
	    String apiUrl = properties.getProperty("apiUrl");
	    String jsonString = null;

	    try {
	        roadFullAddr = URLEncoder.encode(roadFullAddr, "UTF-8");

	        String addr = apiUrl + "?query=" + roadFullAddr;

	        URL url = new URL(addr);
	        URLConnection conn = url.openConnection();
	        conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

	        BufferedReader rd = null;
	        rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        StringBuffer docJson = new StringBuffer();

	        String line;

	        while ((line=rd.readLine()) != null) {
	            docJson.append(line);
	        }

	        jsonString = docJson.toString();
	        rd.close();

	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return jsonString;
	}
	
	public static HashMap<String, String> getXYMapfromJson(String jsonString) {
	    ObjectMapper mapper = new ObjectMapper();
	    HashMap<String, String> XYMap = new HashMap<String, String>();

	    try {
	        TypeReference<Map<String, Object>> typeRef 
	            = new TypeReference<Map<String, Object>>(){};
	        Map<String, Object> jsonMap = mapper.readValue(jsonString, typeRef);

	        @SuppressWarnings("unchecked")
	        List<Map<String, String>> docList 
	            =  (List<Map<String, String>>) jsonMap.get("documents");	

	        Map<String, String> adList = (Map<String, String>) docList.get(0);
	        XYMap.put("x",adList.get("x"));
	        XYMap.put("y", adList.get("y"));

	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return XYMap;
	}
}
