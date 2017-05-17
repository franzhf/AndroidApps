package com.example.franz_dpc.fhf_salarybreakup;

import android.app.ListActivity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.franz_dpc.fhf_salarybreakup.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Franz-DPC on 16/5/2017.
 */

public class ListItemActivity extends ListActivity {

    private class ItemArrayAdapter extends ArrayAdapter<Item> {


        public ItemArrayAdapter(Context context, int textViewResourceId,
                                List<Item> objects) {
            super(context, textViewResourceId, objects);
            Log.d("ItemArrayAdapter ctr", "1");
        }

        public ItemArrayAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            Log.d("ItemArrayAdapter ctr", "2");
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            Log.d("getView", "1");
            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(0, null);
            }

            Item item = getItem(position);

            /*if (item != null) {
                TextView tvFirstName = (TextView) v.findViewById(R.id.lblName);

                if (tvLastName != null) {
                    tvLastName.setText(item.getLastName);
                }*/
            return v;
        }

    }

    public List<Item> items;

    public ListItemActivity() {
        items = new ArrayList<Item>();
        items.add(new Item("Homer"));
        items.add(new Item("Bart"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        ItemArrayAdapter adapter = new ItemArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);

        Log.d("list item activity", "Running!!!");
    }
}
