public class Main {

    public static void main(String[] args) {

        MyLinearList<NameItem> nameList = new MyLinearList<>();
        NameItem nameItem1 = new NameItem("Sud");
        NameItem nameItem2 = new NameItem("Sul");
        NameItem nameItem3 = new NameItem("Sam");
        NameItem nameItem4 = new NameItem("Asha");
        NameItem nameItem5 = new NameItem("Pops");

        IntegerItem integerItem1 = new IntegerItem(1);

      //  nameList.add(integerItem1);

        nameList.traverse();
        System.out.println(nameList.getPreviousListEntry());
        System.out.println(nameList.getNextListEntry());
        System.out.println(nameList.search(nameItem1));
        System.out.println(nameList.remove(nameItem2));
        System.out.println(nameList.remove(0));

        nameList.sort();
        System.out.println(nameList.getListEntry(0));

        nameList.add(nameItem1);
  //      nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");


        nameList.add(nameItem2);
    //    nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");


        nameList.add(nameItem3);
      //  nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");

        nameList.add(nameItem4);
        //nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");

        nameList.add(nameItem5);
        //nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");

        nameList.add(0, new NameItem("Laura"));
        //nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");

        nameList.add(3, new NameItem("Luke"));
        //nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry() + "\n");


        nameList.add(7, new NameItem("aaa"));
        //nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry());

        nameList.sort();
   //     nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry());

        nameList.remove(1);
     //   nameList.traverse();
        nameList.showList();
        System.out.println("\nIndex: " + nameList.getIndex());
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry());

       nameList.remove(new NameItem("SAM"));
       nameList.traverse();

        System.out.println(nameList.search(new NameItem("SAM")));
        System.out.println("Index: " + nameList.getIndex());
        System.out.println("Position after operation: " + (nameList.getIndex() + 1));
        System.out.println("Previous Entry: " + nameList.getPreviousListEntry());
//
//
//        for (int i = 0; i < nameList.getSize(); ) {
//            System.out.println("Size: " + nameList.getSize());
//            nameList.remove(0);
//        }
//
//        nameList.traverse();
//        System.out.println(nameList.getPreviousListEntry());
//        System.out.println(nameList.getNextListEntry());
//        System.out.println(nameList.search(nameItem1));
//        System.out.println(nameList.remove(nameItem2));
//        System.out.println(nameList.remove(0));
//        nameList.sort();
//        System.out.println(nameList.getListEntry(0));

    }
}
