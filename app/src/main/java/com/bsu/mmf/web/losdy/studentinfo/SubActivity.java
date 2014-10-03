package com.bsu.mmf.web.losdy.studentinfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SubActivity extends Activity {

    private static final String NAME_INDEX = "name";
    private static final String PHONE_INDEX = "phone";
    private static final String EMAIL_INDEX = "email";
    private static final String ADRESS_INDEX = "adress";

    public static final String EXTRA_NAME = "com.bsu.mmf.web.losdy.studentinfo.name";
    public static final String EXTRA_PHONE = "com.bsu.mmf.web.losdy.studentinfo.phone";
    public static final String EXTRA_EMAIL = "com.bsu.mmf.web.losdy.studentinfo.email";
    public static final String EXTRA_ADRESS = "com.bsu.mmf.web.losdy.studentinfo.adress";

    private TextView mNameInput;
    private TextView mPhoneInput;
    private TextView mEmailInput;
    private TextView mAdressInput;
    private Button mCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String name = i.getStringExtra(EXTRA_NAME);
        String phone = i.getStringExtra(EXTRA_PHONE);
        String email = i.getStringExtra(EXTRA_EMAIL);
        String adress = i.getStringExtra(EXTRA_ADRESS);

        mNameInput = (TextView) findViewById(R.id.name_input);
        mPhoneInput = (TextView) findViewById(R.id.phone_input);
        mEmailInput = (TextView) findViewById(R.id.email_input);
        mAdressInput = (TextView) findViewById(R.id.adress_input);

        mNameInput.setText(name);
        mPhoneInput.setText(phone);
        mEmailInput.setText(email);
        mAdressInput.setText(adress);

        mCallButton = (Button) findViewById(R.id.call_button);
        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:" + mPhoneInput.getText());
                Intent i = new Intent(Intent.ACTION_CALL, number);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
