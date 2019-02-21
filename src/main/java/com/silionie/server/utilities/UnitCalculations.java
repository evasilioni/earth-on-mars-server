package com.silionie.server.utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class UnitCalculations {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitCalculations.class);

    public static int calculateScore(Map<Integer, Long> reviewsByUnitMap){
        try{
            int sumOfProduct = 0;
            int sumTotal = 0;

            for(Map.Entry reviewByUnit : reviewsByUnitMap.entrySet()){
                Integer a = (int) reviewByUnit.getKey();
                Long b = (long)reviewByUnit.getValue();
                sumOfProduct += a*b;
                sumTotal += b;
            }

            if(sumTotal != 0){
                return sumOfProduct / sumTotal;
            }
        }catch (Exception ex){
            LOGGER.error("ERROR on calculation of score:" + ex.getMessage());
        }
        return 0;
    }

}
