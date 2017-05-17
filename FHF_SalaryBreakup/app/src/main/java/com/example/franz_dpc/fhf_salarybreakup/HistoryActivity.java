package com.example.franz_dpc.fhf_salarybreakup;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.franz_dpc.fhf_salarybreakup.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Franz-DPC on 15/5/2017.
 */



public class HistoryActivity  extends AppCompatActivity {

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

    public HistoryActivity() {
        items = new ArrayList<Item>();
        items.add(new Item("Homer"));
        items.add(new Item("Bart"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView listView = (ListView)  findViewById(R.id.viewHistory);


        final ItemArrayAdapter adapter = new ItemArrayAdapter(this, R.layout.activity_history, items);
        listView.setAdapter(adapter);
        Log.d("OnCrete method", "");

        // Inflate layout
        //  Binding class will be generated based on the name of the layout file ex.activy_history to ActivityHistoryBinding
        ActivityHistoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        DataSource ds = new DataSource();
        ds.title = "The magic";
        binding.setDataSource(ds);

    }
}
