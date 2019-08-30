package com.isildur.ops;

public class AddOp implements Operation {
    @Override
    public Double execute(Double a, Double b) {
        return b + a;
    }
}
