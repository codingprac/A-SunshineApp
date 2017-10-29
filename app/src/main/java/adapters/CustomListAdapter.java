package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import entities.ListItems;
import sunshine.com.sunshineapp.R;

/**
 * Created by deep on 6/19/16.
 */
public class CustomListAdapter extends ArrayAdapter<ListItems> {


    public CustomListAdapter(Context context, ArrayList<ListItems> listItems) {
        super(context, R.layout.list_items, listItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_items,parent,false);

        ListItems listItem = getItem(position);
        String image = listItem.getImage();
        String firstLine = listItem.getFirstTitle();
        String secondLine = listItem.getSecondTitle();

        ImageView imageView = (ImageView) customView.findViewById(R.id.icon);
        TextView firstLineView = (TextView) customView.findViewById(R.id.firstLine);
        TextView secondLineView = (TextView) customView.findViewById(R.id.secondLine);

        imageView.setImageResource(R.drawable.ic_launcher);
        firstLineView.setText(firstLine);
        secondLineView.setText(secondLine);

        return customView;
    }
}
