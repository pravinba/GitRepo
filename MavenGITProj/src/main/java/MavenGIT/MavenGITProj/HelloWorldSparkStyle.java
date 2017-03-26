package MavenGIT.MavenGITProj;

import spark.Route;
import spark.Request;
import spark.Response;
import spark.Spark;

public class HelloWorldSparkStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spark.get("/",new Route() {
			public Object handle(final Request request,final Response response){
				return "Hello World from Spark";
			}
		});
	}

}
