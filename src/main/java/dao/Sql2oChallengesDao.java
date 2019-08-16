package dao;

import models.Challenges;
import models.Contributions;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oChallengesDao implements ChallengesDao{
    private final Sql2o sql2o;
    public Sql2oChallengesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Challenges challenges) {
        String sql = "INSERT INTO challenges (name, code, details, userId, vote) VALUES (:name, :code, :details, :userId, :vote)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(challenges)
                    .executeUpdate()
                    .getKey();
            challenges.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Challenges> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM challenges")
                    .executeAndFetch(Challenges.class);
        }
    }

    @Override
    public List<Challenges> getAllChallengesByUser(int userId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM challenges WHERE userId = :userId")
                    .addParameter("userId", userId)
                    .executeAndFetch(Challenges.class);
        }
    }

    @Override
    public Challenges findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM challenges WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Challenges.class);
        }
    }
}
