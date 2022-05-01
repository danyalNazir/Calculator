package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity<string> extends AppCompatActivity {
    Button button;
    TextView textView,operation_textView;
    Double result=0.0;
    String operation  = new String("");
    boolean isOperation= false;
    int flag = 0;
    int flagDecimal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        operation_textView=findViewById(R.id.operationTextView);
    }
    public void button_AC_Click(View v)
    {
        textView.setText("0");
        operation_textView.setText("");
        result=0.0;
        flagDecimal=0;
    }

    public void button_CE_Click(View v)
    {
        if(textView.getText().length()>0 && textView.getText().toString()!="0") {
            if(textView.getText().length()==1){
                button_AC_Click(v);
            }
            else {
                CharSequence text = textView.getText().toString();
                textView.setText(text.subSequence(0, text.length()-1));
            }
        }

    }
    public void ButtonClick(View v){
        button=(Button) findViewById(v.getId());
        if(textView.getText().equals("0") || flag == 1)
        {
            textView.setText("");
        }
        if (isOperation == false)
        {
            textView.setText(textView.getText() + button.getText().toString());
            isOperation = false;
            flag = 0;
        }
        if(isOperation==true)
        {
            textView.setText("");
            textView.setText(textView.getText() + button.getText().toString());
            isOperation = false;
            flag = 0;
        }
    }
    public void ButtonDecimal(View v)
    {
        button=(Button) findViewById(v.getId());
        if(flagDecimal==0 && isOperation==false)
        {
            if(textView.getText().toString()=="0")
            {
                textView.setText("0" + button.getText().toString());
            }
            else {
                textView.setText(textView.getText() + button.getText().toString());
            }
            flagDecimal=1;
        }
    }

    public void ButtonOperator_Click(View v)
    {
        button=(Button) findViewById(v.getId());
        if(isOperation==false)
        {
            operation = button.getText().toString();
            result = Double.parseDouble(textView.getText().toString());
            operation_textView.setText(result +" "+ operation);
            isOperation = true;
            flagDecimal=0;
        }
    }
    public void ButtonEqual_Click(View v)
    {
        if(result!=0.0 && textView.getText().toString()!="0")
        {
            Double answer;
            switch (operation) {
                case "+":
                {
                    answer=result + Double.parseDouble(textView.getText().toString());
                    textView.setText(String.valueOf(answer));
                    break;
                }
                case "-":
                {
                    answer=result - Double.parseDouble(textView.getText().toString());
                    textView.setText(String.valueOf(answer));
                    break;
                }
                case "×":
                {
                    answer=result * Double.parseDouble(textView.getText().toString());
                    textView.setText(String.valueOf(answer));
                    break;
                }
                case "÷":
                {
                    answer=result / Double.parseDouble(textView.getText().toString());
                    textView.setText(String.valueOf(answer));
                    break;
                }
                case "%":
                {
                    answer=result % Double.parseDouble(textView.getText().toString());
                    textView.setText(String.valueOf(answer));
                    break;
                }
                default:
                    break;
            }
            flag = 1;
        }
        else
       return;
    }
}