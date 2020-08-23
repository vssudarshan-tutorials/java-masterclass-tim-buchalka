public class VipCustomer {

String custName, custEmail;
double creditLimit;

public VipCustomer(){
    this("Ravi", "Ravi@ravi.com", 10000.00);
}

public VipCustomer(String custName, String custEmail){

    this(custName, custEmail, 10000.00);
}

public VipCustomer(String custName, String custEmail, double creditLimit){
    this.custName = custName;
    this.custEmail = custEmail;
    this.creditLimit = creditLimit;
}

    public String getCustName() {
        return custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
