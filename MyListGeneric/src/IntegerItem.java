public class IntegerItem extends MyListItem {

    public IntegerItem(int value) {
        super(value);
    }


    @Override
    public <T extends MyListItem> int compareTo(T myListItem) {

        if (myListItem instanceof IntegerItem)
            return compareToIntegerItem((IntegerItem) myListItem);

        return -2;
    }

    public int compareToIntegerItem(IntegerItem integerItem) {
        if (integerItem != null) {

            if (((Integer) this.getValue()).equals((Integer) integerItem.getValue()))
                return 0;

            return (Integer) this.getValue() > (Integer) integerItem.getValue() ? 1 : -1;
        }
        return -2;
    }
}



