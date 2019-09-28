package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textNama;
    private TextView textAge;
    private TextView textPhone;
    private TextView textEmail;
    private TextView textLove;
    private Button buttonSave;
    private UserPreference userPreference;

    private boolean isPreferenceEmpty= false;
    private UserModel userModel;

    private final int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showExistingPreference();
    }
    private void showExistingPreference(){
        userModel= userPreference.getUser();
        populateView(userModel);
        checkForm(userModel);
    }
    private void populateView(UserModel userModel){
        textNama.setText(String.valueOf(userModel.getAge()).isEmpty()?"Tidak Ada": String.valueOf());
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            