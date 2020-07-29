package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {


    //-------------------variables----------------------------
    //all the bottom of calculator
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0,
            butAdd, butSub, butEqual, butMul, butDiv, butC, butPoint, butDel, butLeft, butRight;

    //the screen show the present calculate
    //the screen2 show the past calculate, and it also show the error sentence when people test it.
    TextView screen;
    TextView screen2;

    //to determine what is number, include all digital number and the point.
    final String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."};

    //boolean add,sub,mul,div;
    //1:+, 2:-, 3:*, 4:/, 0:return original value
    int op = 0;

    // to check if it is the first calculate
    boolean first = true;

    //to record the previous value of calculation
    String past;
    //-----------------------end of variables---------------------

    //------------------------Constructors-----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        butPoint = (Button) findViewById(R.id.butPoint);

        butLeft = (Button) findViewById(R.id.butLeft);
        butRight = (Button) findViewById(R.id.butRight);

        butAdd = (Button) findViewById(R.id.butAdd);
        butSub = (Button) findViewById(R.id.butSub);
        butMul = (Button) findViewById(R.id.butMul);
        butDiv = (Button) findViewById(R.id.butDiv);

        butEqual = (Button) findViewById(R.id.butEqual);
        butC = (Button) findViewById(R.id.butC);
        butDel = (Button) findViewById(R.id.butDel);


        screen2 = (TextView) findViewById(R.id.screen2);
        screen2.setText("");
        screen2.setText(String.format("%s welcome", screen2.getText()));


        screen = (TextView) findViewById(R.id.screen);
        screen.setText("");
        screen.setText(String.format("%s Have a " +
                "good day", screen.getText()));

        //set bottom
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

        butPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s.", screen.getText()));
            }
        });

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s +", screen.getText()));
            }
        });
        butSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s -", screen.getText()));
            }
        });
        butMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s *", screen.getText()));
            }
        });
        butDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(String.format("%s /", screen.getText()));
            }
        });

        butLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s (", screen.getText()));
            }
        });

        butRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                screen.setText(String.format("%s )", screen.getText()));
            }
        });

        butEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculate();
                } catch (Exception e) {
                    screen2.setText(String.format("%s  equal error", screen2.getText()));
                }
            }
        });

        butC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetC();
            }
        });

        butDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteLast();
            }
        });
    }

    //----------------method-------------------------

    //delete the last element of equation.
    //if num or point delete 1 unit, if it is operation delete the signal and the blank
    private void deleteLast() {
        String input = screen.getText().toString();

        if (input.length() == 0) {
            screen.setText("");
            resetC();
        }
        else {
            String lastChar = input.substring(input.length() - 1);
             if (!isNum(lastChar)) {

                screen.setText(input.substring(0, input.length() - 2));
            } else if (isNum(lastChar)) {
                //String lastChar = input.substring(input.length() - 1);
                screen.setText(input.substring(0, input.length() - 1));
            } else {
                screen.setText(String.format("%s  wrong del", screen.getText()));
            }
        }
    }

    // to check if it is the first calculate
    private void check() {
        if (first) {
            //screen.setText(String.format("%s  wrong del", screen.getText()));
            screen.setText("");
            screen2.setText("");
            first = false;
        }
    }

    //to reset the state of calculator
    private void resetC() {
        screen.setText("");
        screen2.setText("");
        first = true;
    }

    //to check if the string is number or not
    private boolean isNum(String s) {
        //boolean isNumber=false;
        for (int i = 0; i <= 10; i++) {
            if (!s.equals(number[i])) {
                return false;
            }
            //isNumber= s.equals(number[i]);
        }
        return true;
    }

    //the method of calculation
    private void calculate() {
        //if there is a calculate loop error
        int count=0;
        //screen2.setText(String.format("%s original \n", screen2.getText()));
        String xxx = (String) screen.getText();
        calculate(xxx);

        //set screen past to show the equation that have be calculated
        screen2.setText(String.format("%s  calculates", screen2.getText()));

        //show the result in screen present with signal "="
        screen.setText(String.format("%s  =", screen.getText()));
        past = xxx;
        first = true;
        //resetC();
    }

    private String calculate(String s) {
        double val0 = 0;
        double val1 = 0;
        //System.out.print("calculator");

        //to check is there any operation
        if (s.contains(" ")) {
            System.out.println("the string: "+ s);

            //if the string still contain '('
            if (s.contains("(")) {
                System.out.print("contain(");
                String temp = s.substring(s.indexOf("(") + 1);
                System.out.println(temp);
                String substring = s.substring(s.indexOf("("), s.indexOf(")") + 1);
                System.out.println(substring);

                //if the string still contain '('
                if(temp.contains("(")){
                    System.out.println("still!!!!! contain (");
                    //if the next signal is '(' not ')'
                    //which means it is something like '(aa(' that still need to calculate the inside
                    if (s.indexOf("(") < s.indexOf(")")) {
                        System.out.println("( before )");
                        return s.substring(0,s.indexOf("(")-1)+calculate(s.substring(s.indexOf("(")));
                    }
                    //if the next signal is ')' not '('
                    //which means it is something like 'aa)' that the end of Priority
                    if(s.indexOf("(") > s.indexOf(")"))
                    return calculate(calculate(s.substring(0,s.indexOf(")")-1))+s.substring(0,s.indexOf(")")));
                }

            }

            //case with out any (
            else {
                if (s.contains(")")){
                    System.out.print("calculate error");
                    screen.setText(String.format("%s input error", screen.getText()));
                }

                //the 1st num in the string and convert it into int
                String s1;
                s1 = s.substring(0, s.indexOf(" "));

                //the operation
                String op = s.substring(s.indexOf(" "),s.indexOf(" ") + 2);
                //let the 2ed num be the string after 1st operation
                String s2=s.substring(s.indexOf(" ")+1);;
                //string of two value and one opertaion
                String s3 = null;
                //if there still any operation in the 2nd num
                if(s2.contains(" ")) {
                     s2= s2.substring(0,s2.indexOf(" "));
                     s3= s.substring(0, s.indexOf(" ") + s2.length());
                }

                System.out.println(s3);

                //the result that will return
                double result = 0;
                //if there is * or /
                 System.out.println("***///");
                if (s.contains("*") || s.contains("/")) {
                    //if the 1st op is */
                    if (op.equals("*")||op.equals("/")
                    ) {
                        System.out.println("1st op is */");

                        try {
                            val0 = Double.parseDouble(s1);
                            val1 = Double.parseDouble(s2);
                        } catch (Exception e) {
                            System.out.println("error: */");
                        }
                        if (op.equals("*")) {
                            result = val0 * val1;
                        }
                        if (op.equals("/")) {
                            result = val0 / val1;
                        }
                        String res = Double.toString(result);
                        return calculate(res+s3);
                    }

                }

                //if there is  + or -
                if ((s.contains("+") || s.contains("-"))
                        ) {
                    //if(s.contains("*") && s.contains("/")){
                        //System.out.println("+- error");
                        try {
                            val0 = Double.parseDouble(s1);
                            val1 = Double.parseDouble(calculate(s2));
                        }
                        catch(Exception e){
                            System.out.println("error: +-");
                        }
                    if(op.equals("+")){
                        result= val0 + val1;
                    }
                    if(op.equals("+")){
                        result= val0 - val1;
                    }
                    String res = Double.toString(result);
                    return calculate(res+s3);
                }
            }
        }
        if(!isNum(s)){
            screen.setText(String.format("%s input error", screen.getText()));
        }
        return s;
    }
}