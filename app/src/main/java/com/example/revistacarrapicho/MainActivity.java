package com.example.revistacarrapicho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {
        int total = 0;

        LinearLayout root = findViewById(R.id.root);
        int count = root.getChildCount();
        for (int i = 0; i < count; i++) {
            View v = root.getChildAt(i);
            if (v instanceof LinearLayout) {
                LinearLayout layout = (LinearLayout) v;
                int c = layout.getChildCount();
                for (int i2 = 0; i2 < c; i2++) {
                    View vv = layout.getChildAt(i2);
                    if (vv instanceof RadioGroup) {
                        RadioGroup group = (RadioGroup) vv;

                        int add = 0;
                        int cc = group.getChildCount();
                        for (int i3 = 0; i3 < cc; i3++) {
                            RadioButton button = (RadioButton) group.getChildAt(i3);
                            if (button.isChecked()) {
                                add = Integer.parseInt(button.getTag().toString());
                                total += add;
                            }
                        }

                        if (add == 0) {
                            Toast.makeText(this, "Reponda todas as questões!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
        }

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("total", total);
        startActivity(intent);
    }
}
