import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private final String teamName;
    private final ArrayList<T> members;
    private int teamScore;


    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }


    public String getTeamName() {
        return teamName;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    public void addMember(T member) {
        if (!members.contains(member))
            members.add(member);
        else
            System.out.println(member.getName() + " is already in " + teamName + "'s roster.");
    }

    @Override
    public int compareTo(Team<T> team) {

        if (this.teamScore == team.getTeamScore())
            return 0;

        return this.teamScore > team.getTeamScore() ? -1 : 1;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Team) {
            Team<T> team = (Team<T>) obj;

            return this.teamName.toLowerCase().equals(team.getTeamName().toLowerCase());

        }
        return false;
    }


}
