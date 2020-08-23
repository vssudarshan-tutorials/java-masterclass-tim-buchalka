public class Car {

private int doors, wheels;
private String model, engine, colour;

public void setModel(String model){
if (model.toLowerCase().equals("carrera") || model.toLowerCase().equals("commodore"))
    this.model = model;
else
    this.model = "Unkown";

}

public String getModel(){
    return this.model;
}

}
