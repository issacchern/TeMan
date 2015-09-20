package com.teman_firebaseio.teman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Issac on 9/19/2015.
 */
public class DetailActivityFragment extends Fragment {

    private String mString;
    private ArrayList<IndividualItem> individualItems = new ArrayList<IndividualItem>();

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        return rootView;




    }
}
