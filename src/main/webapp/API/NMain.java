import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class NMain {
	public static void main(String[] args) {

		// 네이버 개발자 센터 검색(쇼핑)
		// open API
		// rXE9C9Zc9gzEWWqu0c6M
		// w1F933M7D5

		// https://openapi.naver.com/v1/search/movie.xml

		// ?query=
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어?");
		String str = sc.next();
			str = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(str);

		String url = "https://openapi.naver.com/v1/search/shop.xml?";
		url += "query=" + str;
		System.out.println(url);
		try {
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "rXE9C9Zc9gzEWWqu0c6M");
			huc.addRequestProperty("X-Naver-Client-Secret", "w1F933M7D5");

			InputStream is = huc.getInputStream();

			// java xml. 시간낭비 한번쯤은 볼만함
			// javascript ->

			// 라이브러리 mvn - kxml2
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType(); // 현재 위치에 있는 게 뭐냐
			String tagName = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					System.out.println(tagName);
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("title")) {
						String msg = xpp.getText();
						msg = msg.replace("<b>", 0);
						msg = msg.replace("</b>", 0);
						System.out.println("상품명: " + msg);
					} else if (tagName.equals("lprice")) {
						System.out.println("가격: " + xpp.getText());
					} else if (tagName.equals("maker")) {
						System.out.println("판매점: " + xpp.getText());
					} else if (tagName.equals("category1")) {
						System.out.println("카테고리: " + xpp.getText());
					}

				}
			
			xpp.next(); //다음으로 이동
			what = xpp.getEventType();
			
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
