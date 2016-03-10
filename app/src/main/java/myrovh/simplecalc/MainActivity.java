package myrovh.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Logic
    When a operation button is pressed they remain pressed. When ever a character is entered
    into a text field the result is calculated using whatever operation is pressed. If no
    operation buttons are pressed then nothing will be calculated.
     */

    public void OperationButtonPressed(View v) {
        ArrayList<View> allButtons = ((LinearLayout) findViewById(R.id.buttonContainer)).getTouchables();
        Button pressedButton = (Button) findViewById(v.getId());

        calc.setCurrentOperation(pressedButton.getText().charAt(0));

        //Get all buttons reactivate them then disable the touched one
        for (View button : allButtons) {
            button.setEnabled(true);
        }
        pressedButton.setEnabled(false);
    }

    public void UpdateResult() {
        //Called whenever a button or key is pressed and pulls in the number results and sets the result field
        TextView resultView = (TextView) findViewById(R.id.resultView);

    }
}
