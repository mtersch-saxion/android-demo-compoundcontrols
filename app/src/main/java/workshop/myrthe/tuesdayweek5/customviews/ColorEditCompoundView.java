package workshop.myrthe.tuesdayweek5.customviews;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import java.io.IOException;

import workshop.myrthe.tuesdayweek5.R;

public class ColorEditCompoundView extends ConstraintLayout {
    private Context context;
    private int color;
    private EditText etRed, etGreen, etBlue;

    public ColorEditCompoundView(Context context) {
        super(context);
        init(context);
    }

    public ColorEditCompoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ColorEditCompoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
//        inflater.inflate()
        inflater.inflate(R.layout.compound_edit_colorvalues, this);

        etRed = findViewById(R.id.etRed);
        etGreen = findViewById(R.id.etGreen);
        etBlue = findViewById(R.id.etBlue);
    }

    public void setColor(int color) {
        this.color = color;

        etRed.setText(String.format("%d", Color.red(color)));
        etGreen.setText("" + Color.green(color));   // Quick hack to do the same...
        etBlue.setText(String.format("%d", Color.blue(color)));
    }

    public void setColor(int red, int green, int blue) {
        if (red < 0 || red > 255 /*or other colors out of range*/) {
//            throw new Exception("Invalid color values!");
        }
        setColor(Color.rgb(red, green, blue));
    }

    public int getColor() {
        int red = 0, green = 0, blue = 0;
        try {
            red = Integer.parseInt(etRed.getText().toString());
        } catch (NumberFormatException nfe) {
            // Shout at the user
        }

        return Color.rgb(red,
                Integer.parseInt(etGreen.getText().toString()),
                Integer.parseInt(etBlue.getText().toString())
        );
    }
}
