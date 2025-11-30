package com.devcalc.service;

import com.devcalc.model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void adicao() {
        double a = 50;
        double b = 5;
        CalculatorModel result = calculatorService.adicao(a, b);
        assertEquals(50, result.getNumeroA());
        assertEquals(5, result.getNumeroB());
        assertEquals(55, result.getResultado());
        assertEquals("adição", result.getOperacao());
    }

    @Test
    void subtracao() {
        double a = 75;
        double b = 5;
        CalculatorModel result = calculatorService.subtracao(a, b);
        assertEquals(75, result.getNumeroA());
        assertEquals(5, result.getNumeroB());
        assertEquals(70, result.getResultado());
        assertEquals("subtração", result.getOperacao());
    }

    @Test
    void multiplicacao() {
        double a = 10;
        double b = 5;
        CalculatorModel result = calculatorService.multiplicacao(a, b);
        assertEquals(10, result.getNumeroA());
        assertEquals(5, result.getNumeroB());
        assertEquals(50, result.getResultado());
        assertEquals("multiplicação", result.getOperacao());
    }

    @Test
    void divisao() {
        double a = 10;
        double b = 5;
        CalculatorModel result = calculatorService.divisao(a, b);
        assertEquals(10, result.getNumeroA());
        assertEquals(5, result.getNumeroB());
        assertEquals(2, result.getResultado());
        assertEquals("divisão", result.getOperacao());
    }

    @Test
    void divisaoPorZero() {
        double a = 10;
        double b = 0;
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculatorService.divisao(a, b)
        );
        assertEquals("Divisão por zero não é permitida", exception.getMessage());
    }

    @Test
    void adicaoNumerosNegativos() {
        double a = -5;
        double b = -3;
        CalculatorModel result = calculatorService.adicao(a, b);
        assertEquals(-8, result.getResultado());
        assertEquals("adição", result.getOperacao());
    }

    @Test
    void multiplicacaoPorZero() {
        double a = 10;
        double b = 0;
        CalculatorModel result = calculatorService.multiplicacao(a, b);
        assertEquals(0, result.getResultado());
        assertEquals("multiplicação", result.getOperacao());
    }
}
