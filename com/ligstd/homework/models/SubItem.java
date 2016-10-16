package com.ligstd.homework.models;

import java.util.Map;

public class SubItem {

    private Double coefficient;
    private Map<String, Double> variables;

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Map<String, Double> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Double> variables) {
        this.variables = variables;
    }

    public SubItem(Double coefficient, Map<String, Double> variables) {
        setCoefficient(coefficient);
        setVariables(variables);
    }

    @Override
    protected void finalize() throws Throwable {
        if (null != getVariables()) getVariables().clear();
        super.finalize();
    }

}
