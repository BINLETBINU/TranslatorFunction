package com.example.transfunc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_main);
        EditText edt = findViewById(R.id.srcword);
        Button bt = findViewById(R.id.button);
        TextView ot = findViewById(R.id.output);
        translator tt = new translator();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ot.setText(tt.TranslateText(edt.getText().toString()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}