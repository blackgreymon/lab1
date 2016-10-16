package com.ligstd.homework.calculators;

import com.ligstd.homework.models.SubItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DerivationCalculator extends CalculatorBase {
    @Override
    public void Calculate() {
        Derivate();
        Merge(getNewExpression());
    }

    private void Derivate() {
        setNewExpression(new ArrayList<>());
        String target = (String) (getCommand().getExpressions().keySet().toArray()[0]);
        Boolean hasTarget = false;
        for (SubItem subItem : getExpression()) {
            Map<String, Double> variables = subItem.getVariables();
            Double newCoefficient = subItem.getCoefficient();
            if (variables != null)
                if (variables.containsKey(target)) {
                    hasTarget = true;
                    Map<String, Double> newVariables = new HashMap<>();
                    for (String variableName : variables.keySet()) {
                        Double power = variables.get(variableName);
                        if (target.equals(variableName)) {
                            newCoefficient *= power;
                            if (power - 1.0 != 0.0) newVariables.put(variableName, power - 1.0);
                        } else {
                            newVariables.put(variableName, power);
                        }
                    }
                    if(newVariables.isEmpty()) newVariables = null;
                    getNewExpression().add(new SubItem(newCoefficient, newVariables));
                }
        }
        if (!hasTarget) throw new ArithmeticException("Error, No Variable.");
    }
}
