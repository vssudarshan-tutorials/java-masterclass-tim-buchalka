import org.jetbrains.annotations.NotNull;

public class Search {

    public static int retrieveAdditionsInfo(int additionCode, @NotNull int[] additionsCodeList) {

        int limit = additionsCodeList.length - 1;
        int index = 0;
//binary search algorithm
        for (; index <= limit; ) {
            if (additionCode == additionsCodeList[(index + limit) / 2])
                return (index + limit) / 2;
            else if (additionCode < additionsCodeList[(index + limit) / 2]) {
                limit = (index + limit) / 2 - 1;
            } else
                index = (index + limit) / 2 + 1;
        }


        return -1;


    }

    public static boolean isValidCode(int code, int[] codeList) {

        int limit = codeList.length - 1;
        int start = 0;
        int index;

        for (; start <= limit; ) {
            index = (start + limit) / 2;
            if (code == codeList[index])
                return true;
            else if (code < codeList[index]) {
                limit = index - 1; //limit /2
            } else
                start = index + 1; //(start + limit) /2
        }
        return false;
    }

}

