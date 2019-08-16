package dao;

import models.Contributions;

import java.util.List;

public interface ContributionsDao {
    void add(Contributions contributions);
    Contributions findById(int contributionsId);
    List<Contributions> getAll();
    List<Contributions> getAllContributionsByChallenge(int challengeId);
}
