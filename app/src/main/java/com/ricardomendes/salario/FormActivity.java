package com.ricardomendes.salario;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    ImageButton btCalcular;
    EditText salario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btCalcular = (ImageButton) findViewById(R.id.btCalcular);
        salario = (EditText) findViewById(R.id.editSalario);
        btCalcular.setOnClickListener(OnClickCalcular());
    }

    private View.OnClickListener OnClickCalcular() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(salario.getText().toString().equals("")){
                    Toast.makeText(FormActivity.this, "Para prosseguir é necessário digitar um valor para salário!", Toast.LENGTH_LONG).show();
                    salario.setFocusable(true);
                }else {
                    Bundle params = new Bundle();
                    params.putString("salario", salario.getText().toString());
                    Intent intent = new Intent(FormActivity.this, ResultActivity.class);
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };
    }
}
