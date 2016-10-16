package com.ligstd.homework.models;

import com.ligstd.homework.enums.CommandEnum;

import java.util.Map;

public class Command {
    private CommandEnum type;
    private Map<String, Double> expressions;

    public CommandEnum getType() {
        return type;
    }

    public void setType(CommandEnum type) {
        this.type = type;
    }

    public Map<String, Double> getExpressions() {
        return expressions;
    }

    public void setExpressions(Map<String, Double> expressions) {
        this.expressions = expressions;
    }

    public Command(CommandEnum type, Map<String, Double> expressions) {
        setType(type);
        setExpressions(expressions);
    }

    @Override
    protected void finalize() throws Throwable {
        if (null != getExpressions()) getExpressions().clear();
        super.finalize();
    }
}
