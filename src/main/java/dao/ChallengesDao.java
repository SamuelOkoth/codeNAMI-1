package dao;

import models.Challenges;
import models.Contributions;

import java.util.List;

public interface ChallengesDao {
    void add(Challenges challenges);
    Challenges findById(int challengesId);
    List<Challenges>getAll();
    List<Challenges> getAllChallengesByUser(int userId);
}
