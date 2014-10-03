package com.bsu.mmf.web.losdy.studentinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private static final String NAME_INDEX = "name";
    private static final String PHONE_INDEX = "phone";
    private static final String EMAIL_INDEX = "email";
    private static final String ADRESS_INDEX = "adress";

    private EditText mNameInput;
    private EditText mPhoneInput;
    private EditText mEmailInput;
    private EditText mAdressInput;

    private Button mConfirmButton;

    private String getName() {
        return mNameInput.getText().toString();
    }
    private String getPhone() {
        return mPhoneInput.getText().toString();
    }
    private String getEmail() {
        return mEmailInput.getText().toString();
    }
    private String getAdress() {
        return mAdressInput.getText().toString();
    }

    private void setName(String name) {
        mNameInput.setText(name);
    }
    private void setPhone(String phone) {
        mPhoneInput.setText(phone);
    }
    private void setEmail(String email) {
        mEmailInput.setText(email);
    }
    private void setAdress(String adress) {
        mAdressInput.setText(adress);
    }

    private void reset() {
        setName("");
        setPhone("");
        setEmail("");
        setAdress("");
        Toast.makeText(MainActivity.this, R.string.reset_text, Toast.LENGTH_SHORT).show();
    }

    private boolean validation() {
        String name = getName().trim();
        String phone = getPhone().trim();
        String email = getEmail().trim();
        String adress = getAdress().trim();

        if (name.length() > 0 && phone.length() > 0 && email.length() > 0 && adress.length() > 0) {
            return true;
        } else {
            Toast.makeText(MainActivity.this, R.string.validation_not_complete_text, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameInput = (EditText) findViewById(R.id.name_input);
        mPhoneInput = (EditText) findViewById(R.id.phone_input);
        mEmailInput = (EditText) findViewById(R.id.email_input);
        mAdressInput = (EditText) findViewById(R.id.adress_input);

        if (savedInstanceState != null) {
            setName(savedInstanceState.getString(NAME_INDEX, new String()));
            setPhone(savedInstanceState.getString(PHONE_INDEX, new String()));
            setEmail(savedInstanceState.getString(EMAIL_INDEX, new String()));
            setAdress(savedInstanceState.getString(ADRESS_INDEX, new String()));
        }

        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    Intent i = new Intent(MainActivity.this, SubActivity.class);
                    i.putExtra(SubActivity.EXTRA_NAME, getName());
                    i.putExtra(SubActivity.EXTRA_PHONE, getPhone());
                    i.putExtra(SubActivity.EXTRA_EMAIL, getEmail());
                    i.putExtra(SubActivity.EXTRA_ADRESS, getAdress());
                    startActivity(i);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(NAME_INDEX, getName());
        savedInstanceState.putString(PHONE_INDEX, getPhone());
        savedInstanceState.putString(EMAIL_INDEX, getEmail());
        savedInstanceState.putString(ADRESS_INDEX, getAdress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
