package com.ligstd.homework.merging;

import com.ligstd.homework.models.SubItem;

import java.util.List;

public abstract class CanMerge {
    protected static void Merge(List<SubItem> expression) {
        Integer expressionSize = expression.size();
        for (Integer subItemIndex1 = 0; subItemIndex1 < expressionSize; subItemIndex1++) {
            SubItem subItem1 = expression.get(subItemIndex1);
            for (Integer subItemIndex2 = subItemIndex1 + 1; subItemIndex2 < expressionSize; subItemIndex2++) {
                SubItem subItem2 = expression.get(subItemIndex2);
                Boolean canMerge = true;
                if (null == subItem1.getVariables() && null == subItem2.getVariables()) canMerge = true;
                else if (null == subItem1.getVariables() || null == subItem2.getVariables()) canMerge = false;
                else if (subItem1.getVariables().isEmpty() || subItem2.getVariables().isEmpty()) canMerge = false;
                else canMerge = CheckCanMerge(subItem1, subItem2) && CheckCanMerge(subItem2, subItem1);
                if (canMerge) {
                    subItem1.setCoefficient(subItem1.getCoefficient() + subItem2.getCoefficient());
                    expression.remove(subItem2);
                    expressionSize--;
                    subItemIndex2--;
                }
            }
        }
    }

    private static Boolean CheckCanMerge(SubItem subItem1, SubItem subItem2) {
        Boolean canMerge = true;
        for (String subItem2VariableName : subItem2.getVariables().keySet()) {
            if (!subItem1.getVariables().containsKey(subItem2VariableName)) canMerge = false;
            else {
                Double power1 = subItem1.getVariables().get(subItem2VariableName);
                Double power2 = subItem2.getVariables().get(subItem2VariableName);
                if (!power1.equals(power2)) canMerge = false;
            }
        }
        return canMerge;
    }
}
