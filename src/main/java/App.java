import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/profile/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            response.redirect("/signIn");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/signIn", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "signIn.hbs");
        }, new HandlebarsTemplateEngine());

        post("/challenges", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "challenge.hbs");
        }, new HandlebarsTemplateEngine());

        get("/challenges", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "challenge.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/challenge", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/profile", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());
    }
}