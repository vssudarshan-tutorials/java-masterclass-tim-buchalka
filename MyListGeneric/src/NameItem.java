public class NameItem extends MyListItem{


    public NameItem(String  value) {
        super(value);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public <T extends MyListItem> int compareTo(T myListItem) {
        if(myListItem instanceof  NameItem)
      return  compareToNameItem((NameItem) myListItem);

        return -2;
    }

    public int compareToNameItem(NameItem nameItem) {
        if (nameItem != null) {

                int result = this.getValue().toString().toLowerCase().compareTo(nameItem.getValue().toString().toLowerCase());

                if (result == 0)
                    return 0;

                return (result > 0 ? 1 : -1);
            }
        return -2;
    }
}