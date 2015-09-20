package com.teman_firebaseio.teman;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Issac on 9/19/2015.
 */

public class ListFragment extends Fragment {

    private CustomAdapter customAdapter;
    private ArrayList<User> userArray = new ArrayList<User>();
    private ArrayList<String> testArray = new ArrayList<String>();

    public ListFragment(){

    }


    public void refresh(){
        Firebase ref = new Firebase("https://temanapp.firebaseio.com");

        ref.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                User newPost = snapshot.getValue(User.class);
                Log.v(" abc ", " " + newPost.getTitle() + " --- " + userArray.size());
                userArray.add(newPost);
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        customAdapter.clear();
        for(User user : userArray) {
            customAdapter.add(new User(user.getTitle(), user.getDescription()
                    ,user.getName(), user.getphoneNumber()));

        }

    }


    @Override
    public void onStart() {
        refresh();
        super.onStart();
    }

    @Override
    public void onPause() {

        super.onPause();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    //    LoadEventTask let = new LoadEventTask();
    //    let.execute();

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) rootView.findViewById(R.id.inviteButton);

        Log.v("DDD", "" + userArray.size());

        customAdapter = new CustomAdapter(getActivity(), userArray);

        refresh();

        ListView listView = (ListView) rootView.findViewById(R.id.eventListView);
        listView.setAdapter(customAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InviteActivity.class);
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // when click, pass the title to the detail fragment.
                // use the title to get the related components.
                String selectedItem = userArray.get(position).getTitle();
                //     Intent intent = new Intent(getActivity(), DetailActivity.class)
                //             .putExtra(Intent.EXTRA_TEXT, selectedItem);
                //     startActivity(intent);

            }
        });

        return rootView;
    }

    public class LoadEventTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            super.onPostExecute(aVoid);
        }
    }



}
