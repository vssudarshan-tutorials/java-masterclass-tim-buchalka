class Additions {

    private int additionCode;
    private String name;
    private double price;
    private int quantity;

    public Additions(int additionCode, String name, double price, int quantity) {
        this.additionCode = additionCode;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Additions(int additionCode, String name, double price) {
        this(additionCode, name, price, 0);
    }

    private void addMessage() {
        System.out.println("Added " + this.name + " New quantity: " + this.quantity);
    }

    public int add(int quantity) {
        this.quantity += quantity;
        addMessage();
        return this.quantity;
    }

    public double chargeableAmount() {
        return quantity * price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAdditionCode() {
        return additionCode;
    }

    public void setAdditionCode(int additionCode) {
        this.additionCode = additionCode;
    }
}

