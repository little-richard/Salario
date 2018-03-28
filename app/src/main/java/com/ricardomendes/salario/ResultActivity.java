package com.ricardomendes.salario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    TextView faixaIrpf;
    TextView faixaInss;
    TextView descontoIrpf;
    TextView descontoInss;
    TextView salarioLiquido;
    TextView salarioBruto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        faixaIrpf = (TextView) findViewById(R.id.faixaIrpf);
        faixaInss = (TextView) findViewById(R.id.faixaInss);
        descontoInss = (TextView) findViewById(R.id.descontoInss);
        descontoIrpf = (TextView) findViewById(R.id.descontoIrpf);
        salarioLiquido = (TextView) findViewById(R.id.salarioLiquido);
        salarioBruto = (TextView) findViewById(R.id.salBruto);

        Bundle args = getIntent().getExtras();
        String salario = args.getString("salario");
        Salario sal = new Salario(salario);
        int fxIrpf = sal.getFaixaIrpf();
        int fxInss = sal.getFaixaInss();
        double descInss = sal.getValorDescontoInss();
        double descIrpf = sal.getValorDescontoIrpf();
        double salLiquido = sal.getSalarioLiquido();
        double salBruto = sal.getSalarioBruto();

        switch (fxInss){
            case 1:
                faixaInss.setText("Faixa 1 INSS: até 1.659,38 -> 8%");
                break;
            case 2:
                faixaInss.setText("Faixa 2 INSS: de 1.659,39 até 2.765,66 -> 9%");
                break;
            case 3:
                faixaInss.setText("Faixa 3 INSS: de 2.765,67 até 5.531,31 -> 11%");
                break;
            case 4:
                faixaInss.setText("Faixa 4 INSS: apartir 5.531,31 -> 11%");
                break;
        }
        switch (fxIrpf){
            case 1:
                faixaIrpf.setText("Faixa 1 IRPF: Até 1.903,98 -> 0%");
                break;
            case 2:
                faixaIrpf.setText("Faixa 2 IRPF: de 1.903,99 até 2.826,65 -> 7,5%");
                break;
            case 3:
                faixaIrpf.setText("Faixa 3 IRPF: de 2.826,66 até 3.751,05 -> 15%");
                break;
            case 4:
                faixaIrpf.setText("Faixa 4 IRPF: de 3.751,06 até 4.664,68 -> 22.5%");
                break;
            case 5:
                faixaIrpf.setText("Faixa 4 IRPF: acima de 4.664,68 -> 27.5%");
                break;
        }
        DecimalFormat df = new DecimalFormat("0.##");
        String inss = df.format(descInss);
        String irpf = df.format(descIrpf);
        String liquido = df.format(salLiquido);
        String bruto = df.format(salBruto);
        descontoInss.setText("Desconto INSS: " + inss);
        descontoIrpf.setText("Desconto IRPF: " + irpf);
        salarioLiquido.setText("Salario Liquido: " + liquido);
        salarioBruto.setText("Salario Bruto: " + bruto);

    }
}
