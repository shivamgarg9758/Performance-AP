package Performance.Performance;

public class Rest {
		
	private static String testapi = "https://";
	private static String predictapi = "https://"; 
	private static String payloadtest = "";
	public static int code = 0;
	public static RequestSpecification request;
	public static JSONObject json;
	public static Response response;
	public static String Pattern;
	public static String retrievalAPI ="";
	public static JSONArray array;

	public static void setRequestJson() {
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	public static void createJsonBody(String key1, String Value1) {
		
		json = new JSONObject();
		json.put(key1, Value1);
		request.body(json.toJSONString());
			
	}

	public static int geResponseCode() {
		response = request.post(testapi);	
		code = response.getStatusCode();
		return code;
	}

	/*@Test
	public void test() {
			
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("payload", payloadtest);
		System.out.println(request.body(json.toJSONString()));
		request.body(json.toJSONString());
		Response response = request.post(testapi);	
		code = response.getStatusCode();
		Assert.assertEquals(200, code);
		
		}*/
	@Test
	/*public void callTest() {
		RestAssuredTest.setRequestJson();
		RestAssuredTest.createJsonBody("payload", RestAssuredTest.payloadtest);
		int responsevalue = RestAssuredTest.geResponseCode();
		System.out.println(responsevalue);
		Assert.assertEquals(200, responsevalue);
		String txt = response.body().asString();
		System.out.println("#######################" + txt);
		String sub = txt.substring(10, 190);
		System.out.println(sub);
		request = null;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("x-access-token", sub);
		request.header("cache-control" , "no-cache");
		request.header("accept-encoding" , "gzip, deflate");
		request.header("User-Agent" , "PostmanRuntime/7.6.0");
		request.header("Accept" , "*");
		array = new JSONArray();
		response = null;
		json = null;
		json = new JSONObject();
		json.put("batch_id", "TR201902276766312342");	
		List<Map<String, Object>> map = new ArrayList<>();
		Map<String, Object> submap = new HashMap<>();	
		submap.put("payment_detail" , "NMSC Tangaroa ColDC 1004141773 50 Tangaroa ColDC 1004141773 50 000000000000TANGAROA COLLEGE BOA");
		submap.put("ID" , "1f07974b-b925-4cb9-b17c-dfe6bc673ad3k105512");
		json.put("payment_detail", "NMSC Tangaroa ColDC 1004141773 50 Tangaroa ColDC 1004141773 50 000000000000TANGAROA COLLEGE BOA");
		json.put("ID", "1f07974b-b925-4cb9-b17c-dfe6bc673ad3k105512");
		json.put("payment_detail", "SMTP Tangaroa ColDC 1004141773 50 Tangaroa ColDC 1004141773 50 000000000000TANGAROA COLLEGE BOA");
		json.put("ID", "1f07974b-b925-4cb9-b17c-dfe6bc673ad3k105513");
		array.add(json);
		map.add(submap);	
		//map.add((Map<String, Object>) array);
		json.put("payment_info", map);	
		request.body(json.toJSONString());
		response = request.post(predictapi);
		System.out.println(response.getStatusCode());
		
		}*/

	private void restPredicting() {
		RestAssuredTest.setRequestJson();
		RestAssuredTest.createJsonBody("payload", RestAssuredTest.payloadtest);
		int responsevalue = RestAssuredTest.geResponseCode();
		System.out.println(responsevalue);
		Assert.assertEquals(200, responsevalue);
		String txt = response.body().asString();
		System.out.println("#######################" + txt);
		String sub = txt.substring(10, 190);
		System.out.println(sub);
		File file = new File("D:\\Rest Assured\\document.json");
		given().body(file).with().contentType("application/json").header("x-access-token", sub)	
		.then().expect().body("batch_id", equalTo("TR2019022798288")).
	    statusCode(200).when().post(predictapi);	
	}
	@Test(priority = 2)
	public static void restRetrieval(){
		RestAssuredTest.setRequestJson();
		RestAssuredTest.createJsonBody("payload", RestAssuredTest.payloadtest);
		int responsevalue = RestAssuredTest.geResponseCode();
		System.out.println(responsevalue);
		Assert.assertEquals(200, responsevalue);
		String txt = response.body().asString();
		System.out.println("#######################" + txt);
		String sub = txt.substring(10, 190);
		System.out.println(sub);
		File file = new File("D:\\Rest Assured\\Retrieval.json");
	/*	given().body(file).with().contentType("application/json").header("x-access-token", sub)	
		.then().expect().body("batch_id",equalTo("TR2019022798288")).
	    statusCode(200).when().post(retrievalAPI);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String x = jsonPathEvaluator.get("batch_id.customer_detail.cust_num").toString();
		System.out.println(x);*/
		Response response = expect().statusCode(200).given().body(file).contentType("application/json").header("x-access-token", sub)
				.when().post(retrievalAPI);
				/*String responseBody = response.getBody().asString();
				System.out.println(responseBody);*/
				//JsonPath jsonPathEvaluator = response.jsonPath();
				/*List<String> jsonResponse = response.jsonPath().getList("$");
				System.out.println(jsonResponse.size());*/
		List<Map<String, Object>> jsonResponse = response.jsonPath().getList("customer_detail");
		System.out.println(jsonResponse.get(0));
		boolean cust = jsonResponse.get(0).get("cust_num").toString().equalsIgnoreCase("1004009775");
		Assert.assertEquals(true, cust);
		}	

	}



