package com.example.admin.parcelableandserializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /* two different ways to send an object between activities. Last lesson used intents to send
    data.
     */

    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;
    private EditText etPersonAddress;

    List<PersonSerializable> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etPersonAge = (EditText) findViewById(R.id.etPersonAge);
        etPersonGender = (EditText) findViewById(R.id.etPersonGender);
        etPersonAddress = (EditText) findViewById(R.id.etPersonAddress);
    }

    public void sendPerson(View view) {
        //pass personSerializable to second activity and display them there.

        String personName = etPersonName.getText().toString();
        String personAge = etPersonAge.getText().toString();
        String personGender = etPersonGender.getText().toString();
        String personAddress = etPersonAddress.getText().toString();

        PersonSerializable personSerializable = new PersonSerializable( personName, personAge, personGender, personAddress );
        PersonParcelable personParcelable = new PersonParcelable( personName, personAge, personGender, personAddress );

        Intent intent = new Intent( this, PersonActivity.class );

        switch ( view.getId() ) {
            case R.id.btnPersonSerializable:
                intent.putExtra( "personSerializable", personSerializable);
                startActivity( intent );
                break;
            case R.id.btnPersonParcelable:
                intent.putExtra( "personParcelable", personParcelable);
                startActivity( intent );
                break;
            case R.id.btnSharePerson:
                Intent sendIntent = new Intent();
                sendIntent.setAction( Intent.ACTION_SEND );
                sendIntent.putExtra( Intent.EXTRA_TEXT, "This person's name is " + personName );
                sendIntent.setType( "text/plain" );
                startActivity( sendIntent );
                break;
            case R.id.btnSendList:
                intent.putExtra( "personList", (Serializable) personList );
                startActivity( intent );
                break;
        }
    }

    public void savePerson(View view) {

        String name = etPersonName.getText().toString();
        String age = etPersonAge.getText().toString();
        String gender = etPersonGender.getText().toString();
        String address = etPersonAddress.getText().toString();

        PersonSerializable person = new PersonSerializable( name, age, gender, address);

        boolean isAdded = personList.add( person );

        if( isAdded )
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Not Added", Toast.LENGTH_SHORT).show();
    }
}

/*
create add person to list button and send person list. adds person object to a list. when click send person list
 */