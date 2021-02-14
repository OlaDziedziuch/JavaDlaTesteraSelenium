package model;

import enums.DayOfBirth;
import enums.MonthOfBirth;
import enums.Title;
import enums.YearOfBirth;
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

}




