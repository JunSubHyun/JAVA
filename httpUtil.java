

public class httpUtil {
	
	private static jsonTest instance;
	
	public static jsonTest getInstance() {			//instance 선언
		if (instance == null) {
			instance = new jsonTest();
		}
		return instance;
	}  
	
    public static String httpUtile() {
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        JSONArray  jArray = new JSONArray();
        String result = "";
        try {
        	
            String pURL =  "http://aifolio.cafe24.com/modu_similar/";				//통신 URL
            JSONObject obj = new JSONObject();										//전송할 body 
            obj.put("bodyData", "bodyData1");												//body 안에 데이터 넣기
            //		key		  ,  value
            URL url = new URL(pURL);												//url 선언
            HttpURLConnection con = (HttpURLConnection) url.openConnection();		//httpUrl 커넥션
            
            con.setRequestMethod("POST");											//전송 Method 선언  -> post/get
           //RequestProperty -> 필요한 설정들 세팅
            con.setRequestProperty("content-type", "application/json");				//content-type -> 전송 데이터 포멧
            con.setRequestProperty("referer", SiteProperty.COMPANY_URL);			//referer Url 설정
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(obj.toString());											//body 에 데이터 집어넣기
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();			
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;		
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            
            in.close();

          System.out.println("HTTP 응답 코드 : " + responseCode);					//응답 (response)코드 -> 200:성공
		  System.out.println("HTTP Body : " + response.toString());				//응답 (response)에 돌아오는 데이터

        	

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
    
  
    
}
