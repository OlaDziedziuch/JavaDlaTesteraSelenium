package Model;

import Enums.DayOfBirth;
import Enums.MonthOfBirth;
import Enums.Title;
import Enums.YearOfBirth;
import lombok.Data;

@Data

public class PersonalInformation {


    private Title title;
    private String firstName;
    private String lastName;
    private String password;
    private DayOfBirth day;
    private MonthOfBirth month;
    private YearOfBirth year;

    /*public void setPassword(String password) {
        if (password.length() > 5) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must contain at least 5 characters");
        }
    }*/
}

    //private SignUpForNewsletterBox signUpForNewsletterBox;
    //private ReceiveSpecialOffersBox receiveSpecialOffersBox;


