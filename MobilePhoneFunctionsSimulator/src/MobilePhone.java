import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> phoneContacts;

    public MobilePhone() {
        this.phoneContacts = new ArrayList<>();
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    private ArrayList<Contact> searchContactPvt(int option, String value) {

        ArrayList<Contact> searchResult = new ArrayList<>();

        switch (option) {
            case ConstantValues.TOKEN_NAME:
                for (Contact element : phoneContacts)
                    if (value.toLowerCase().equals(element.getContactName().toLowerCase()))
                        searchResult.add(element);
                break;

            case ConstantValues.TOKEN_PHONE_NUMBER:
                for (Contact element : phoneContacts)
                    if (value.equals(element.getContactPhoneNumber()))
                        searchResult.add(element);
        }

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            return null;
        }
    }

    public void searchContact(int option, String value) {
        ArrayList<Contact> searchResult = searchContactPvt(option, value);
        printContacts(searchResult);
    }


    private int searchContactPvt(Contact contact) {

        if (phoneContacts.contains(contact)) {
            return phoneContacts.indexOf(contact);
        } else
            return -1;
    }

    public boolean searchContact(Contact contact) {
        int index = searchContactPvt(contact);

        ArrayList<Contact> tempList = new ArrayList<>();
        boolean flag;
        if (index >= 0) {
            tempList.add(phoneContacts.get(index));
            flag = true;
        } else {
            tempList = null;
            flag = false;
        }
        printContacts(tempList);
        return flag;
    }

    private boolean addContactPvt(Contact contact) {

        if (searchContactPvt(contact) == -1) {
            phoneContacts.add(contact);
            return true;
        } else
            return false;
    }

    public boolean addContact(Contact contact) {
        boolean wasAdded = addContactPvt(contact);
        addContactMessage(wasAdded);
        return wasAdded;
    }

    private int modifyContactPvt(Contact oldContact, Contact newContact) {

        if (newContact.getContactName().equals(""))
            newContact.setContactName(oldContact.getContactName());
        else if (newContact.getContactPhoneNumber().equals(""))
            newContact.setContactPhoneNumber(oldContact.getContactPhoneNumber());

        int index;
        if (searchContact(newContact))
            return -2;
        if ((index = searchContactPvt(oldContact)) >= 0) {
            phoneContacts.set(index, newContact);
            return index;
        }
        return -1;
    }

    public void modifyContact(Contact oldContact, Contact newContact) {
        int index = modifyContactPvt(oldContact, newContact);
        modifyContactMessage(index);
    }

    public ArrayList<Contact> deleteContact(int token, String value) {

        ArrayList<Contact> searchResult = searchContactPvt(token, value);

        if (searchResult != null) {
            printContacts(searchResult);
            if (searchResult.size() == 1) {
                phoneContacts.remove(searchResult.get(0));
                deleteContactMessage(1);
                searchResult = null;
            }
        } else
            printContacts(null);

        return searchResult;
    }

    public void deleteContact(ArrayList<Contact> contact) {
        int count = 0;
        for (Contact element : contact) {
            phoneContacts.remove(element);
            count++;
        }
        deleteContactMessage(count);
    }

    public void deleteContact(Contact contact) {
        int count = 0;

        if (searchContactPvt(contact) >= 0) {
            phoneContacts.remove(contact);
            count++;
        }
        deleteContactMessage(count);
    }

    public void printContacts() {
        printContacts(phoneContacts);
    }

    private void printContacts(ArrayList<Contact> contactArrayList) {
        int index = 1;
        if (contactArrayList != null) {
            System.out.println("Contact List:");
            System.out.println("------------");
            for (Contact element : contactArrayList)
                System.out.println(index++ + ". Name: " + element.getContactName() + "\n" +
                        "Phone Number: " + element.getContactPhoneNumber() + "\n");
            System.out.println("Found " + contactArrayList.size() + " contact(s). ");
        } else
            System.out.println("Found no contacts.");
    }

    private void addContactMessage(boolean wasAdded) {
        if (wasAdded)
            System.out.println("Contact successfully added. " +
                    "Number of contacts is " + phoneContacts.size());
        else
            System.out.println("Contact could not be added. Contact already exists.");
    }

    private void modifyContactMessage(int index) {
        if (index >= 0) {
            System.out.println("Successfully modified the contact. New Contact information is: ");
            System.out.println("Name: " + phoneContacts.get(index).getContactName() + "\n" +
                    "Phone Number: " + phoneContacts.get(index).getContactPhoneNumber());
        } else if (index == -1) {
            System.out.println("Contact could not be modified. Contact does not exist.");
        } else if (index == -2) {
            System.out.println("Contact could not be modified.");
        }
    }

    private void deleteContactMessage(int count) {

        if (count > 0) {
            System.out.println("Found and deleted " + count + " contact(s).");
        } else
            System.out.println("Found no contacts to delete.");

    }
}





