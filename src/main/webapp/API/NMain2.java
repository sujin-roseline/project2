import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class NMain2 {
	public static void main(String[] args) {

		// ���̹� ������ ���� �˻�(����)
		// open API
		// rXE9C9Zc9gzEWWqu0c6M
		// w1F933M7D5

		// https://openapi.naver.com/v1/search/shop.json
		// ?query=

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("�˻���?");
			String str = sc.next();
			str = URLEncoder.encode(str, "utf-8");
			System.out.println(str);
			
			String url = "https://openapi.naver.com/v1/search/shop.json?";
			url += "query=" + str;
			System.out.println(url);
			
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			
			huc.addRequestProperty("X-Naver-Client-Id", "rXE9C9Zc9gzEWWqu0c6M");
			huc.addRequestProperty("X-Naver-Client-Secret", "w1F933M7D5");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// JSON Parser(json �Ľ��Ϸ���)
			
			JSONParser jp = new JSONParser();
			
			// JavaScript ����
			// {} ��ü
			// [] �迭
			
			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);
			
			JSONArray items = (JSONArray) naverData.get("item");
			
			for (int i = 0; i < items.size(); i++) {
				JSONObject item = (JSONObject) items.get(i);
				//String title = (String) item.get("title");
				//String title = item.get("title")+"";
				String title = item.get("title").toString();
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");
				
				System.out.println("ǰ��: " + title);
				System.out.println("����: " +item.get("lprice"));
				System.out.println("�귣��: " + item.get("brand"));
				System.out.println("------------------------");
				 jsono
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		

	}
}
