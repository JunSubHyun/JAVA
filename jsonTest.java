

public class jsonTest {
	
	private static jsonTest instance;
	
	public static jsonTest getInstance() {			//instance 선언
		if (instance == null) {
			instance = new jsonTest();
		}
		return instance;
	}  
	
  
    
    //JSONArray 만들기 -> 데이터를 JSONArray로 묶어 다시 JSONObject 로 리턴
    public static JSONObject jsonObjectMaking (){
		JSONObject jsonObj1 = new JSONObject();						// 1번 JSONObject 선언
		JSONArray jsonArr = new JSONArray();						// JSONArrary   선언
		JSONObject jsonObj2 = new JSONObject();					// 2번(리턴할) JSONObject 선언
		
		jsonObj1.put("data1","전송할");								//1번 JSONObject 에 데이터 넣기
		jsonObj1.put("data2","데이터");
		jsonObj1.put("data3","넣기");
		
		System.out.println("jsonObj1_result   :   "+jsonObj1.toString());
//	    jsonObj1_result   :   {"data3":"넣기","data2":"데이터","data1":"전송할"}
		
		jsonArr.add(jsonObj1);										//1번 JSONObject 를 JSONArrary에 넣기
		System.out.println("jsonArr_result   :   "+jsonArr.toString());
//	    jsonArr_result   :   [{"data3":"넣기","data2":"데이터","data1":"전송할"}]
		
		jsonObj2.put("JSONArrary이름", jsonArr);					// 2번에  JSONArrary 넣기
		jsonObj2.put("JSONObject일반 데이터", "일반 데이터");					// 2번에  JSONArrary 넣기
		System.out.println("jsonObj2   :   "+jsonObj2.toString());
//	    jsonObj2   :   {"JSONArrary이름":[{"data3":"넣기","data2":"데이터","data1":"전송할"}],"JSONObject일반 데이터":"일반 데이터"}
		
		return jsonObj2;
	}
    
     //JSONArray 만들기 -> 데이터를 JSONArray로 묶어 다시 JSONObject 로 리턴
    public static String jsonParsing (){
		
		String result = "";

		String data1 = "";
		String data2 = "";
		String data3 = "";


		JSONParser jsonParse = new JSONParser();			//JSONParser 선언
		JSONObject jsonObj1 = jsonObjectMaking ()			//JSONObject 데이터
//	   	jsonObj1   :   {"JSONArrary이름":[{"data3":"넣기","data2":"데이터","data1":"전송할"}],"JSONObject일반 데이터":"일반 데이터"}
	
		String jsonStr = jsonObj1.toString();			//JSONObject를 String 으로 캐스팅
//		jsonStr   :   {"JSONArrary이름":[{"data3":"넣기","data2":"데이터","data1":"전송할"}],"JSONObject일반 데이터":"일반 데이터"}

		//JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
		JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonObj1); 
	
		//JSONObject에서 jsonArr를 get하여 JSONArray에 저장한다. 
		JSONArray jsonArr = (JSONArray) jsonObj.get("JSONArrary이름"); 
		System.out.println("JSONArrary이름   :   "+jsonArr.toString());
//		JSONArrary이름	:	{"data3":"넣기","data2":"데이터","data1":"전송할"}
		
		//jsonArr 를 반복문으로 JSONArray 안에 데이터를 가져온다
		for(int i=0; i < jsonArr.size(); i++) {

			JSONObject arrObject = (JSONObject) jsonArr.get(i);	//JSONArray안 데이터를 JSONObject 로 선언하여 Key Value 로 추출
			
			//get으로 JSONObject 안에 데이터 추출
			data1 = jsonArr.get("data1");
			System.out.println("data1	:	"+jsonArr.get("data1"));	//data1	:	전송할	
			
			data2 = jsonArr.get("data2");
			System.out.println("data2	:	"+jsonArr.get("data2"));	//data2	:	데이터
			
			data3 = jsonArr.get("data3");
			System.out.println("data3	:	"+jsonArr.get("data3"));	//data3	:	넣기
		
			
		} 
		
		result = data1 + data2 + data3;
		System.out.println("result	:	"+result);
//		result	:	전송할 데이터 넣기
		return result;
	}
}
