public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature){

        if(temperature >= 25)
            if(temperature <= 35)
                return true;
            else if(temperature <= 45 && summer)
                return true;

         return false;

    }

    public static void main(String[] args) {

        printState(isCatPlaying(true, 20));
        printState(isCatPlaying(true, 30));
        printState(isCatPlaying(true, 44));
        printState(isCatPlaying(false, 20));
        printState(isCatPlaying(false, 31));
        printState(isCatPlaying(false, 46));

    }
   public static void printState(boolean state){

       if (state)
        System.out.println("Cat is playing");
       else
           System.out.println("Cat is not playing");
    }

}
