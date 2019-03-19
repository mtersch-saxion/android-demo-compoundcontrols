package workshop.myrthe.tuesdayweek5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import workshop.myrthe.tuesdayweek5.customviews.ColorEditCompoundView;

public class MainActivity extends AppCompatActivity {

    private EditText etRedOuter, etGreenOuter, etBlueOuter;
    private TextView tvColors;
    private ColorEditCompoundView cecvColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRedOuter = findViewById(R.id.etRedOuter);
        //
        cecvColors = findViewById(R.id.cecvColors);
        cecvColors.setColor(Color.RED);

        tvColors = findViewById(R.id.etColors);
    }

    public void getColorsFromControl(View view) {
        int color = cecvColors.getColor();
        tvColors.setText(String.format("(%d, %d, %d)",
                Color.red(color),
                Color.green(color),
                Color.blue(color)
        ));
    }
}
