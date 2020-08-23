public class NameList extends MyLinearList{

    public NameList() {
        super();
    }
    @Override
    public int search(MyAbstractItem myAbstractItem) {

        if (myAbstractItem instanceof NameItem) {

            MyAbstractItem listEntry = head;

            for (position = 1; listEntry != null; position++) {

                previousEntry = listEntry;
                nextEntry = listEntry.getNextItem();
                int result = listEntry.compareTo(myAbstractItem);
                if (result == 0)
                    return getIndex();
                else if (result == -1)
                    listEntry = listEntry.getNextItem();
                else
                    return -1;
            }
            position--;
        }
        return -1;
    }


    @Override
    public boolean add(MyAbstractItem myAbstractItem) {

        if (myAbstractItem instanceof NameItem) {

            if (getSize() != 0) {
                if (search(myAbstractItem) != -1)
                    return false;
                int result;
                MyAbstractItem listEntry = head;

                for (int i = 0; listEntry != null; i++) {
                    result = listEntry.compareTo(myAbstractItem);
                    if (result == 0)
                        return false;
                    else if (result == 1)
                        return add(i, myAbstractItem);
                    else
                        listEntry = listEntry.getNextItem();
                }
            }
            return super.add(myAbstractItem);
        }
        return false;
    }

    @Override
    public boolean remove(MyAbstractItem myAbstractItem) {

        if (myAbstractItem instanceof NameItem) {
            if (getSize() != 0) {
                int result;
                MyAbstractItem listEntry = head;

                for (int i = 0; listEntry != null; i++) {

                    result = listEntry.compareTo(myAbstractItem);

                    if (result == 0)
                        return remove(i);
                    else if (result == -1)
                        listEntry = listEntry.getNextItem();
                    else if (result == 1)
                        break;
                }
            }
        }
        return false;
    }

    public void sort() {

        if (getSize() == 0)
            return;

        boolean swapped;
        do {
            swapped = false;
            MyAbstractItem firstItem = head;
            MyAbstractItem secondItem = head.getNextItem();
            position = 1;
            while (secondItem != null) {
                if (firstItem.compareTo(secondItem) == 1) {
                    swapped = true;
                    if (firstItem.getPreviousItem() != null) {
                        firstItem.getPreviousItem().setNextItem(secondItem);
                        secondItem.setPreviousItem(firstItem.getPreviousItem());
                    } else {
                        secondItem.setPreviousItem(null);
                        head = secondItem;
                    }

                    if (secondItem.getNextItem() != null) {
                        firstItem.setNextItem(secondItem.getNextItem());

                        secondItem.getNextItem().setPreviousItem(firstItem);
                    } else {
                        firstItem.setNextItem(null);
                    }

                    secondItem.setNextItem(firstItem);
                    firstItem.setPreviousItem(secondItem);

                } else
                    firstItem = secondItem;

                previousEntry = firstItem;
                nextEntry = secondItem = firstItem.getNextItem();
                position++;
            }
        } while (swapped);

    }

    public void showList() {

        MyAbstractItem myAbstractItem = head;
        System.out.println("List Items:");
        while (myAbstractItem != null) {

            System.out.println(myAbstractItem.getValue());

            myAbstractItem = myAbstractItem.getNextItem();

        }

    }

}
