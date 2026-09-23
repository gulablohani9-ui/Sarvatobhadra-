AstroCalculator calc = new AstroCalculator();

// Example: Mars position on 23 Sept 2026, 10:00 AM, Mumbai (19.0760°N, 72.8777°E)
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
