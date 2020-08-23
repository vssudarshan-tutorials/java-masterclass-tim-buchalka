public class Animal {

    private String name;
    private int brain;
    private int weight;

    public Animal(String name, int brain, int weight){

        this.name = name;
        this.brain = brain;
        this.weight = weight;
    }

    protected void a(){

    }
    public Animal(){

    }

    public void eat(){
        System.out.println("Animal is eating...");

    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getWeight() {
        return weight;
    }
}
