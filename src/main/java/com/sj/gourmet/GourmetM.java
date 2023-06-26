package com.sj.gourmet;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.sql.Result;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import netscape.javascript.JSObject;
import java.sql.Connection;

public class GourmetM {

	public static void searchGourmet(HttpServletRequest request, Object String) {

		try {
			request.setCharacterEncoding("UTF-8"); // post �슂泥� �떆 �븳湲� �븞源⑥�寃� �븯�뒗 踰�
			
			String input = request.getParameter("input");
			System.out.println(input);
			input = URLEncoder.encode(input, "utf-8");
			System.out.println(input);

			String select = request.getParameter("select");
			System.out.println(select);
			String url = ""; 
			System.out.println(url);
			if (select.equals("name")) {
				url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag&title=" + input;
			} else if (select.equals("location")) {
				url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag&alltag=" + input;
			}
			
			System.out.println(url);
			
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println("isr" + isr);

			JSONParser jp = new JSONParser();
			JSONObject restaurant = (JSONObject) jp.parse(isr);
			System.out.println("restaurant :" + restaurant);	 
//			JSONObject items = (JSONObject) restaurant.get("items");
//			System.out.println("items :" + items);	 
//			JSONObject repPhoto = (JSONObject) items.get("repPhoto");
//			System.out.println("repPhoto :" + repPhoto);	 
//			JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//			System.out.println("photoid :" + photoid);	 
			JSONArray data = (JSONArray) restaurant.get("items");
			System.out.println(data);
			
			System.out.println(data.size());
			ArrayList<GourmetInfo> gourmetInfos = new ArrayList<GourmetInfo>();
			String id = "";
			String name = "";
			String tel = "";
			String addr = "";
			String menu = "";
			String img = "";
			for (int i = 0; i < data.size(); i++) {
				GourmetInfo gourmetInfo = new GourmetInfo();
				JSONObject info = (JSONObject) data.get(i);
				
				JSONObject repPhoto = (JSONObject) info.get("repPhoto");
//				System.out.println("repPhoto :" + repPhoto);	 
				JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//				System.out.println("photoid :" + photoid);	 
				
				id = (String) info.get("contentsid");
				name = (String) info.get("title");
//				System.out.println("-----------");
//				System.out.println(name);
				tel = (String) info.get("phoneno");
//				System.out.println(tel);
				addr = (String) info.get("roadaddress");
//				System.out.println(addr);
				menu = (String) info.get("alltag");
//				System.out.println(menu);
				img = (String) photoid.get("imgpath");
//				System.out.println(img);
//				System.out.println("------------");

				gourmetInfo.setId(id);
				gourmetInfo.setName(name); 
				gourmetInfo.setTel(tel);
				gourmetInfo.setAddr(addr); 
				gourmetInfo.setMenu(menu);
				gourmetInfo.setImg(img);

				gourmetInfos.add(gourmetInfo);

			}
			request.setAttribute("gourmetInfos", gourmetInfos);
			request.setAttribute("input", input);
			request.setAttribute("select", select);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public static void mapGourmet(HttpServletRequest request) {
	 * 
	 * String addr = request.getParameter("addr"); System.out.println(addr);
	 * request.setAttribute("addr", addr);
	 * 
	 * }
	 * 
	 * public static void saveDB(HttpServletRequest request) {
	 * 
	 * Connection con = null; PreparedStatement pstmt = null;
	 * 
	 * String sql = "insert into sj_gourmet_db value (?,?,?,?,?,?,?,?,?,?)";
	 * 
	 * try { con = DBManager.connect(); pstmt = con.prepareStatement(sql);
	 * 
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * 
	 * 
	 * String url = ""; url =
	 * "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4";
	 * 
	 * URL u = new URL(url); HttpsURLConnection huc = (HttpsURLConnection)
	 * u.openConnection(); InputStream is = huc.getInputStream(); InputStreamReader
	 * isr = new InputStreamReader(is, "utf-8"); System.out.println("isr" + isr);
	 * 
	 * JSONParser jp = new JSONParser(); JSONObject restaurant = (JSONObject)
	 * jp.parse(isr); System.out.println("restaurant :" + restaurant); // JSONObject
	 * items = (JSONObject) restaurant.get("items"); // System.out.println("items :"
	 * + items); // JSONObject repPhoto = (JSONObject) items.get("repPhoto"); //
	 * System.out.println("repPhoto :" + repPhoto); // JSONObject photoid =
	 * (JSONObject) repPhoto.get("photoid"); // System.out.println("photoid :" +
	 * photoid); JSONArray data = (JSONArray) restaurant.get("items");
	 * System.out.println(data);
	 * 
	 * System.out.println(data.size()); ArrayList<GourmetInfo> gourmetInfos = new
	 * ArrayList<GourmetInfo>(); String name = ""; String tel = ""; String addr =
	 * ""; String menu = ""; String img = ""; for (int i = 0; i < data.size(); i++)
	 * { GourmetInfo gourmetInfo = new GourmetInfo(); JSONObject info = (JSONObject)
	 * data.get(i);
	 * 
	 * JSONObject repPhoto = (JSONObject) info.get("repPhoto"); //
	 * System.out.println("repPhoto :" + repPhoto); JSONObject photoid =
	 * (JSONObject) repPhoto.get("photoid"); // System.out.println("photoid :" +
	 * photoid);
	 * 
	 * 
	 * name = (String) info.get("title"); // System.out.println("-----------"); //
	 * System.out.println(name); tel = (String) info.get("phoneno"); //
	 * System.out.println(tel); addr = (String) info.get("roadaddress"); //
	 * System.out.println(addr); menu = (String) info.get("alltag"); //
	 * System.out.println(menu); img = (String) photoid.get("imgpath"); //
	 * System.out.println(img); // System.out.println("------------");
	 * 
	 * 
	 * gourmetInfo.setName(name); gourmetInfo.setTel(tel);
	 * gourmetInfo.setAddr(addr); gourmetInfo.setMenu(menu);
	 * gourmetInfo.setImg(img);
	 * 
	 * gourmetInfos.add(gourmetInfo);
	 * 
	 * } request.setAttribute("gourmetInfos", gourmetInfos);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { DBManager.close(con,
	 * pstmt, null); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public static void reviewGourmet(HttpServletRequest request) {

		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String sql = "insert into sj_gourmet_review values (gm_no_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			request.setCharacterEncoding("utf-8");
			double grade = Double.parseDouble(request.getParameter("sj-reviewGrade"));
			String reviewCon = request.getParameter("sj-r_text");
			String reviewMenu = request.getParameter("sj-r_text");
			String reviewPic = request.getParameter("sj-r_pic");
			
			pstmt.setDouble(1, grade);
			pstmt.setString(2, reviewCon);
			pstmt.setString(3, reviewMenu);
			pstmt.setString(4, reviewPic);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공!");
				request.setAttribute("등록성공", "등록성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "db server error...");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

}
