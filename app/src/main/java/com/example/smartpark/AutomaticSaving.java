package com.example.smartpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class AutomaticSaving extends AppCompatActivity {
    private static final String LOG_TAG = "/TAG/"+AutomaticSaving.class.getSimpleName();
    private SharedPreferences mPreferences;
    EditText bluetooth_text;
    Switch auto_switch, blt_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic_saving);

        auto_switch = findViewById(R.id.automatic_switch);
        blt_switch = findViewById(R.id.bluetooth_switch);
        bluetooth_text = findViewById(R.id.bluetoothtext);

        // ------------------------------------------------------
        // GET delle informazioni
        // ------------------------------------------------------

        String sharedPrefFile = "com.example.smartparkapp";
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE); //TODO: Invece che usare shared forse bisogna usare local storage? Se elimino app che succede? Perdo dati o no?

        auto_switch.setChecked(mPreferences.getBoolean("auto_switch", false));
        blt_switch.setChecked(mPreferences.getBoolean("blt_switch", false));
        bluetooth_text.setText(mPreferences.getString("blt_name", ""));

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveFunction();
        Log.d(LOG_TAG, "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    // ------------------------------------------------------
    // Salvataggio delle informazioni
    // ------------------------------------------------------

    public void saveButton(View v){
        saveFunction();                 //TODO: Perchè salva le informazioni anche senza che clicco il tasto salva??
    }

    private void saveFunction(){
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putBoolean("auto_switch", auto_switch.isChecked());
        preferencesEditor.putBoolean("blt_switch", blt_switch.isChecked());
        preferencesEditor.putString("blt_name", bluetooth_text.getText().toString());
        preferencesEditor.apply();
    }

}
