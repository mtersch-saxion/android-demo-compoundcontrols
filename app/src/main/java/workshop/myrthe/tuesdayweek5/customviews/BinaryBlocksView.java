package workshop.myrthe.tuesdayweek5.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BinaryBlocksView extends View {

    private int number;

    public BinaryBlocksView(Context context) {
        super(context);
    }

    public BinaryBlocksView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BinaryBlocksView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BinaryBlocksView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth(), height = getHeight();
        Log.d("BinaryBlocksView", "Width: " + width + ", height: " + height);

        float x1 = 16, x2 = width/2 - 8, x3 = x2 + 16, x4 = width - 16;
        float y1 = 16, y2 = height/2 - 8, y3 = y2 + 16, y4 = height - 16;

        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(12);
        borderPaint.setColor(Color.BLUE);

        // Top left rectangle:
        if (number == 1) {
            canvas.drawRect(x1, y1, x2, y2, redPaint);
        }
        canvas.drawRect(x3, y3, x4, y4, redPaint);

        canvas.drawRect(x1, y1, x2, y2, borderPaint);
    }

    public void setNumber(int number) {
        this.number = Math.max(Math.min(number, 15), 0);

        invalidate();
    }
}
