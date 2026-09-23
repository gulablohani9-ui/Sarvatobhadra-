package com.example.sbc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example: Call SBC logic
        SBCLogic logic = new SBCLogic();
        String chart = logic.generateChart("23-09-2026", "Mumbai");
        System.out.println(chart);
    }
}
