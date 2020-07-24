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
            if (s.equals(number[i])) {
                return true;
            }
            //isNumber= s.equals(number[i]);
        }
        return false;
    }

    //the method of calculation
    private void calculate() {
        //screen2.setText(String.format("%s original \n", screen2.getText()));
        String xxx = calculate((String) screen.getText());

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
        //System.out.print("calcukator");

        if (s.contains(" ")) {
            screen2.setText(String.format("%s  1st contain blank ", screen2.getText()));
            if (s.contains("(")) {
                String temp = s.substring(s.indexOf("(") + 1);
                if (!temp.contains("(")) {
                    temp = s.substring(0, s.indexOf(")") - 1);
                    String temp2 = s.substring(s.indexOf("("), s.indexOf(")") + 1);
                    return s.replace(temp2, calculate(temp));
                }
                if (s.indexOf("(") < s.indexOf(")")) {
                    return s.replace(temp, calculate(temp));
                }
            }

            screen2.setText(String.format("%s  part2", screen2.getText()));
            String substring = s.substring(s.indexOf(" ") + 1);
            String s3 = substring.substring(0, s.indexOf(" ") + substring.indexOf(" "));
            if (s.contains("*") || s.contains("/")) {
                screen2.setText(String.format("%s  contain */ ", screen2.getText()));
                if ((s.indexOf(" ") + 1) == s.indexOf("*") ||
                        (s.indexOf(" ") + 1) == s.indexOf("/")
                ) {
                    screen2.setText(String.format("%s  1st */ ", screen2.getText()));
                    double result = 0;
                    String s1, s2;
                    s1 = s.substring(0, s.indexOf(" "));
                    screen2.setText(String.format(s1, screen2.getText()));
                    val0 = Double.parseDouble(s1);
                    if (substring.contains(" ")) {
                        s2 = substring.substring(0, substring.indexOf(" "));
                    } else {
                        s2 = substring;
                    }
                    val1 = Double.parseDouble(s2);
                    screen2.setText(String.format(s2, screen2.getText()));

                    if ((s.indexOf(" ") + 1) == s.indexOf("*")) {
                        result = val0 * val1;
                    } else if ((s.indexOf(" ") + 1) == s.indexOf("/")) {
                        result = val0 / val1;
                    }
                    //else{                            screen2.setText(String.format("%s \n */error", screen2.getText()));}

                    String res = Double.toString(result);
                    screen2.setText(String.format(res, screen2.getText()));
                    return s.replace(s3, res);

                } else {
                    String temp = s.substring(s.indexOf(" ") + 1);
                    return s.replace(temp, calculate(temp));
                }
            }

            //screen2.setText(String.format("%s  part3 ", screen2.getText()));
            if ((s.contains("+") || s.contains("-"))
                    && !(s.contains("*") && s.contains("/"))) {
                //screen2.setText(String.format("%s contain+-", screen2.getText()));
                double result = 0;
                //screen2.setText(String.format("%s new res", screen2.getText()));
                String s1, s2;
                //screen2.setText(String.format("%s new s1s2", screen2.getText()));
                s1 = s.substring(0, s.indexOf(" "));
                screen2.setText(String.format(s1, screen2.getText()));
                val0 = Double.parseDouble(s1);
                //screen2.setText(String.format("%s double", screen2.getText()));
                if (substring.contains(" ")) {
                    screen2.setText(String.format("%s  contain blank", screen2.getText()));
                    s2 = substring.substring(0, substring.indexOf(" "));
                } else {
                    screen2.setText(String.format("%s  not contain blank", screen2.getText()));
                    s2 = substring;
                }
                val1 = Double.parseDouble(s2);

                screen2.setText(String.format(s2, screen2.getText()));
                if ((s.indexOf(" ") + 1) == s.indexOf("+")) {
                    screen2.setText(String.format("%s  calculate +", screen2.getText()));
                    result = val0 + val1;
                } else if ((s.indexOf(" ") + 1) == s.indexOf("-")) {
                    screen2.setText(String.format("%s  calculate -", screen2.getText()));
                    result = val0 - val1;
                }

                String res = Double.toString(result);
                screen2.setText(String.format(res, screen2.getText()));
                return s.replace(s3, res);
            }

        }
        return s;
    }
}