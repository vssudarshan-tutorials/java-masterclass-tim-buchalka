public class SecondsAndMinutes {

    public static String getDurationString(long min, long sec){

        if(min < 0 || sec < 0 || sec > 59)
            return "Invalid Parameters";

        long partH = min / 60;
        long partM = min % 60;

        return  (partH < 10 ? "0" + partH : partH) + "h " +
                (partM < 10 ? "0" + partM : partM) +  "m " +
                (sec < 10 ? "0" + sec : sec) + "s";

    }

    public static String getDurationString(long sec){

        if(sec < 0)
            return "Invalid Parameters";

        return getDurationString(sec / 60, sec % 60);
    }

    public static void main(String[] args) {
        System.out.println(getDurationString(600,59));
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945));

    }

}
