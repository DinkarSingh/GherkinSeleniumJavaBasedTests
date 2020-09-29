package Steps;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class PersonalInfo  {
    public Fairy fairy = Fairy.create();
    public Person person = fairy.person();

    protected String  getFirstName(){
        return person.getFirstName();
    }

    protected String  getLastName(){
        return person.getLastName();
    }

    protected String  getEmail(){
        return person.getCompanyEmail();
    }

}
