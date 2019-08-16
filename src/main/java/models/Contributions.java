package models;

public class Contributions {
    private int id;
    private String code;
    private String description;
    private int challengeId;
    private int vote;

    public Contributions(String code, String description, int challengeId, int vote) {
        this.code = code;
        this.description = description;
        this.challengeId = challengeId;
        this.vote = vote;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
