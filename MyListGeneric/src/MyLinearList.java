public class MyLinearList<T extends MyListItem> {

    private T head;
    private T previousEntry;
    private T nextEntry;
    private int position;
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

    public boolean isValidItem(T myListItem) {
        return myListItem.getValue().getClass().getName().equals(this.previousEntry.getValue().getClass().getName());
    }

    public T getFirstEntry() {
        return head;
    }

    public T getPreviousListEntry() {

        if (head != null) {
            if (position == 1) {
                return previousEntry;
            } else {
                nextEntry = previousEntry;
                previousEntry = previousEntry.getPreviousItem(head);
                position--;
            }
        }
        return nextEntry;
    }


    public T getNextListEntry() {

        if (head != null) {
            if (position == size) {
                return nextEntry;
            } else {
                previousEntry = nextEntry;
                nextEntry = nextEntry.getNextItem(head);
                position++;
            }
        }
        return previousEntry;
    }


    private boolean addPvt(T myAbstractItem) {

        if (((size == 0) || isValidItem(myAbstractItem)) && (search(myAbstractItem) == -1)) {
            if (head == null) {
                head = myAbstractItem;
                previousEntry = head;
            } else {
                previousEntry = getListEntry(size - 1);
                nextEntry = null;
                previousEntry.setNextItem(myAbstractItem, head);
                myAbstractItem.setPreviousItem(previousEntry, head);
                previousEntry = myAbstractItem;
            }
            size++;
            position = size;
            //     System.out.print("Add position: " + position);
            return true;
        }
        return false;

    }

    public boolean add(T myAbstractItem) {

        if (getSize() != 0) {
            if (search(myAbstractItem) != -1)
                return false;
            int result;
            T listEntry = head;

            for (int i = 0; listEntry != null; i++) {
                result = listEntry.compareTo(myAbstractItem);
                if (result == 0)
                    return false;
                else if (result == 1)
                    return add(i, myAbstractItem);
                else
                    listEntry = listEntry.getNextItem(head);
            }
        }
        return addPvt(myAbstractItem);
    }


    public boolean add(int index, T myListItem) {

        if (index <= size && search(myListItem) == -1) {
            if ((size == 0) || isValidItem(myListItem)) {

                if (index == size) {
                    previousEntry = getListEntry(index - 1);
                    previousEntry.setNextItem(myListItem, head);
                    myListItem.setPreviousItem(previousEntry, head);
                    position++;
                } else {
                    nextEntry = getListEntry(index);

                    if (nextEntry != head) {
                        nextEntry.getPreviousItem(head).setNextItem(myListItem, head);
                        myListItem.setPreviousItem(nextEntry.getPreviousItem(head), head);
                    } else {
                        head = myListItem;
                    }
                    myListItem.setNextItem(nextEntry, head);
                    nextEntry.setPreviousItem(myListItem, head);
                }
                previousEntry = myListItem;
            }
            size++;

            return true;
        }
        return false;
    }

    public boolean remove(int index) {

        if (index < size) {

            T myListItem = getListEntry(index);

            if (myListItem != head) {
                previousEntry = myListItem.getPreviousItem(head);
                nextEntry = myListItem.getNextItem(head);
                previousEntry.setNextItem(nextEntry, head);
                if (nextEntry != null)
                    nextEntry.setPreviousItem(previousEntry, head);
            } else {
                head = myListItem.getNextItem(head);
                previousEntry = head;

                if (nextEntry != null)
                    nextEntry = head.getNextItem(head);

                if (head != null)
                    head.setPreviousItem(null, head);
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

    public boolean remove(T myAbstractItem) {

        if (getSize() != 0) {
            int result;
            T listEntry = head;

            for (int i = 0; listEntry != null; i++) {

                result = listEntry.compareTo(myAbstractItem);

                if (result == 0)
                    return remove(i);
                else if (result == -1)
                    listEntry = listEntry.getNextItem(head);
                else if (result == 1)
                    break;
            }
        }
        return false;
    }

    public T getListEntry(int index) {
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
                nextEntry = previousEntry.getNextItem(head);
        }
        return previousEntry;
    }

    private T getRecursiveItem(T myAbstractItem, int recursionValue, int direction) {

        if (recursionValue == 0)
            return myAbstractItem;

        if (direction == -1)
            position--;
        else if (direction == 1)
            position++;

        if (direction == -1) {
            return getRecursiveItem(myAbstractItem.getPreviousItem(head), recursionValue - 1, -1);
        } else
            return getRecursiveItem(myAbstractItem.getNextItem(head), recursionValue - 1, 1);
    }

    public int search(T myAbstractItem) {

        T listEntry = head;

        for (position = 1; listEntry != null; position++) {

            previousEntry = listEntry;
            nextEntry = listEntry.getNextItem(head);
            int result = listEntry.compareTo(myAbstractItem);
            if (result == 0)
                return getIndex();
            else if (result == -1)
                listEntry = listEntry.getNextItem(head);
            else
                return -1;
        }
        position--;
        return -1;
    }


    public void sort() {

        if (getSize() == 0)
            return;

        boolean swapped;
        do {
            swapped = false;
            T firstItem = head;
            T secondItem = head.getNextItem(head);
            position = 1;
            while (secondItem != null) {
                if (firstItem.compareTo(secondItem) == 1) {
                    swapped = true;
                    if (firstItem.getPreviousItem(head) != null) {
                        firstItem.getPreviousItem(head).setNextItem(secondItem, head);
                        secondItem.setPreviousItem(firstItem.getPreviousItem(head), head);
                    } else {
                        secondItem.setPreviousItem(null, head);
                        head = secondItem;
                    }

                    if (secondItem.getNextItem(head) != null) {
                        firstItem.setNextItem(secondItem.getNextItem(head), head);

                        secondItem.getNextItem(head).setPreviousItem(firstItem, head);
                    } else {
                        firstItem.setNextItem(null, head);
                    }
                    secondItem.setNextItem(firstItem, head);
                    firstItem.setPreviousItem(secondItem, head);

                } else
                    firstItem = secondItem;

                previousEntry = firstItem;
                nextEntry = secondItem = firstItem.getNextItem(head);
                position++;
            }
        } while (swapped);
    }

    public void traverse() {

        if (head != null) {
            T myListItem = head;
            previousEntry = head;
            nextEntry = head.getNextItem(head);
            position = 1;
            System.out.println("List Items:");
            while (myListItem != null) {
                System.out.println(myListItem.getValue());
                myListItem = getNextListEntry();
            }
        }
    }

    public void showList() {

        T myListItem = head;
        System.out.println("List Items:");
        while (myListItem != null) {

            System.out.println(myListItem.getValue());

            myListItem = myListItem.getNextItem(head);
        }
    }
}
