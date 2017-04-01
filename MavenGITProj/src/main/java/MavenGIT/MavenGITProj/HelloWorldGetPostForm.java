package MavenGIT.MavenGITProj;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldGetPostForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(HelloWorldGetPostForm.class, "/");
		
		
		Spark.get("/",new Route() {
			public Object handle(final Request request,final Response response){
				try {
					Map<String,Object> fruitsMap = new HashMap<String,Object>();
					fruitsMap.put("fruits", Arrays.asList("Mango","Banana","Pineapple","Apple"));
					StringWriter strw = new StringWriter();
					Template FruitPickerTemp = config.getTemplate("FruitPicker.ftl");
					FruitPickerTemp.process(fruitsMap,strw);
					fruitsMap.clear();			
					return strw;
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		}
		});	
		
		Spark.post("/favourite_fruit",new Route() {
			public Object handle(final Request request,final Response response){
		
					String fruit = request.queryParams("fruit");
					System.out.println("Picked fruit is:"+fruit);
					if(fruit==null)
						return "Are you not picking any fruit?";
					else
						return "Your favourite fruit is " + fruit;
				
			}
		});
		
		
	}

}
