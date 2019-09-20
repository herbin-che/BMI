package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText height;
    EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText)findViewById(R.id.input_height);
        weight = (EditText)findViewById(R.id.input_weight);
        Button submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(!("".equals(height.getText().toString())||"".equals(weight.getText().toString()))){
                    float h = Float.parseFloat(height.getEditableText().toString());
                    float w = Float.parseFloat(weight.getEditableText().toString());
                    float a_score;
                    TextView score = (TextView)findViewById(R.id.score);

                    h = h/100;
                    h = h*h;

                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    a_score = w/h;
                    score.setText("BMI值："+nf.format(w/h)+"");
                    TextView a_result = findViewById(R.id.result);

                    if(a_score<18.5)
                        a_result.setText("结果：轻飘飘似张纸！");
                    else if(18.5<=a_score&&a_score<24)
                        a_result.setText("结果：完美身材！");
                    else if(24<=a_score&&a_score<27)
                        a_result.setText("结果：一丢丢肿～");
                    else if(27<=a_score&&a_score<30)
                        a_result.setText("结果：轻度肥胖！");
                    else if(30<=a_score&&a_score<35)
                        a_result.setText("结果：中度肥胖！");
                    else if(a_score>35)
                        a_result.setText("结果：秤子已自尽～");
                }
            }
        });

    }
}
