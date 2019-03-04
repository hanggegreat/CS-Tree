package cn.lollipop.mode.expression;

import lombok.AllArgsConstructor;

import java.util.StringTokenizer;

@AllArgsConstructor
public class TerminalExpression extends Expression {

    private String literal;

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
