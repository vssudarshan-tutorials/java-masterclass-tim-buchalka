public class Main {

public static void main(String[] args){

    VipCustomer customer = new VipCustomer();
    System.out.println("Name: " + customer.getCustName() + " Email: " + customer.getCustEmail() +
                        " Credit Limit: " + customer.getCreditLimit());

    VipCustomer customer1 = new VipCustomer("Sud", "sud@mail.com");
    System.out.println("Name: " + customer1.getCustName() + " Email: " + customer1.getCustEmail() +
            " Credit Limit: " + customer1.getCreditLimit());

    VipCustomer customer2 = new VipCustomer("Sam", "sam@sam.com", 9000.00);
    System.out.println("Name: " + customer2.getCustName() + " Email: " + customer2.getCustEmail() +
            " Credit Limit: " + customer2.getCreditLimit());



}



}
