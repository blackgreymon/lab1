package com.ligstd.homework.utils;

import com.ligstd.homework.merging.CanMerge;
import com.ligstd.homework.models.SubItem;

import java.util.*;

public class Utils extends CanMerge {

    public static String RemoveSpaces(String s) {
        return s.replaceAll("\\s", "");
    }

    public static String PreProcessMinus(String s) {
        String result = s.replaceAll("-", "+-");
        if (result.startsWith("+-")) result = result.substring(1);
        return result;
    }

    public static String PostProcessMinus(String s) {
        return s.replaceAll("\\+-", "-");
    }

    public static String RemoveZeros(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("\\.?0+?$", "");
        }
        return s;
    }

    public static List<SubItem> Multiply(List<SubItem> expression1, List<SubItem> expression2) {
        List<SubItem> result = new ArrayList<>();
        for (SubItem subItem1 : expression1) {
            for (SubItem subItem2 : expression2) {
                Double newCoefficient = subItem1.getCoefficient() * subItem2.getCoefficient();

                Map<String, Double> newVariables = new HashMap<>();
                newVariables.putAll(subItem1.getVariables());

                for (String variableName2 : subItem2.getVariables().keySet()) {
                    Double power2 = subItem2.getVariables().get(variableName2);

                    if (newVariables.containsKey(variableName2)) {
                        Double power1 = newVariables.get(variableName2);
                        newVariables.put(variableName2, power1 + power2);
                    }
                    else{
                        newVariables.put(variableName2, power2);
                    }
                }

                result.add(new SubItem(newCoefficient, newVariables));
            }
        }
        Merge(result);
        return result;
    }
}
