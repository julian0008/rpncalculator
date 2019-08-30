package com.isildur;


import com.isildur.ops.AddOp;
import com.isildur.ops.DivideOp;
import com.isildur.ops.MultiplyOp;
import com.isildur.ops.Operation;
import com.isildur.ops.SubtractOp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class RpnCalculator {

    Deque<Double> stack = new ArrayDeque<>();

    public String execute(String expression) {

        StringTokenizer strings = new StringTokenizer(expression, " ");

        while(strings.hasMoreElements()) {
            String token = (String) strings.nextElement();
            if(token.matches("[-]?[0-9]*.[0-9]+|[0-9]+")) {
                stack.push(Double.parseDouble(token));
            } else {
                Operation op = getOperation(token);
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(op.execute(a, b));
            }
        }

        return Double.toString(stack.pop());
    }

    public Operation getOperation(String operator) {
        switch(operator) {
            case "+":
                return new AddOp();
            case "-":
                return new SubtractOp();
            case "*":
                return new MultiplyOp();
            case "/":
                return new DivideOp();
            default:
                throw new IllegalArgumentException("Operator " + operator + " not supported.");
        }
    }
}
