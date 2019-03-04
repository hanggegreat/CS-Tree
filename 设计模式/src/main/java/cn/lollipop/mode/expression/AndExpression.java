package cn.lollipop.mode.expression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AndExpression extends Expression{

    private Expression expression1;
    private Expression expression2;

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) && expression2.interpret(str);
    }
}
