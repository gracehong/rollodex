package gracehong.rolodex;

/**
 * Created by Grace on 12/20/2017.
 */

public class Contact {
    private String lastName;
    private String firstName;
    private String email;
    private String company;
    private String startDate; //TODO: see if this can be loaded into a time type?
    private String bio; //TODO: see if there's a type to interpret markdown?
    private String picURL;

    public Contact(String lastName, String firstName, String email, String company, String startDate, String bio, String picURL) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.company = company;
        this.startDate = startDate;
        this.bio = bio;
        this.picURL = picURL;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getBio() {
        return bio;
    }

    public String getPicURL() {
        return picURL;
    }
}
