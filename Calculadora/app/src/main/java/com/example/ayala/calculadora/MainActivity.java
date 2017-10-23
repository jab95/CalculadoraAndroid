package com.example.ayala.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDivision,btnMulti,btnSuma,btnResta,btnIgual,btnBorrar;
    private ArrayList<String> arrayParaCalculos;
    String num="";
    int suma=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnMulti = (Button)findViewById(R.id.btnMulti);
        btnResta = (Button)findViewById(R.id.btnResta);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);



        ListenerBotones listenerBotones = new ListenerBotones(this);

        btnDivision.setOnClickListener(listenerBotones);
        btnMulti.setOnClickListener(listenerBotones);
        btnSuma.setOnClickListener(listenerBotones);
        btnResta.setOnClickListener(listenerBotones);
        btnIgual.setOnClickListener(listenerBotones);
        btnBorrar.setOnClickListener(listenerBotones);

        btn1.setOnClickListener(listenerBotones);
        btn2.setOnClickListener(listenerBotones);
        btn3.setOnClickListener(listenerBotones);
        btn4.setOnClickListener(listenerBotones);
        btn5.setOnClickListener(listenerBotones);
        btn6.setOnClickListener(listenerBotones);
        btn7.setOnClickListener(listenerBotones);
        btn8.setOnClickListener(listenerBotones);
        btn9.setOnClickListener(listenerBotones);
        btn0.setOnClickListener(listenerBotones);

    }


    public TextView getResultado(){
        return (TextView)this.findViewById(R.id.txtResult);
    }


    public Button getBtn1(){
        return (Button)findViewById(R.id.btn1);
    }
    public Button getBtn2(){
        return (Button)findViewById(R.id.btn2);
    }
    public Button getBtn3(){
        return (Button)findViewById(R.id.btn3);
    }
    public Button getBtn4(){
        return (Button)findViewById(R.id.btn4);
    }
    public Button getBtn5(){
        return (Button)findViewById(R.id.btn5);
    }
    public Button getBtn6(){
        return (Button)findViewById(R.id.btn6);
    }
    public Button getBtn7(){
        return (Button)findViewById(R.id.btn7);
    }
    public Button getBtn8(){
        return (Button)findViewById(R.id.btn8);
    }
    public Button getBtn9(){
        return (Button)findViewById(R.id.btn9);
    }
    public Button getBtn0(){
        return (Button)findViewById(R.id.btn0);
    }
    public Button getBtnMulti(){
        return (Button)findViewById(R.id.btnMulti);
    }
    public Button getBtnDivi(){
        return (Button)findViewById(R.id.btnDivision);
    }
    public Button getBtnSuma(){
        return (Button)findViewById(R.id.btnSuma);
    }
    public Button getBtnResta(){ return (Button)findViewById(R.id.btnResta);}
    public Button getBtnIgual(){ return (Button) findViewById(R.id.btnIgual);}

    public ArrayList<String> getArrayParaCalculos(){
        return arrayParaCalculos;
    }




}
