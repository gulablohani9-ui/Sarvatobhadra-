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
            default: planetId = SweConst.SE_SUN;
        }

        sw.swe_set_topo(lat, lon, 0);
        sw.swe_calc_ut(sd.getJulDay(), planetId, SweConst.SEFLG_SWIEPH, xx, new StringBuffer());
        return xx[0];
    }

    public String getNakshatra(double longitude) {
        int index = (int)(longitude / NAKSHATRA_SPAN);
        if(index >= nakshatras.length) index = nakshatras.length - 1;
        return nakshatras[index];
    }
}
