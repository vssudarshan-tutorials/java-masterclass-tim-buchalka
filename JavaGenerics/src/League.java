import java.util.Collections;
import java.util.LinkedList;

public class League<T extends Player> {

    private String name;
    private final LinkedList<Team<T>> teams;

    public League(String name) {
        this.name = name;
        this.teams = new LinkedList<>();
    }

    public LinkedList<Team<T>> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(Team<T> team) {
        if (!teams.contains(team))
            teams.add(team);
        else
            System.out.println(team.getTeamName() + " is already in league " + name + ".");

        return true;
    }


    public void showTeams() {
        System.out.println("-------------------------------------\n" + name + " Ranking Table\n-------------------------------------");
        Collections.sort(this.teams);
        for (Team<T> team : teams) {
            System.out.println("Name: " + team.getTeamName() + " Score: " + team.getTeamScore());
            System.out.println("Player Roster");
            int i = 0;
            for (T player : team.getMembers()) {
                System.out.println(++i + ". Name: " + player.getName() + " Position: " + player.getPosition());
            }
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------");
    }
}
