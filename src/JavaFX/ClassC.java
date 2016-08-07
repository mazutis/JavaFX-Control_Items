package JavaFX;

/**
 * Created by ernes on 09/07/2016.
 */
public class ClassC {
    private int Number;

    //Conctructor
    public ClassC (int x){
        Number = x;
        }


    public void setNumber (int x) {
        Number = x;
        System.out.println ("Number has been stored in system ");
        }

    public int getNumber() {
        return Number;
        }
}

