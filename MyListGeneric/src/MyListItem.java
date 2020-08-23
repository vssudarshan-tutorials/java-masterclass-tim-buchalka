public abstract class MyListItem {

    Object value;
    MyListItem previousItem;
    MyListItem nextItem;

    public MyListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public <T extends MyListItem> T getPreviousItem(T head) {

        if (head.getClass().getName().equals(previousItem.getClass().getName()))
            return (T) previousItem;

        return null;
    }

    protected <T extends MyListItem> void setPreviousItem(T previousItem, T head) {

        this.previousItem = previousItem;
    }

    public <T extends MyListItem> T getNextItem(T head) {

        if (head.getClass().getName().equals(previousItem.getClass().getName()))
            return (T) nextItem;

        return null;
    }

    protected <T extends MyListItem> void setNextItem(T nextItem, T head) {
        if (isValidItem(head))
            this.nextItem = nextItem;

    }

    public <T extends MyListItem> boolean isValidItem(T head) {
        return head.getClass().getName().equals(previousItem.getClass().getName());
    }

    public abstract <T extends MyListItem> int compareTo(T myListItem);
}