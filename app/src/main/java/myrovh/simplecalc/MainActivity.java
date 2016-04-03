package myrovh.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Logic
    When a operation button is pressed they remain pressed. When a character is entered into a text field the result is calculated using whatever operation is pressed. If no operation buttons are pressed then nothing will be calculated. Currently their is a bug where a backspace is not registered as a keypress and so the result display will not update when backspacing a number field.
     */

    public void OperationButtonPressed(View v) {
        Button pressedButton = (Button) findViewById(v.getId());
        Button sumButton = (Button) findViewById(R.id.sumButton);
        Button subtractButton = (Button) findViewById(R.id.subtractButton);
        Button divideButton = (Button) findViewById(R.id.divideButton);
        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);

        calc.setCurrentOperation(pressedButton != null ? pressedButton.getText().charAt(0) : 'n');

        //Reactivate all buttons then disable the touched one
        if (sumButton != null) {
            sumButton.setEnabled(true);
        }
        if (subtractButton != null) {
            subtractButton.setEnabled(true);
        }
        if (divideButton != null) {
            divideButton.setEnabled(true);
        }
        if (multiplyButton != null) {
            multiplyButton.setEnabled(true);
        }
        if (pressedButton != null) {
            pressedButton.setEnabled(false);
        }

        UpdateResult();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //BUG onKeyUp not called when backspace key pressed on soft keyboard
        UpdateResult();
        return true;
    }

    public void UpdateResult() {
        //Called whenever a button or key is pressed and pulls in the number results and sets the result field
        TextView resultView = (TextView) findViewById(R.id.resultView);
        EditText numberOne = (EditText) findViewById(R.id.firstNumberInput);
        EditText numberTwo = (EditText) findViewById(R.id.secondNumberInput);

        //Make sure both text fields contain values before pushing the update to the calculator class
        if (!numberOne.getText().toString().matches("") && !numberTwo.getText().toString().matches("")) {

            calc.setNumberOne(Double.valueOf(numberOne.getText().toString()));
            calc.setNumberTwo(Double.valueOf(numberTwo.getText().toString()));

            //Use Decimal Formatter to set string output to use only two decimal places
            DecimalFormat formatter = new DecimalFormat(getString(R.string.decimalFormatPattern));


            resultView.setText(formatter.format(calc.calculate()));
        }
    }
}
