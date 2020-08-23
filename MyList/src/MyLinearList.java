public abstract class MyLinearList implements MyListInterface{

    protected MyAbstractItem head;
    protected MyAbstractItem previousEntry;
    protected MyAbstractItem nextEntry;
    protected int position;
    private int size;

    public MyLinearList() {
        this.size = 0;
        this.position = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return position - 1;
    }

    public boolean isValidItem(MyAbstractItem myAbstractItem) {
        return myAbstractItem.getValue().getClass().getName().equals(this.previousEntry.getValue().getClass().getName());
    }

    public MyAbstractItem getFirstEntry() {
        return head;
    }

    public MyAbstractItem getPreviousListEntry() {

        if (head != null) {
            if (position == 1) {
                return previousEntry;
            } else {
                nextEntry = previousEntry;
                previousEntry = previousEntry.getPreviousItem();
                position--;
            }
        }
        return nextEntry;
    }


    public MyAbstractItem getNextListEntry() {

        if (head != null) {
            if (position == size) {
                return nextEntry;
            } else {
                previousEntry = nextEntry;
                nextEntry = nextEntry.getNextItem();
                position++;
            }
        }
        return previousEntry;
    }


    public boolean add(MyAbstractItem myAbstractItem) {

        if (((size == 0) || isValidItem(myAbstractItem)) && (search(myAbstractItem) == -1)) {
            if (head == null) {
                head = myAbstractItem;
                previousEntry = head;
            } else {
                previousEntry = getListEntry(size - 1);
                nextEntry = null;
                previousEntry.setNextItem(myAbstractItem);
                myAbstractItem.setPreviousItem(previousEntry);
                previousEntry = myAbstractItem;
            }
            size++;
            position = size;
            //     System.out.print("Add position: " + position);
            return true;
        }
        return false;

    }

    public boolean add(int index, MyAbstractItem myAbstractItem) {

        if (index <= size && search(myAbstractItem) == -1) {
            if ((size == 0) || isValidItem(myAbstractItem)) {

                if (index == size) {
                    previousEntry = getListEntry(index - 1);
                    previousEntry.setNextItem(myAbstractItem);
                    myAbstractItem.setPreviousItem(previousEntry);
                    position++;
                } else {
                    nextEntry = getListEntry(index);

                    if (nextEntry != head) {
                        nextEntry.getPreviousItem().setNextItem(myAbstractItem);
                        myAbstractItem.setPreviousItem(nextEntry.getPreviousItem());
                    } else {
                        head = myAbstractItem;
                    }
                    myAbstractItem.setNextItem(nextEntry);
                    nextEntry.setPreviousItem(myAbstractItem);
                }
                previousEntry = myAbstractItem;
            }
            size++;

            //     System.out.print("Add position: " + position);
            return true;
        }
        return false;
    }

    public abstract boolean remove(MyAbstractItem myAbstractItem);

    public boolean remove(int index) {

        if (index < size) {

            MyAbstractItem myAbstractItem = getListEntry(index);

            if (myAbstractItem != head) {
                previousEntry = myAbstractItem.getPreviousItem();
                nextEntry = myAbstractItem.getNextItem();
                previousEntry.setNextItem(nextEntry);
                if (nextEntry != null)
                    nextEntry.setPreviousItem(previousEntry);
            } else {
                head = myAbstractItem.getNextItem();
                previousEntry = head;

                if (nextEntry != null)
                    nextEntry = head.getNextItem();

                if (head != null)
                    head.setPreviousItem(null);
            }
            size--;
            position--;

            if (size != 0 && position == 0)
                position = 1;

            //     System.out.println("\nRemove Position: " + position);
            return true;
        }
        return false;
    }

    public MyAbstractItem getListEntry(int index) {
        if (size != 0) {
            if (position - 1 == index) {
                previousEntry = getRecursiveItem(previousEntry, 0, 0);
            } else if (position > index) {
                previousEntry = getRecursiveItem(previousEntry, position - 1 - index, -1);
            } else {
                previousEntry = getRecursiveItem(previousEntry, index + 1 - position, 1);
            }
            if (index == size)
                nextEntry = null;
            else
                nextEntry = previousEntry.getNextItem();
        }
        return previousEntry;
    }

    private MyAbstractItem getRecursiveItem(MyAbstractItem myAbstractItem, int recursionValue, int direction) {

        if (recursionValue == 0)
            return myAbstractItem;

        if (direction == -1)
            position--;
        else if (direction == 1)
            position++;

        if (direction == -1) {
            return getRecursiveItem(myAbstractItem.getPreviousItem(), recursionValue - 1, -1);
        } else
            return getRecursiveItem(myAbstractItem.getNextItem(), recursionValue - 1, 1);
    }

    public int search(MyAbstractItem myAbstractItem) {

        MyAbstractItem listItem = head;

        for (int i = 0; listItem != null; i++)
            if (listItem == myAbstractItem)
                return i;
            else
                listItem = listItem.getNextItem();

        return -1;
    }

    public abstract void sort();

    public void traverse() {

        if (head != null) {
            MyAbstractItem myAbstractItem = head;
            previousEntry = head;
            nextEntry = head.getNextItem();
            position = 1;
            System.out.println("List Items:");
            while (myAbstractItem != null) {
                System.out.println(myAbstractItem.getValue());
                myAbstractItem = getNextListEntry();
            }
        }
    }
}
