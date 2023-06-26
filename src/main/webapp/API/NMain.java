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

		// ���̹� ������ ���� �˻�(����)
		// open API
		// rXE9C9Zc9gzEWWqu0c6M
		// w1F933M7D5

		// https://openapi.naver.com/v1/search/movie.xml

		// ?query=
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("�˻���?");
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

			// java xml. �ð����� �ѹ����� ������
			// javascript ->

			// ���̺귯�� mvn - kxml2
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType(); // ���� ��ġ�� �ִ� �� ����
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
						System.out.println("��ǰ��: " + msg);
					} else if (tagName.equals("lprice")) {
						System.out.println("����: " + xpp.getText());
					} else if (tagName.equals("maker")) {
						System.out.println("�Ǹ���: " + xpp.getText());
					} else if (tagName.equals("category1")) {
						System.out.println("ī�װ�: " + xpp.getText());
					}

				}
			
			xpp.next(); //�������� �̵�
			what = xpp.getEventType();
			
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
