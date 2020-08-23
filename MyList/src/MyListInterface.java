public interface MyListInterface {

    int getSize();
    int getIndex();

    boolean isValidItem(MyAbstractItem myAbstractItem);

    MyAbstractItem getFirstEntry();
    MyAbstractItem getPreviousListEntry();
    MyAbstractItem getNextListEntry();

    boolean add(MyAbstractItem myAbstractItem);
    boolean add(int index, MyAbstractItem myAbstractItem);

    boolean remove(MyAbstractItem myAbstractItem);
    boolean remove(int index);

    MyAbstractItem getListEntry(int index);
    int search(MyAbstractItem myAbstractItem);

    void sort();
    void traverse();

}
