package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,
            butAdd,butSub,butEqual,butMul,butDiv,butC,butPoint,butDel;
    TextView screen;

    //boolean add,sub,mul,div;
    int op=0;//1:+, 2:-, 3:*, 4:/, 0:return original value
    boolean first=true;// to check if it is the first calculate
    double past;

    private void check(){// to check if it is the first calculate
        if (!first){
            screen.setText("");
            first=true;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0=(Button)findViewById(R.id.num0);
        num1=(Button)findViewById(R.id.num1);
        num2=(Button)findViewById(R.id.num2);
        num3=(Button)findViewById(R.id.num3);
        num4=(Button)findViewById(R.id.num4);
        num5=(Button)findViewById(R.id.num5);
        num6=(Button)findViewById(R.id.num6);
        num7=(Button)findViewById(R.id.num7);
        num8=(Button)findViewById(R.id.num8);
        num9=(Button)findViewById(R.id.num9);
        butAdd=(Button)findViewById(R.id.butAdd);
        butSub=(Button)findViewById(R.id.butSub);
        butEqual=(Button)findViewById(R.id.butEqual);
        butMul=(Button)findViewById(R.id.butMul);
        butDiv=(Button)findViewById(R.id.butDiv);
        butC=(Button)findViewById(R.id.butC);
        butPoint=(Button)findViewById(R.id.butPoint);
        butDel=(Button)findViewById(R.id.butDel);

        screen=(TextView) findViewById(R.id.screen);
        screen.setText("");


        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s0", screen.getText()));
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s1", screen.getText()));
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s2", screen.getText()));
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s3", screen.getText()));
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s4", screen.getText()));
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s5", screen.getText()));
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s6", screen.getText()));
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s7", screen.getText()));
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s8", screen.getText()));
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s9", screen.getText()));
            }
        });


        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op=1;
                screen.setText(String.format("%s +", screen.getText()));
            }
        });

        butSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op=2;
                screen.setText(String.format("%s -", screen.getText()));
            }
        });

        butMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op=3;
                screen.setText(String.format("%s *", screen.getText()));
            }
        });

        butDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op=4;
                screen.setText(String.format("%s /", screen.getText()));
            }
        });

        butPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s.", screen.getText()));
            }
        });

        butEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calculate();
                }
                catch(Exception e){
                    screen.setText(String.format("%s equal error", screen.getText()));
                }
            }
        });

        butC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                screen.setText("");
                int op=0;
            }
        });

        butDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = screen.getText().toString();
                if(input.length()==0){
                    screen.setText("");
                }
                else {
                    screen.setText(input.substring(0, input.length() - 1));
                }
            }
        });
    }


    private void calculate(){
        double val0=0,val1=0;
        //screen.setText(String.format("%s 1aaa", screen.getText()));
        screen.setText(String.format("%s ", screen.getText()));
        //screen.setText(String.format("%s 2aaa", screen.getText()));
        String exp = screen.getText().toString();
        //screen.setText(String.format("%s 3aqaa", screen.getText()));
        //String x= "op:"+String.valueOf(op) +"org0:" +screen.getText();
        //screen.setText(x);
        if(op!=0 ) {

            String s1 = exp.substring(0, exp.indexOf(" "));
            val0 = Double.parseDouble(s1);
            //screen.setText(String.format(String.valueOf(val_0), screen.getText()));



            //String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
            String s2="0";
            try {
                s2 = exp.substring(exp.indexOf(" ") + 2);
                val1 = Double.parseDouble(s2);
                //String xs1= String.valueOf(val1) + screen.getText();
                //screen.setText(xs1);
                //screen.setText(String.format(String.valueOf(val_1), screen.getText()));
            }

            catch(Exception ignored){   screen.setText(String.format("%s can not v2", screen.getText()));         }




            double result = 0;
            switch (op) {
                case 1:
                    result = val0 + val1;
                    break;
                case 2:
                    result = val0 - val1;
                    break;
                case 3:
                    result = val0 * val1;
                    break;
                case 4:
                    if (val1 != 0) {
                        result = val0 / val1;
                    } else {
                        screen.setText(String.format("%s can not divide 0.", screen.getText()));
                    }
                    break;
                default:
                    screen.setText(String.format("%s wrong op", screen.getText()));
            }


            String sResult = Double.toString(result);
            //String xxx=screen.getText()+" = "+sResult;
            String xxx=sResult;
            screen.setText(xxx);
            past=result;
            //screen.setText(String.format(sResult, screen.getText()));
            //screen.setText(String.format("%s wrong op", screen.getText()));
            //creen.setText(String.format(String.valueOf(val_0), screen.getText()));
            //screen.setText(String.format(, screen.getText()));

        }
        //else{
            //screen.setText(exp);
        //}
        //screen.setText("");
        int op=0;
        val0=0;
        val1=0;
        first=false;

    }
}