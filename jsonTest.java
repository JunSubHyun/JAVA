

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
    
    
}
