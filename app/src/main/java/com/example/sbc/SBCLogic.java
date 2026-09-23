package com.example.sbc;

import java.util.*;

public class SBCLogic {
    private Map<String, int[]> gridMap = new HashMap<>();

    public SBCLogic() {
        int idx = 0;
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(idx < 28){
                    gridMap.put(getNakshatras()[idx], new int[]{r,c});
                    idx++;
                }
            }
        }
    }

    public List<String> calculateVedha(String planet, String nakshatra) {
        List<String> vedhaHits = new ArrayList<>();
        int[] pos = gridMap.get(nakshatra);

        for(Map.Entry<String,int[]> entry : gridMap.entrySet()){
            int[] cell = entry.getValue();
            if(cell[0] == pos[0] || cell[1] == pos[1]){
                vedhaHits.add("Tara Vedha on " + entry.getKey());
            }
        }

        for(Map.Entry<String,int[]> entry : gridMap.entrySet()){
            int[] cell = entry.getValue();
            if((cell[0]-pos[0]) == (cell[1]-pos[1])){
                vedhaHits.add("Latta Vedha on " + entry.getKey());
            }
        }

        return vedhaHits;
    }

    private String[] getNakshatras(){
        return new String[]{
            "Ashwini","Bharani","Krittika","Rohini","Mrigashira","Ardra","Punarvasu",
            "Pushya","Ashlesha","Magha","Purva Phalguni","Uttara Phalguni","Hasta",
            "Chitra","Swati","Vishakha","Anuradha","Jyeshtha","Mula","Purva Ashadha",
            "Uttara Ashadha","Shravana","Dhanishta","Shatabhisha","Purva Bhadrapada",
            "Uttara Bhadrapada","Revati","Abhijit"
        };
    }
}
