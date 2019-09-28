package com.example.settingpreference;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

public class PreferenceFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private String DEFAULT_VALUE= "Tidak Ada";
    private String NAMA;
    private String EMAIL;
    private String AGE;
    private String PHONE;
    private String LOVE;

    private EditTextPreference namaPreference;
    private EditTextPreference emailPreference;
    private EditTextPreference agePreference;
    private EditTextPreference phonePreference;
    private CheckBoxPreference lovePreference;
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference);
        init();
        setSummari();
    }
    private void init(){
        NAMA= getResources().getString(R.string.key_name);
        EMAIL= getResources().getString(R.string.key_email);
        AGE= getResources().getString(R.string.key_age);
        PHONE= getResources().getString(R.string.key_phone);
        LOVE= getResources().getString(R.string.key_love);

        namaPreference=(EditTextPreference)findPreference(NAMA);
        emailPreference=(EditTextPreference)findPreference(EMAIL);
        agePreference=(EditTextPreference)findPreference(AGE);
        phonePreference=(EditTextPreference)findPreference(PHONE);
        lovePreference=(CheckBoxPreference)findPreference(LOVE);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(NAMA)){
            namaPreference.setSummary(sharedPreferences.getString(NAMA, DEFAULT_VALUE));
        }
        if(key.equals(EMAIL)){
            emailPreference.setSummary(sharedPreferences.getString(EMAIL, DEFAULT_VALUE));
        }
        if(key.equals(AGE)){
            agePreference.setSummary(sharedPreferences.getString(AGE, DEFAULT_VALUE));
        }
        if (key.equals(PHONE)){
            phonePreference.setSummary(sharedPreferences.getString(PHONE, DEFAULT_VALUE));
        }
        if (key.equals(LOVE)){
            lovePreference.setChecked(sharedPreferences.getBoolean(LOVE, false));
        }
    }
    private void setSummari(){
        SharedPreferences sh= getPreferenceManager().getSharedPreferences();
        namaPreference.setSummary(sh.getString(NAMA, DEFAULT_VALUE));
        emailPreference.setSummary(sh.getString(EMAIL, DEFAULT_VALUE));
        agePreference.setSummary(sh.getString(AGE, DEFAULT_VALUE));
        phonePreference.setSummary(sh.getString(PHONE, DEFAULT_VALUE));
        lovePreference.setChecked(sh.getBoolean(LOVE, false));

    }
}
