package com.devcalc.controller;

import com.devcalc.model.CalculatorModel;
import com.devcalc.model.ErrorResponse;
import com.devcalc.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Calculadora", description = "Operações matemáticas básicas")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    @Operation(summary = "Adição", description = "Realiza a soma de dois números")
    public ResponseEntity<Double> add(
            @Parameter(description = "Primeiro número") @RequestParam double a,
            @Parameter(description = "Segundo número") @RequestParam double b) {
        CalculatorModel result = calculatorService.adicao(a, b);
        return ResponseEntity.ok(result.getResultado());
    }

    @GetMapping("/subtract")
    @Operation(summary = "Subtração", description = "Realiza a subtração de dois números")
    public ResponseEntity<Double> subtract(
            @Parameter(description = "Primeiro número") @RequestParam double a,
            @Parameter(description = "Segundo número") @RequestParam double b) {
        CalculatorModel result = calculatorService.subtracao(a, b);
        return ResponseEntity.ok(result.getResultado());
    }

    @GetMapping("/multiply")
    @Operation(summary = "Multiplicação", description = "Realiza a multiplicação de dois números")
    public ResponseEntity<Double> multiply(
            @Parameter(description = "Primeiro número") @RequestParam double a,
            @Parameter(description = "Segundo número") @RequestParam double b) {
        CalculatorModel result = calculatorService.multiplicacao(a, b);
        return ResponseEntity.ok(result.getResultado());
    }

    @GetMapping("/divide")
    @Operation(summary = "Divisão", description = "Realiza a divisão de dois números")
    public ResponseEntity<?> divide(
            @Parameter(description = "Dividendo") @RequestParam double a,
            @Parameter(description = "Divisor") @RequestParam double b) {
        try {
            CalculatorModel result = calculatorService.divisao(a, b);
            return ResponseEntity.ok(result.getResultado());
        } catch (ArithmeticException e) {
            ErrorResponse error = new ErrorResponse("DIVISION_BY_ZERO", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
