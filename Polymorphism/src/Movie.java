public class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot() {
        return "No plot here!";
    }


}

class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }
@Override
    public String plot(){
        return "Shark eats people!";
    }
}


class   StarWars extends Movie{

    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Rebel forces thwart the Empire's attempt at hegemony over the universe.";
    }
}

class Forgettable extends Movie{

    public Forgettable(){
        super("Forgettable");
    }

    //no plot method
}

