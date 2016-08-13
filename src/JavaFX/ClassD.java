package JavaFX;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ernes on 13/08/2016.
 */
//Contected to Content_Properties Class
public class ClassD {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns string property Object
    public StringProperty firstNameProperty () {
        return firstName;
    }

    //returns firstname (i.e. "FirstName")
    public String getFirstName () {
        return firstName.get();
    }

    //Set firstName
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

}
