package com.le.letaskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.le.letaskapp.model.Address;
import com.le.letaskapp.model.Company;
import com.le.letaskapp.model.UserDetails;

public class UserDetailsActivity extends AppCompatActivity {

    private UserDetails userDetails;
    private AppCompatTextView tv_name_value, tv_user_name_value, tv_email_value, tv_phone_value, tv_web_value,
            tv_street_value, tv_suite_value, tv_city_value, tv_zip_value,
            tv_company_name_value, tv_phrase_value, tv_bs_value;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        if (getIntent()!= null){
            userDetails = getIntent().getParcelableExtra("details");
        }

        initialize();

        setValues();
    }

    private void initialize () {
        tv_name_value = findViewById(R.id.tv_name_value);
        tv_user_name_value = findViewById(R.id.tv_user_name_value);
        tv_email_value = findViewById(R.id.tv_email_value);
        tv_phone_value = findViewById(R.id.tv_phone_value);
        tv_web_value = findViewById(R.id.tv_web_value);
        tv_street_value = findViewById(R.id.tv_street_value);
        tv_suite_value = findViewById(R.id.tv_suite_value);
        tv_city_value = findViewById(R.id.tv_city_value);
        tv_zip_value = findViewById(R.id.tv_zip_value);
        tv_company_name_value = findViewById(R.id.tv_company_name_value);
        tv_phrase_value = findViewById(R.id.tv_phrase_value);
        tv_bs_value = findViewById(R.id.tv_bs_value);
    }

    private void setValues () {
        if (userDetails != null){
            tv_name_value.setText(userDetails.getName());
            tv_user_name_value.setText(userDetails.getUsername());
            tv_email_value.setText(userDetails.getEmail());
            tv_phone_value.setText(userDetails.getPhone());
            tv_web_value.setText(userDetails.getWebsite());

            Address address = getIntent().getParcelableExtra("address");
            tv_street_value.setText(address.getStreet());
            tv_suite_value.setText(address.getSuite());
            tv_city_value.setText(address.getCity());
            tv_zip_value.setText(address.getZipcode());

            Company company = getIntent().getParcelableExtra("company");
            tv_company_name_value.setText(company.getName());
            tv_phrase_value.setText(company.getCatchPhrase());
            tv_bs_value.setText(company.getBs());
        }
    }
}