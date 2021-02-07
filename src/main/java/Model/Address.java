package Model;

import Enums.Country;
import Enums.State;
import lombok.Data;

@Data
public class Address {

    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private State state;
    private String postalCode;
    private Country country;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String assignAnAddressAliasForFutureReference;



}
