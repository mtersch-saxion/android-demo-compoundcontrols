package workshop.myrthe.tuesdayweek5.model;

import android.graphics.Color;
import android.util.Log;

public class MyColor {
    private int red, green, blue;

    public MyColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public MyColor() {
        this(0, 0, 0);
    }

    public MyColor(int colorValue) {
        this(Color.red(colorValue), Color.green(colorValue),
                Color.blue(colorValue));
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
        Log.d("MyColor", "setting blue to " + blue);
    }
}
