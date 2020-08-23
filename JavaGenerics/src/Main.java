public class Main {


    public static void main(String[] args) {

        DotaPlayer sumail = new DotaPlayer("Sumail", "carry", 100000, 4);
        DotaPlayer puppey = new DotaPlayer("Puppey", "mid", 150000, 6);

        FootballPlayer theiryHenry = new FootballPlayer("Theiry Henry", "mid field", 500000, 12);
        FootballPlayer beckham = new FootballPlayer("David Beckham", "striker", 800000, 15);

        Team<DotaPlayer> t3 = new Team<>("T3");
        Team<DotaPlayer> msi = new Team<>("MSI");

        Team<FootballPlayer> arsenal = new Team<>("Arsenal");
        Team<FootballPlayer> manUtd = new Team<>("Manchester United");

        League<DotaPlayer> dotaWorldLeague = new League<>("DOTA World League");
        League<FootballPlayer> englishPremierLeague = new League<>("English Premier League");

        /*

                      Another way is to use raw parameterised Team

                    public class League<T extends Team>{
                    LinkedList<T> teams;

                    }
        League<Team<DotaPlayer>> dotaWorldLeague = new League<>("DOTA World League");
        League<Team<FootballPlayer>> englishPremierLeague = new League<>("English Premier League");

*/

        t3.addMember(sumail);
        t3.setTeamScore(100);
        dotaWorldLeague.addTeam(t3);

        msi.addMember(puppey);
        msi.setTeamScore(200);
        dotaWorldLeague.addTeam(msi);

        t3.addMember(new DotaPlayer("SumAil", "cArRy", 170000, 6));
        dotaWorldLeague.addTeam(new Team<DotaPlayer>("t3"));


        dotaWorldLeague.showTeams();

        arsenal.addMember(theiryHenry);
        arsenal.setTeamScore(300);
        englishPremierLeague.addTeam(arsenal);

        manUtd.addMember(beckham);
        manUtd.setTeamScore(400);
        englishPremierLeague.addTeam(manUtd);

        englishPremierLeague.showTeams();

    }
}
