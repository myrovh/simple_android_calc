package myrovh.simplecalc;

//Calculator logic
// Holds two numbers and the functions that can operate on them
enum Operation {NONE, SUM, SUBTRACT, MULTIPLY, DIVIDE}

public class Calculator {
    Double numberOne;
    Double numberTwo;
    Operation currentOperation;

    public Calculator() {
        this.numberOne = 0.0;
        this.numberTwo = 0.0;
        this.currentOperation = Operation.NONE;
    }

    // Default Getters and Setters START
    public Double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Double numberOne) {
        this.numberOne = numberOne;
    }

    public Double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public void setCurrentOperation(char buttonText) {
        switch (buttonText) {
            case '+': currentOperation = Operation.SUM;
                break;
            case '-': currentOperation = Operation.SUBTRACT;
                break;
            case '/': currentOperation = Operation.DIVIDE;
                break;
            case '*': currentOperation = Operation.MULTIPLY;
                break;
            default: currentOperation = Operation.NONE;
        }
    }
    // Default Getters and Setters END

    public Double calculate() {
        if(currentOperation == Operation.SUM) {
            return sumNumbers();
        }
        else if(currentOperation == Operation.SUBTRACT) {
            return subtractNumbers();
        }
        else if(currentOperation == Operation.DIVIDE) {
            return divideNumbers();
        }
        else if(currentOperation == Operation.MULTIPLY) {
            return multiplyNumbers();
        }
        else {
            return 0.0;
        }
    }

    public Double sumNumbers() {
        return numberOne + numberTwo;
    }

    public Double subtractNumbers() {
        return  numberOne - numberTwo;
    }

    public Double divideNumbers() {
        return numberOne / numberTwo;
    }

    public Double multiplyNumbers() {
        return numberOne * numberTwo;
    }
}
