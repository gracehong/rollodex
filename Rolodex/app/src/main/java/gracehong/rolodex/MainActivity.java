package gracehong.rolodex;

import gracehong.rolodex.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> myContacts;
    private String dataLocation = "https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContacts = pullData();

        RecyclerView contactContainer = findViewById(R.id.contact_list_container);

        //Make a layout manager to give all cards a horizontal layout
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        contactContainer.setLayoutManager(horizontalLayoutManager);

        //Create a custom adapter so that the array of Contacts are all packaged into the custom contact layout
        ContactArrayAdapter adapter = new ContactArrayAdapter(myContacts);
        contactContainer.setAdapter(adapter);
    }


    /**
     * Helper function that parses JSON data into an array of Contacts
     */
    private ArrayList<Contact> pullData() {
        ArrayList<Contact> data = new ArrayList<>();

        data.add(new Contact("Dummy", "DumDum", "fakedata@gmail.com", "Fakenews", "11/12312/asd", "Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis *augue* scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna *a* neque. Nullam ut nisi a odio semper cursus. Integer mollis. *Integer* tincidunt aliquam arcu. Aliquam ultrices iaculis odio. *Nam* interdum enim non nisi. Aenean eget", "myImageUrl.url"));
        // TODO: implement me!
        return data;
    }
}
