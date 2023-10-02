package com.cst2335.klei0075;


import android.os.Bundle;
import androidx.activity.ComponentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity1 extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastMessage = getResources().getString(R.string.hello_message);
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();

            }
        });

        Switch switchButton = findViewById(R.id.SwitchButton); // Assuming you have defined an id for the Switch in your XML layout
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String switchState = isChecked ? "on" : "off";
                String message = "The switch is now " + switchState;

                Snackbar snackbar = Snackbar.make(findViewById(R.id.linear), message, Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switchButton.setChecked(!isChecked);
                    }
                });
                snackbar.show();
            }
        });
    }

}
