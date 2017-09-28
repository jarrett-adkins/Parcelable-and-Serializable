package com.example.admin.parcelableandserializable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    private static final String TAG = "PersonActivity";
    List<PersonSerializable> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        /*
        PersonParcelable personParcelable = getIntent().getParcelableExtra( "personParcelable" );

        if( personParcelable != null ) {
            Toast.makeText( this, personParcelable.getName(), Toast.LENGTH_SHORT).show();
            System.out.println(1);
        } else {
            PersonSerializable personSerializable = (PersonSerializable) getIntent()
                    .getSerializableExtra("personSerializable");
            Toast.makeText( this, personSerializable.getName(), Toast.LENGTH_SHORT).show();

        }//*/

        personList = (List<PersonSerializable>) getIntent().getSerializableExtra( "personList" );

        for(PersonSerializable p: personList) {
            Log.d(TAG, p.getName() );
            Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
