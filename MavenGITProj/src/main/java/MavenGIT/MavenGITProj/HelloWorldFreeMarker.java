package MavenGIT.MavenGITProj;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class HelloWorldFreeMarker {

	public static void main(String args[])
	{
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		try {
			Template helloTemp = config.getTemplate("hello.ftl");
			StringWriter strw = new StringWriter();
			Map<String,Object> helloMap = new HashMap<String,Object>();
			helloMap.put("name", "Pravin");
			helloTemp.process(helloMap,strw);
			System.out.println(strw);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
