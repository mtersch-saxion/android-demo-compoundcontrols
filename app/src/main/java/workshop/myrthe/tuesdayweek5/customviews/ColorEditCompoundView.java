package workshop.myrthe.tuesdayweek5.customviews;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import java.io.IOException;

import workshop.myrthe.tuesdayweek5.R;
import workshop.myrthe.tuesdayweek5.model.MyColor;

public class ColorEditCompoundView extends ConstraintLayout {
    private Context context;
//    private int color;
    private MyColor color;
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
        color = new MyColor();

        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
//        inflater.inflate()
        inflater.inflate(R.layout.compound_edit_colorvalues, this);

        etRed = findViewById(R.id.etRed);
        etGreen = findViewById(R.id.etGreen);
        etBlue = findViewById(R.id.etBlue);

        // Watch edit events on etBlue
        etBlue.addTextChangedListener(new TextWatcher() {

            private boolean currentlyEditing = false;
            private String oldValue;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TextWatcher test", "beforeTextChanged: " + charSequence.toString());
                oldValue = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TextWatcher test", "onTextChanged: " + charSequence.toString());

                try {
                    int blueValue = Integer.parseInt(charSequence.toString());
                    color.setBlue(blueValue);
                } catch (NumberFormatException nfe) {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TextWatcher test", "afterTextChanged: " + editable.toString());
                String newValue = editable.toString();
                int value;
                try {
                    value = Integer.parseInt(newValue);
                } catch (NumberFormatException nfe) {
                    value = -1;
                }

                if (value < 0 || value > 255 || newValue.length() == 0) {
                    if (!currentlyEditing) {
                        currentlyEditing = true;
                        editable.clear();
                        editable.append(oldValue);
                        currentlyEditing = false;
                    }
                }
            }
        });
    }
/*
    public void setColor(int color) {
        this.color.setRed(Color.red(color));
        this.color.setGreen(Color.green(color));
        this.color.setBlue(Color.blue(color));

//        this.color = color;

        etRed.setText(String.format("%d", this.color.getRed()));
        etGreen.setText("" + this.color.getGreen());   // Quick hack to do the same...
        etBlue.setText(String.format("%d", this.color.getBlue()));
    }

    public void setColor(int red, int green, int blue) {
        if (red < 0 || red > 255) {
//            throw new Exception("Invalid color values!");
        }
        setColor(Color.rgb(red, green, blue));
    }
    */
    public void setColor(MyColor newColor) {
        color = newColor;
        update();
    }

    public void update() {
        etRed.setText(String.format("%d", color.getRed()));
        etGreen.setText("" + color.getGreen());   // Quick hack to do the same...
        etBlue.setText(String.format("%d", color.getBlue()));
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
