package com.teman_firebaseio.teman;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Issac on 9/19/2015.
 */
public class InviteActivity extends AppCompatActivity {

    private String edit_title;
    private String edit_desc;
    private String edit_name;
    private String edit_tel;

    private Button button;
    private EditText editText_1;
    private EditText editText_2;
    private EditText editText_3;
    private EditText editText_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite);

        button = (Button) findViewById(R.id.submitButton);

        editText_1 = (EditText)findViewById(R.id.editText_1);
        editText_2 = (EditText)findViewById(R.id.editText_2);
        editText_3 = (EditText)findViewById(R.id.editText_3);
        editText_4 = (EditText)findViewById(R.id.editText_4);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        edit_title = editText_1.getText().toString();
                        edit_desc = editText_2.getText().toString();
                        edit_tel = editText_4.getText().toString();
                        edit_name = editText_3.getText().toString();

                        if(edit_title.length() >= 3 && edit_desc.length() >= 3 ){
                            if(edit_name.length() == 0){
                                edit_name = "unavailable";
                            }

                            if(edit_tel.length() == 0){
                                edit_tel = "unavailable";
                            }



                            Firebase ref = new Firebase("https://teman.firebaseio.com/");

                            User input = new User( edit_title,edit_desc,edit_name,edit_tel);

                            ref.push().setValue(input);







                            Toast.makeText(getApplicationContext(),"Your post has been submitted!",
                                    Toast.LENGTH_LONG).show();

                            finish();


                        } else{
                            Toast.makeText(getApplicationContext(),"title/description empty or too short!",
                                    Toast.LENGTH_SHORT).show();

                        }



                    }
                });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
