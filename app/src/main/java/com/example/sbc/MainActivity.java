package com.example.sbc;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView chartView = findViewById(R.id.chartView);

        AstroCalculator calc = new AstroCalculator();
        double marsLon = calc.getPlanetLongitude("Mars", 2026, 9, 23, 10.0, 19.0760, 72.8777);
        String marsNakshatra = calc.getNakshatra(marsLon);

        SBCLogic logic = new SBCLogic();
        List<String> vedhas = logic.calculateVedha("Mars", marsNakshatra);

        StringBuilder sb = new StringBuilder();
        sb.append("Mars Longitude: ").append(marsLon).append("\n");
        sb.append("Mars Nakshatra: ").append(marsNakshatra).append("\n");
        for(String v : vedhas){
            sb.append(v).append("\n");
        }

        chartView.setText(sb.toString());
    }
}
