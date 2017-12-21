package gracehong.rolodex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Grace on 12/20/2017.
 */

public class ContactArrayAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> myContacts;

    public ContactArrayAdapter(ArrayList<Contact> contactList) {
        myContacts = contactList;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        String fullName = myContacts.get(position).getFirstName() + " " + myContacts.get(position).getLastName();
        String company = myContacts.get(position).getCompany();
        String date = myContacts.get(position).getStartDate();
        String email = myContacts.get(position).getEmail();
        String bio = myContacts.get(position).getBio();

        holder.name.setText(fullName);
        holder.company.setText(company);
        holder.startDate.setText(date);
        holder.email.setText(email);
        holder.bio.setText(bio);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return myContacts.size();
    }
}