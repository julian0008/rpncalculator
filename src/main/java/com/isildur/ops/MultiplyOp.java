package com.isildur.ops;

public class MultiplyOp implements Operation {
    @Override
    public Double execute(Double a, Double b) {
        return b * a;
    }
}
