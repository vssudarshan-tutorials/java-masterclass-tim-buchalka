public class Player {

    private String name;
    private String position;
    private long salary;
    private int yearsPlayed;

    public Player(String name, String position, long salary, int yearsPlayed) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.yearsPlayed = yearsPlayed;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof DotaPlayer) {
            DotaPlayer player = (DotaPlayer) obj;

            return this.name.toLowerCase().equals(player.getName().toLowerCase())
                    && this.position.toLowerCase().equals(player.getPosition().toLowerCase());
        }
        return false;
    }

}
