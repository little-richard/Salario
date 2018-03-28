package com.ricardomendes.salario;

/**
 * Created by Ricardo Mendes on 25/03/2018.
 */

public class Salario {
    private int faixaInss, faixaIrpf;
    double valorDescontoInss, valorDescontoIrpf, salarioLiquido, salarioBruto;

    public Salario(String sal){
        salarioBruto = Double.parseDouble(sal);
        calcFaixaInss();
        calcDescontoInss();
        calcFaixaIrpf();
        calcDescontoIrpf();
        calcSalarioLiquido();
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    private void calcFaixaInss(){
        if(salarioBruto<=1659.38){
            faixaInss = 1;
        }else if(salarioBruto>1659.38 && salarioBruto<=2765.66){
            faixaInss = 2;
        }else if(salarioBruto>2765.66 && salarioBruto<=5531.31){
            faixaInss = 3;
        }else if(salarioBruto>5531.31){
            faixaInss = 4;
        }
    }

    public int getFaixaInss(){
        return faixaInss;
    }

    private void calcDescontoInss(){
        if(faixaInss==1){
            valorDescontoInss = salarioBruto * 0.08;
        }else if(faixaInss==2){
            valorDescontoInss = salarioBruto * 0.09;
        }else if(faixaInss==3){
            valorDescontoInss = salarioBruto * 0.11;
        }else if(faixaInss==4){
            valorDescontoInss = salarioBruto * 0.11;
        }
    }

    public double getValorDescontoInss(){
        return valorDescontoInss;
    }

    private void calcFaixaIrpf(){
        if(salarioBruto<=1903.98){
            faixaIrpf = 1;
        }else if(salarioBruto>1903.98 && salarioBruto<=2826.65){
            faixaIrpf = 2;
        }else if(salarioBruto>2826.65 && salarioBruto<=3751.05){
            faixaIrpf = 3;
        }else if(salarioBruto>3751.05 && salarioBruto<=4664.68){
            faixaIrpf = 4;
        }else if(salarioBruto>4664.68){
            faixaIrpf = 5;
        }
    }

    public int getFaixaIrpf(){
        return faixaIrpf;
    }
    private void calcDescontoIrpf(){
        if(faixaIrpf==1){
            valorDescontoIrpf = salarioBruto * 0;
        }else if(faixaIrpf==2){
            valorDescontoIrpf = salarioBruto * (7.5/100);
        }else if(faixaIrpf==3){
            valorDescontoIrpf = salarioBruto * (15.0/100);
        }else if(faixaIrpf==4){
            valorDescontoIrpf = salarioBruto * (22.5/100);
        }else if(faixaIrpf==5){
            valorDescontoIrpf = salarioBruto * (27.5/100);
        }
    }

    public double getValorDescontoIrpf(){
        return valorDescontoIrpf;
    }

    private void calcSalarioLiquido(){
        salarioLiquido = salarioBruto - (valorDescontoInss + valorDescontoIrpf);
    }

    public double getSalarioLiquido(){
        return salarioLiquido;
    }
}
