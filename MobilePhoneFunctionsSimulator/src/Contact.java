public class Contact {

    private String contactName;
    private String contactPhoneNumber;

    public Contact(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public boolean equals(Object o){

        if(!(o instanceof Contact)){
            return false;
        }else{
            Contact contactObject = (Contact) o;
            return contactObject.contactPhoneNumber.equals(this.contactPhoneNumber) && contactObject.contactName.toLowerCase().equals(this.contactName.toLowerCase());
    }

}

}
