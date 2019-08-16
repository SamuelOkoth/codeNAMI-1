package dao;

import models.Contributions;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oContributionsDao implements ContributionsDao{
    private final Sql2o sql2o;
    public Sql2oContributionsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Contributions contributions) {
        String sql = "INSERT INTO contributions (code, description, challengeId, vote) VALUES (:code, :description, :challengeId, :vote)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(contributions)
                    .executeUpdate()
                    .getKey();
            contributions.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Contributions> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM contributions")
                    .executeAndFetch(Contributions.class);
        }
    }

    @Override
    public List<Contributions> getAllContributionsByChallenge(int challengeId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM contributions WHERE challengeId = :challengeId")
                    .addParameter("challengeId", challengeId)
                    .executeAndFetch(Contributions.class);
        }
    }

    @Override
    public Contributions findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM contributions WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Contributions.class);
        }
    }
}
