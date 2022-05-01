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
    int result = 0;
    String operation  = new String("");
    boolean isOperation= false;
    int flag = 0;
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
        if(textView.getText().equals("0"))
        {
            textView.setText("");
        }
        if (flag == 1)
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
            textView.clearComposingText();
            textView.setText(textView.getText() + button.getText().toString());
            isOperation = false;
            flag = 0;
        }
    }
    public void ButtonOperator_Click(View v)
    {
        button=(Button) findViewById(v.getId());
        if(isOperation==false)
        {
            operation = button.getText().toString();
            result = Integer.parseInt((textView.getText().toString()));
            operation_textView.setText("Operation= " +result + operation);
            isOperation = true;
        }
    }
}