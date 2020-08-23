public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie Number " + i + ": "+ movie.getName() +
                                   "\nPlot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
       int selection = (int) (Math.random() * 3) + 1;
        System.out.println("Random number generated: "+ selection);
       switch(selection){
           case 1:
               return new Jaws();
           case 2:
               return new StarWars();
           case 3:
               return new Forgettable();
       }
       return null;
    }
}
