public class FlourPacker {

    private static final int BIG_SIZE = 5;
    private static final int SMALL_SIZE = 1;

    public static boolean canPack(int bigCount, int smallCount, int goal){

        if(bigCount < 0 || smallCount < 0 || goal < 0)
            return false;


        for(int i = 0; i <= bigCount; i++)
            for(int j = 0; j <= smallCount; j++)
                if(i * BIG_SIZE + j *SMALL_SIZE == goal)
                    return true;


        return false;




    }

    public static void main(String[] args) {
        System.out.println(canPack(0,9,9));
    }


}
