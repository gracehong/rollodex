package gracehong.rolodex;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Grace on 12/20/2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView company;
    public TextView startDate;
    public TextView email;
    public TextView bio;

    public ContactViewHolder(View view) {
        super(view);

        name = view.findViewById(R.id.contact_name);
        company = view.findViewById(R.id.contact_company);
        startDate = view.findViewById(R.id.contact_date);
        email = view.findViewById(R.id.contact_email);
        bio = view.findViewById(R.id.contact_bio);
    }
}
