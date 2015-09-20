package com.teman_firebaseio.teman;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Issac on 9/19/2015.
 */
public class CustomAdapter extends ArrayAdapter<User> {

    public CustomAdapter(Activity context, List<User> user){

        super(context, 0, user);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView nameView = (TextView) convertView.findViewById(R.id.list_item_text_view);
        nameView.setText(user.getTitle());


        return convertView;
    }
}
