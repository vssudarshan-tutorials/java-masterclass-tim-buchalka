public class GreatestCommonDivisor {

  public static int getGreatestCommonDivisor(int first, int second) {

        if(first < 10 || second < 10)
            return -1;

        int gcd = 1;

        for(int i = 1; i <= Math.min(first,second); i++)
            if(first % i == 0 && second % i == 0)
                gcd = i;

        return gcd;
    }

    public static void main(String[] args) {

        System.out.println(getGreatestCommonDivisor(24,12));

//            int[] a = {1,2,3,4,5,6,-1,8,9,0};
//
//        int n = 10, i = 0;
//        for(int j = 1; j < n; j++)
//            if(a[i] > a[j])
//                i=j;
//
//        System.out.println(a[i]);
    }


}
