//   e7b1a57cd2158c8d195bfb24b7597bad
//   https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=e7b1a57cd2158c8d195bfb24b7597bad
//   https://api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad   
   
   String city = sc.next();   
   String url = "https://api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad";   
         
   
   try {
         URL u = new URL(url);
         HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
         InputStream is = huc.getInputStream();
         InputStreamReader isr = new InputStreamReader(is, "utf-8");

         System.out.println(url);

         // jSON 문법
         // 언어가 다르니까 자바코드로 접근하여 처리하기 어렵다.
         // 라이브러리(도구)

         // jSON 데이터 받은거 피싱하게 jSONparser 객체가 필요
         JSONParser jp = new JSONParser();

         // 만든 객체로 isr(받은 데이터) 넣어서 파싱 준비
         JSONObject weatherData = (JSONObject) jp.parse(isr);
         System.out.println(weatherData);

   } catch (Exception e) {
      e.printStackTrace();
   }
   
      
      //원하는 데이터만
      
      //날씨 설명
      JSONArray weather = (JSONArray) weatherData.get("Weather");
      JSONArray wo = (JSONArray) weather.get(0);
      System.out.println("날씨 : "+ wo.get("description"));
      
            
      
      
      //국가
      
      JSONObject sys = (JSONObject) weatherData.get("sys");
      System.out.println("국가 : "+sys.get("country"));
      
      //도시
      System.out.println("도시 : "+ weatherData.get("name"));
      
      //온도
   JSONObject main =(JSONObject) weatherData.get("main");
      System.out.println("온도 :" + main.get"temp"));
      
      
      
      
      
      
   }
   
   
   

}