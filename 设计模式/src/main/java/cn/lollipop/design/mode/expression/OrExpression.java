package cn.lollipop.design.mode.expression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrExpression extends Expression {

    private Expression expression1;
    private Expression expression2;

    @Override
    public boolean interpret(String str) {
        return expression1.interpret(str) || expression2.interpret(str);
    }
}
