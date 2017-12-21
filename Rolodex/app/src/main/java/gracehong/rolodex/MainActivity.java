package gracehong.rolodex;

import gracehong.rolodex.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> myContacts;
    private String dataLocation = "https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pullData();
    }

    private void loadDataToView(){
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
    private void processData(JSONArray jsonArray) {
        ArrayList<Contact> data = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject contactInfo = jsonArray.getJSONObject(i);
                Contact contact = new Contact(
                        contactInfo.getString("lastName"),
                        contactInfo.getString("firstName"),
                        contactInfo.getString("email"),
                        contactInfo.getString("company"),
                        contactInfo.getString("startDate"),
                        contactInfo.getString("bio"),
                        contactInfo.getString("avatar")
                );
                data.add(contact);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        myContacts = data;

        loadDataToView();
    }


    private void pullData (){
        Ion.with(getApplicationContext())
                .load(dataLocation)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    public void onCompleted(Exception e,
                                            String data) {
                        // process the data or error
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(data);
                            processData(jsonArray);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }

                    }
                });
    }
}
