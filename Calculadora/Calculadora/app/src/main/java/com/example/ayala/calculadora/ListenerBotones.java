package com.example.ayala.calculadora;

import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Usuario on 17/10/2017.
 */

public class ListenerBotones implements View.OnClickListener {

    private MainActivity activity;
    private String[] arrayOperacion;
    private String operador="";
    private int contadorSignoPuesto=0;  //PARA COMPROBAR QUE NO SE HACE MAS DE 1 OPERACION

    public ListenerBotones(MainActivity activity){
        this.activity=activity;
    }
    @Override

    public void onClick(View view) {

        if (view.equals(activity.findViewById(R.id.btn1))) {
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn1().getText());

        }else if(view.equals(activity.findViewById(R.id.btn2))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn2().getText());

        }else if(view.equals(activity.findViewById(R.id.btn3))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn3().getText());

        }else if(view.equals(activity.findViewById(R.id.btn4))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn4().getText());

        }else if(view.equals(activity.findViewById(R.id.btn5))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn5().getText());

        }else if(view.equals(activity.findViewById(R.id.btn6))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn6().getText());

        }else if(view.equals(activity.findViewById(R.id.btn7))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn7().getText());

        }else if(view.equals(activity.findViewById(R.id.btn8))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn8().getText());

        }else if(view.equals(activity.findViewById(R.id.btn9))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn9().getText());

        }else if(view.equals(activity.findViewById(R.id.btn0))){
            activity.getResultado().setText(activity.getResultado().getText()+""+activity.getBtn0().getText());

        }else if(view.equals(activity.findViewById(R.id.btnSuma))){
            if(activity.getResultado().getText().length()!=0) {      //PARA COMPROBAR QUE NO SE PONE UN SIGNO ANTES QUE UN NUMERO AL PRINCIPIO

                if (comprobarDoblesSignos() && contadorSignoPuesto == 0) {
                    activity.getResultado().setText(activity.getResultado().getText() + "" + activity.getBtnSuma().getText());
                    operador = activity.getBtnSuma().getText().toString();
                    contadorSignoPuesto++;
                }
            }
        }else if(view.equals(activity.findViewById(R.id.btnDivision))){
            if(activity.getResultado().getText().length()!=0){
                if(comprobarDoblesSignos() && contadorSignoPuesto==0) {
                    activity.getResultado().setText(activity.getResultado().getText() + "" + activity.getBtnDivi().getText());
                    operador = activity.getBtnDivi().getText().toString();
                    contadorSignoPuesto++;
                }
            }

        }else if(view.equals(activity.findViewById(R.id.btnMulti))){
            if(activity.getResultado().getText().length()!=0) {

                if (comprobarDoblesSignos() && contadorSignoPuesto == 0) {
                    activity.getResultado().setText(activity.getResultado().getText() + "" + activity.getBtnMulti().getText());
                    operador = activity.getBtnMulti().getText().toString();
                    contadorSignoPuesto++;
                }
            }


        }else if(view.equals(activity.findViewById(R.id.btnResta))) {
            if(activity.getResultado().getText().length()!=0) {

                if (comprobarDoblesSignos() && contadorSignoPuesto == 0) {
                    activity.getResultado().setText(activity.getResultado().getText() + "" + activity.getBtnResta().getText());
                    operador = activity.getBtnResta().getText().toString();
                    contadorSignoPuesto++;
                }
            }

        }else if (view.equals(activity.findViewById(R.id.btnIgual))){
            if(activity.getResultado().getText().length()!=0) {

                try {
                    double resultado = saberOperacion(operador);
                    activity.getResultado().setText(String.valueOf(String.format("%.2f", resultado)));
                    contadorSignoPuesto = 0;
                }catch (NumberFormatException e){
                    Toast.makeText(activity,"Debe de poner otro numero antes de realizar la operacion",Toast.LENGTH_SHORT).show();

                }
                }

        }else if(view.equals(activity.findViewById(R.id.btnBorrar))){
            activity.getResultado().setText("");
            operador="";
        }


    }

    //SABER CUAL ES LA OPERACION QUE SE VA A REALIZAR

    public double saberOperacion(String operador){


        switch (operador){
            case "+":
                arrayOperacion=activity.getResultado().getText().toString().split(Pattern.quote(activity.getBtnSuma().getText().toString()));

                return Double.valueOf(arrayOperacion[0]) + Double.valueOf(arrayOperacion[1]);
            case "-":
                try {
                    arrayOperacion = activity.getResultado().getText().toString().split(Pattern.quote(activity.getBtnResta().getText().toString()));
                    return Double.valueOf(arrayOperacion[0]) - Double.valueOf(arrayOperacion[1]);

                }catch(NumberFormatException e){
                    return -(Double.valueOf(arrayOperacion[1]) + (Double.valueOf(arrayOperacion[2])));

                }

            case "/":
                arrayOperacion=activity.getResultado().getText().toString().split(Pattern.quote(activity.getBtnDivi().getText().toString()));
                return Double.valueOf(arrayOperacion[0]) / Double.valueOf(arrayOperacion[1]);

            case "*":
                arrayOperacion=activity.getResultado().getText().toString().split(Pattern.quote(activity.getBtnMulti().getText().toString()));
                return Double.valueOf(arrayOperacion[0]) * Double.valueOf(arrayOperacion[1]);

            default: return -1;

        }


    }

    //COMPROBAR QUE NO SEPONEN 2 SIGNOS SEGUIDOS

    public boolean comprobarDoblesSignos(){
        boolean puedesPoner=false;
        if(!(String.valueOf(activity.getResultado().getText().charAt(activity.getResultado().getText().length()-1)).equals(activity.getBtnSuma().getText().toString()))
                && !(String.valueOf(activity.getResultado().getText().charAt(activity.getResultado().getText().length()-1)).equals(activity.getBtnResta().getText().toString()))
                    && !(String.valueOf(activity.getResultado().getText().charAt(activity.getResultado().getText().length()-1)).equals(activity.getBtnMulti().getText().toString()))
                         && !(String.valueOf(activity.getResultado().getText().charAt(activity.getResultado().getText().length()-1)).equals(activity.getBtnDivi().getText().toString()))){

            puedesPoner=true;
        }
        return puedesPoner;
    }





}
