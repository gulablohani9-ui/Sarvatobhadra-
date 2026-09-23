package com.example.sbc;

import swisseph.*;

public class AstroCalculator {
    private static final String[] nakshatras = {
        "Ashwini","Bharani","Krittika","Rohini","Mrigashira","Ardra","Punarvasu",
        "Pushya","Ashlesha","Magha","Purva Phalguni","Uttara Phalguni","Hasta",
        "Chitra","Swati","Vishakha","Anuradha","Jyeshtha","Mula","Purva Ashadha",
        "Uttara Ashadha","Shravana","Dhanishta","Shatabhisha","Purva Bhadrapada",
        "Uttara Bhadrapada","Revati","Abhijit"
    };

    private static final double NAKSHATRA_SPAN = 13.3333;
    private SwissEph sw = new SwissEph();

    public double getPlanetLongitude(String planet, int year, int month, int day, double hour, double lat, double lon) {
        SweDate sd = new SweDate(year, month, day, hour);
        double[] xx = new double[6];
        int planetId;

        switch(planet) {
            case "Sun": planetId = SweConst.SE_SUN; break;
            case "Moon": planetId = SweConst.SE_MOON; break;
            case "Mars": planetId = SweConst.SE_MARS; break;
            case "Mercury": planetId = SweConst.SE_MERCURY; break;
            case "Jupiter": planetId = SweConst.SE_JUPITER; break;
            case "Venus": planetId = SweConst.SE_VENUS; break;
            case "Saturn": planetId = SweConst.SE_SATURN; break;
            case "Rahu": planetId = SweConst.SE_MEAN_NODE; break;
            case "Ketu": planetId = SweConst.SE_TRUE_NODE; break;
            default: planetId = SweConst.SE_SUN;
        }

        sw.swe_set_topo(lat, lon, 0); // set location
        sw.swe_calc_ut(sd.getJulDay(), planetId, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
        return xx[0]; // longitude in degrees
    }

    public String getNakshatra(double longitude) {
        int index = (int)(longitude / NAKSHATRA_SPAN);
        if(index >= nakshatras.length) index = nakshatras.length - 1;
        return nakshatras[index];
    }
}
