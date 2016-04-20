import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;
public class App {
	public static void main(String[] args){
		
		// This tells Spark to use the 'public' folder as the root location
		// for all static files. Access using src='/*' where * is a path to
		// an image or some other static file.
		staticFileLocation("/public");
		
		get("/", (request, response) -> {
			return new ModelAndView(new HashMap(), "templates/hello.vtl");
		}, new VelocityTemplateEngine());
	   
	   get("/favorite_photos", (request, response) ->
      "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
          "<title>Hello Friend!</title>" +
          "<link rel='stylesheet'  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
        "</head>" +
        "<body>" +
         "<h1>Favorite Traveling Photos</h1>" +
            "<ul>" +
              "<li><img src='/images/spin.jpg' alt='Pretty lights.'/></li>" +
              "<li><img src='/images/apartment.jpg' alt='Peek into apartments.'/></li>" +
              "<li><img src='/images/jellyfish.jpg' alt='A photo of a jellyfish.'/></li>" +
            "</ul>" +
        "</body>" +
        "</html>"
		);
	}
}