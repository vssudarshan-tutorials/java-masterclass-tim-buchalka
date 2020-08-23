public abstract class MyAbstractItem {

    private final Object value;
    private MyAbstractItem previousItem;
    private MyAbstractItem nextItem;


    public MyAbstractItem(Object value) {
        this.value = value;
    }


    public Object getValue() {
        return value;
    }

    public MyAbstractItem getPreviousItem() {
        return previousItem;
    }

    public MyAbstractItem getNextItem() {
        return nextItem;
    }

    protected void setPreviousItem(MyAbstractItem previousItem) {
        this.previousItem = previousItem;
    }

    protected void setNextItem(MyAbstractItem nextItem) {
        this.nextItem = nextItem;
    }


    public abstract int compareTo(MyAbstractItem myAbstractItem);


}
