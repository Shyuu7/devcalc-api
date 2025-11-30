package com.devcalc.model;

public class CalculatorModel {
    private final double numeroA;
    private final double numeroB;
    private final double result;
    private final String operation;

    public CalculatorModel(double numeroA, double numeroB, double result, String operation) {
        this.numeroA = numeroA;
        this.numeroB = numeroB;
        this.result = result;
        this.operation = operation;
    }

    public double getNumeroA() {
        return numeroA;
    }

    public double getNumeroB() {
        return numeroB;
    }

    public double getResultado() {
        return result;
    }

    public String getOperacao() {
        return operation;
    }

}
