package com.example.tofim.ejemplo_vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText("Editamos el texto desde código");
        Button b;
        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "Boton click");
            }
        });
        // Checkbox
        CheckBox cb;
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                if (cb.isChecked()) {
// TODO si el checkbox esta seleccionado
                    Log.e("Info", "CheckBox seleccionado");
                } else {
// TODO si el checkbox no esta seleccionado
                    Log.e("Info", "CheckBox no seleccionado");
                }
            }
        });
        // Radiobutton
        RadioButton rb0 = (RadioButton) findViewById(R.id.radio);
        rb0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "RadioButton0 seleccionado");
            }
        });
        RadioButton rb1 = (RadioButton) findViewById(R.id.radio);
        rb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "RadioButton1 seleccionado");
            }
        });
        // EditText
        EditText et = (EditText) findViewById(R.id.editText);
        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
// Se captura el texto al pulsar enter
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    EditText et = (EditText) v;
                    Log.e("Info", et.getText().toString());
                }
                return false;
            }
        });
        // Spinner
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.SpinnerArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                Log.e("Info", "Se ha seleccionado " + arg3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        //Seekbar
        SeekBar sb = (SeekBar)findViewById(R.id.seekBar2);
        sb.setMax(10);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Integer i = seekBar.getProgress();
                Log.e("Info", i.toString());
            }
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser)
            {
            }
        });


    }
}
