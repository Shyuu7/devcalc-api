package com.devcalc.service;

import com.devcalc.model.CalculatorModel;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculatorModel adicao(double a, double b) {
        double result = a + b;
        return new CalculatorModel(a, b, result, "adição");
    }

    public CalculatorModel subtracao(double a, double b) {
        double result = a - b;
        return new CalculatorModel(a, b, result, "subtração");
    }

    public CalculatorModel multiplicacao(double a, double b) {
        double result = a * b;
        return new CalculatorModel(a, b, result, "multiplicação");
    }

    public CalculatorModel divisao(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        double result = a / b;
        return new CalculatorModel(a, b, result, "divisão");
    }
}
