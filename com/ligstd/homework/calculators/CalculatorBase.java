package com.ligstd.homework.calculators;

import com.ligstd.homework.merging.CanMerge;
import com.ligstd.homework.models.Command;
import com.ligstd.homework.models.SubItem;

import java.util.ArrayList;
import java.util.List;

public abstract class CalculatorBase extends CanMerge {
    private List<SubItem> expression;

    private Command command;

    private List<SubItem> newExpression;

    public List<SubItem> getExpression() {
        return expression;
    }

    public void setExpression(List<SubItem> expression) {
        this.expression = expression;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<SubItem> getNewExpression() {
        return newExpression;
    }

    public void setNewExpression(List<SubItem> newExpression) {
        this.newExpression = newExpression;
    }

    public CalculatorBase() {
        setNewExpression(new ArrayList<>());
    }

    public abstract void Calculate();
}
