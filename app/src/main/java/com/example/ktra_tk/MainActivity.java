package com.example.ktra_tk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonGiai;
    private EditText mTextA, mTextB, mTexrC;
    private TextView mTextX1, mTextX2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addACtion();
    }

    private void addACtion() {
        mButtonGiai.setOnClickListener(this);
    }

    private void initView() {
        mButtonGiai = findViewById(R.id.button_Giai);
        mTextA = findViewById(R.id.editText_HeSoA);
        mTextB = findViewById(R.id.editText_HeSoB);
        mTexrC = findViewById(R.id.editText_HeSoC);
        mTextX1 = findViewById(R.id.textView_X1);
        mTextX2 = findViewById(R.id.textView_X2);
    }

    @Override
    public void onClick(View view) {
        try {
            float a = Float.parseFloat(mTextA.getText().toString());
            float b = Float.parseFloat(mTextB.getText().toString());
            float c = Float.parseFloat(mTexrC.getText().toString());
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        mTextX1.setText("Phương trình vô số nghiệm");
                    } else
                        mTextX1.setText("Phương trình vô nghiệm");
                } else {
                    mTextX1.setText("Nghiệm x = " + (-c / b));
                }
            } else {
                float delta = b * b - 4 * a * c;
                if (delta < 0) {
                    mTextX1.setText("Phương trình vô nghiệm");
                } else if (delta == 0) {
                    mTextX1.setText("Phương trình có nghiệm kép x = " + (-b / (2 * a)));
                } else {
                    double sqrt_delta = Math.sqrt(delta);
                    mTextX1.setText("Nghiệm X1 = " + ((b * b) + sqrt_delta) / (2 * a));
                    mTextX2.setText("Nghiệm X2 = " + ((b * b) - sqrt_delta) / (2 * a));
                }
            }
        }catch (Exception ex){
            mTextX1.setText(ex.toString());
        }
    }
}
