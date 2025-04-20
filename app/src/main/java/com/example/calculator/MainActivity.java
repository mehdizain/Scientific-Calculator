package com.example.calculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText display;
    Button[] btn;
    Button ac;
    Button del;
    Button[] ops;
    private Double currentval=0.0;
    private String currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn=new Button[11];
        ops=new Button[5];

        display=findViewById(R.id.display0);
        btn[0]=findViewById(R.id.b0);
        btn[1]=findViewById(R.id.b1);
        btn[2]=findViewById(R.id.b2);
        btn[3]=findViewById(R.id.b3);
        btn[4]=findViewById(R.id.b4);
        btn[5]=findViewById(R.id.b5);
        btn[6]=findViewById(R.id.b6);
        btn[7]=findViewById(R.id.b7);
        btn[8]=findViewById(R.id.b8);
        btn[9]=findViewById(R.id.b9);
        btn[10]=findViewById(R.id.bdec);
        ac=findViewById(R.id.bAC);
        del=findViewById(R.id.bDel);
        ops[0]=findViewById(R.id.bsum);
        ops[1]=findViewById(R.id.bsub);
        ops[2]=findViewById(R.id.bmul);
        ops[3]=findViewById(R.id.bdiv);
        ops[4]=findViewById(R.id.beq);
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="0";
                display.setText(a);
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="1";
                display.setText(a);
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="2";
                display.setText(a);
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="3";
                display.setText(a);
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="4";
                display.setText(a);
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="5";
                display.setText(a);
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="6";
                display.setText(a);
            }
        });
        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="7";
                display.setText(a);
            }
        });
        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="8";
                display.setText(a);
            }
        });
        btn[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+="9";
                display.setText(a);
            }
        });
        btn[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a+=".";
                display.setText(a);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentval=0.0;
                currentOperation="";
                String a="";
                display.setText(a);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                a=a.substring(0,a.length()-1);
                display.setText(a);
            }
        });

        ops[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                if(a.length()==0)
                {
                    currentval+=currentval;
                }
                else {
                    currentval += Double.parseDouble(a);
                }
                currentOperation="+";
                display.setText("");
            }
        });
        ops[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                if(a.length()==0)
                {
                    currentval-=currentval;
                }
                else {
                    currentval = Double.parseDouble(a)-currentval;
                }
                currentOperation="-";
                display.setText("");
            }
        });
        ops[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                if(a.length()==0)
                {
                    currentval*=currentval;
                }
                else {
                    if(currentval==0)
                    {
                        currentval=Double.parseDouble(a);
                    }
                    else currentval *= Double.parseDouble(a);
                }
                currentOperation="*";
                display.setText("");

            }
        });
        ops[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                if(a.length()==0)
                {
                    currentval/=currentval;
                }
                else {
                    if(currentval!=0)
                    {currentval /= Double.parseDouble(a);}
                    else
                    {
                        currentval=Double.parseDouble(a);
                    }
                }
                currentOperation="/";
                display.setText("");
            }
        });
        ops[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=display.getText().toString();
                double secondVal=0.0;
                double result=0;
                if(a.length()!=0) {
                        secondVal = Double.parseDouble(a);
                }
                else{
                    secondVal=currentval;
                }
                if(currentOperation=="+")
                {
                    result=currentval+secondVal;
                }
                if(currentOperation=="-")
                {
                    result=currentval-secondVal;
                }
                if(currentOperation=="*")
                {
                    result=currentval*secondVal;
                }
                if(currentOperation=="/")
                {
                    if(secondVal==0)
                    {
                        Toast.makeText(MainActivity.this, "Error: Divided by Zero", Toast.LENGTH_SHORT).show();
                    }
                    result=currentval/secondVal;
                }
                display.setText(String.valueOf(result));
                currentval=0.0;
            }
        });
    }
}