package JavaFX;

/**
 * SpreadSheet for TableView at BoxControl_Items -> GUI00
 */
public class SpreadSheet {
    private int id;
    private String FirstName;
    private String LastName;
    private int age;
    private double score;

    public SpreadSheet () {
        this.id = -1;
        this.FirstName = "";
        this.LastName = "";
        this.age = -1;
        this.score = 0.0;
    }

    public SpreadSheet (int id, String FirstName, String LastName, int age, double score) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.age = age;
        this.score = score;
    }
    public int getId (){
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public String getFirstName(){
        return FirstName;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        this.score = score;
    }
}
