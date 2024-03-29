package gracehong.rolodex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Grace on 12/20/2017.
 * Custom Array Adapter for the contact class which specifies how to load the data from one
 * individual contact object into the pertinent fields of the custom contact_layout xml (as referenced
 * by the contact view holder class)
 */

public class ContactArrayAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> myContacts;
    private Context context;


    public ContactArrayAdapter(ArrayList<Contact> contactList, Context context) {
        myContacts = contactList;
        this.context = context; //need to initialize with context, for image loading via Picasso
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        String fullName = myContacts.get(position).getFirstName() + " " + myContacts.get(position).getLastName();
        String company = myContacts.get(position).getCompany();
        String date = myContacts.get(position).getStartDate();
        String email = myContacts.get(position).getEmail();
        String bio = myContacts.get(position).getBio();
        String imgURL = myContacts.get(position).getPicURL();

        holder.name.setText(fullName);
        holder.company.setText(company);
        holder.startDate.setText(date);
        holder.email.setText(email);
        holder.bio.setText(bio);

        //Load image using Picasso Library
        Picasso.with(context).load(imgURL).resize(200, 200)
                .centerCrop().into(holder.image);
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
