package MavenGIT.MavenGITProj;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldFreemarkerSparkStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(HelloWorldFreemarkerSparkStyle.class, "/");
		final 	StringWriter strw = new StringWriter();
		
		Spark.get("/",new Route() {
			public Object handle(final Request request,final Response response){
				try {
					Template helloTemp = config.getTemplate("hello.ftl");
					Map<String,Object> helloMap = new HashMap<String,Object>();
					helloMap.put("name", "Pravin");
					helloTemp.process(helloMap,strw);
					System.out.println(strw);
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "I'm done";	
			}
		});
	}

}
