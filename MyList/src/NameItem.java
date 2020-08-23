public class NameItem extends MyAbstractItem {

    public NameItem(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }


    @Override
    public int compareTo(MyAbstractItem myAbstractItem) {

        if (myAbstractItem != null) {
            if (myAbstractItem instanceof NameItem) {

                int result = this.getValue().toString().toLowerCase().compareTo(myAbstractItem.getValue().toString().toLowerCase());

                if (result == 0)
                    return 0;

                return (result > 0 ? 1 : -1);
            }
        }
        return -2;
    }
}
