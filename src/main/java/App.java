import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Sql2oChallengesDao;
import dao.Sql2oContributionsDao;
import dao.Sql2oUserDao;
import models.Challenges;
import models.Contributions;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Sql2oChallengesDao challengesDao;
        Sql2oContributionsDao contributionsDao;
        Connection conn;

        String connectionString = "jdbc:postgresql://localhost:5432/codenami";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "1234");

        userDao = new Sql2oUserDao(sql2o);
        challengesDao = new Sql2oChallengesDao(sql2o);
        contributionsDao = new Sql2oContributionsDao(sql2o);
        conn = sql2o.open();


        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //creating a new user
        post("/users/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String username = request.queryParams("username");
            String email = request.queryParams("email");
            String password = request.queryParams("password");
            String bio = "I love programming";
            String profilePic = "wuuye";
            User user = new User(username, email, password, bio, profilePic);
            userDao.add(user);
            return new ModelAndView(model, "challenge.hbs");
        }, new HandlebarsTemplateEngine());

        get("/users/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            List<User>users = userDao.getAll();
            model.put("users", users);
            return new ModelAndView(model, "profile.hbs");
        }, new HandlebarsTemplateEngine());

        get("/users/:userId/challenge", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/users/:userId/challenges/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String code = request.queryParams("code");
            String details = request.queryParams("details");
            int userId = Integer.parseInt(request.params("userId"));
            int vote = 12;
            Challenges challenges = new Challenges(name, code, details, vote);
            challenges.setUserId(userId);
            challengesDao.add(challenges);
            return new ModelAndView(model, "challenge.hbs");
        }, new HandlebarsTemplateEngine());

        get("/users/:id/challenges", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int userId = Integer.parseInt(request.params("id"));
            User userToFind = userDao.findById(userId);
            List<Challenges> allChallenges;
            allChallenges = challengesDao.getAllChallengesByUser(userId);
            model.put("allChallenges", allChallenges);
            return new ModelAndView(model, "challenge.hbs");
        }, new HandlebarsTemplateEngine());


        post("/users/:userId/challenges/:challengeId/contributions/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String code = request.queryParams("code");
            String description = request.queryParams("description");
            int challengeId = Integer.parseInt(request.params("challengeId"));
            int vote = 12;
            Contributions contributions = new Contributions(code, description, challengeId, vote);
            contributions.setChallengeId(challengeId);
            contributionsDao.add(contributions);
            return new ModelAndView(model, "view.hbs");
        }, new HandlebarsTemplateEngine());


        get("/users/:userId/challenges/:challengeId/contribution", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "view.hbs");
        }, new HandlebarsTemplateEngine());
        //serious routes end here
    }
}