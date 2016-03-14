package myrovh.simplecalc;

//Calculator logic
// Holds two numbers and the functions that can operate on them
enum Operation {NONE, SUM, SUBTRACT, MULTIPLY, DIVIDE}

public class Calculator {
    float numberOne;
    float numberTwo;
    Operation currentOperation;

    // Default Getters and Setters START
    public float getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(float numberOne) {
        this.numberOne = numberOne;
    }

    public float getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(float numberTwo) {
        this.numberTwo = numberTwo;
    }

    public Calculator() {
        this.numberOne = 0;
        this.numberTwo = 0;
        this.currentOperation = Operation.NONE;
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

    public float calculate() {
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
            return 0;
        }
    }

    public float sumNumbers() {
        return numberOne + numberTwo;
    }

    public float subtractNumbers() {
        return  numberOne - numberTwo;
    }

    public float divideNumbers() {
        return numberOne / numberTwo;
    }

    public  float multiplyNumbers() {
        return numberOne * numberTwo;
    }
}
