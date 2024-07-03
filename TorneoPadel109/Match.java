package TorneoPadel109;

/**
 * Partido
 */
public class Match {
    private String homeTeam;
    private int homeSets;
    private String visitantTeam;
    private int visitantSets;

    public Match() {
        homeTeam = "";
        homeSets = 0;
        visitantTeam = "";
        visitantSets = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeSets() {
        return homeSets;
    }

    public void setHomeSets(int homeSets) {
        this.homeSets = homeSets;
    }

    public String getVisitantTeam() {
        return visitantTeam;
    }

    public void setVisitantTeam(String visitantTeam) {
        this.visitantTeam = visitantTeam;
    }

    public int getVisitantSets() {
        return visitantSets;
    }

    public void setVisitantSets(int visitantSets) {
        this.visitantSets = visitantSets;
    }

}
