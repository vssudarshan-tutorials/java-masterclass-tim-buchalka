public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay){

        if(barking)
        if(hourOfDay <= 23 && hourOfDay >= 0)
        if(hourOfDay > 22 || hourOfDay < 8)
            return true;

        return false;
    }
}
