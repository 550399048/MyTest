package custome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.wucaiyan.mytest.R;

/**
 * Created by wucaiyan on 17-7-20.
 */

public class PasswordView extends AppCompatEditText implements TextWatcher {

    private boolean btnsVisible = false,pwdVisible = false;
    private Bitmap btnClearBm, btnVisibleBm;
    private Paint mPain;
    private int btnPadding = 12,btnSpacing = 24, btnTouchPadding = 6;
    private int invalidateLeft,invalidateTop,invalidateRight,invalidateBottom;
    private int clearWidth, clearHeight,visiWidth,visiHeight;
    private RectF clearRect,visibilityRect;

    private PasswordTransformationMethod mPasswordTransformationMethod;
    public PasswordView(Context context) {
        super(context);
        init();
    }

    public PasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init (){
        btnClearBm = BitmapFactory.decodeResource(getResources(), R.drawable.icon_delete_input);
        addTextChangedListener(this);
        float density = getResources().getDisplayMetrics().density;
        btnPadding = (int) (12 * density);
        btnSpacing = (int) (24 * density);
        btnTouchPadding = (int) (6 * density);
        
        clearWidth = btnClearBm.getWidth();
        clearHeight = btnClearBm.getHeight();
        
        decodeAndCalculateVisibilityIcon();

        mPain = new Paint(Paint.ANTI_ALIAS_FLAG);

        clearRect = new RectF();
        visibilityRect = new RectF();
        

    }

    private void decodeAndCalculateVisibilityIcon() {
        btnVisibleBm = BitmapFactory.decodeResource(getResources(),pwdVisible ? R.drawable.icon_invisible : R.drawable.icon_uninvisible);
        visiHeight = btnVisibleBm.getHeight();
        visiWidth = btnVisibleBm.getWidth();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = getWidth();
        int h = getHeight();

        float tranxX = getTranslationX();
        int scrollX = getScrollX();
        int paddingright = getPaddingRight();
        float clearLeft = w -paddingright - btnPadding -clearWidth;
        float clearTop = (h-clearHeight) * 1.0f /2;
        clearRect.set(clearLeft,clearTop,clearLeft+clearWidth,clearTop+clearHeight);

        float visiLeft = clearLeft = btnSpacing - visiWidth;
        float visiTop = (h-visiHeight) * 1.0f/2;
        visibilityRect.set(visiLeft,visiTop,visiLeft+visiWidth,visiTop+visiHeight);

        invalidateLeft = (int) (visibilityRect.left) - 1;
        invalidateTop = (int) Math.min(visibilityRect.top, clearRect.top) - 1;
        invalidateRight = (int) clearRect.right + 1;
        invalidateBottom = (int) Math.max(visibilityRect.bottom, clearRect.bottom) + 1;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (btnsVisible && event.getAction() == MotionEvent.ACTION_UP) {
            float evX = event.getX(), evY = event.getY();
            if (evX >= clearRect.left - btnTouchPadding && evX < clearRect.right + btnTouchPadding
                    && evY >= clearRect.top - btnTouchPadding && evY <= clearRect.bottom + btnTouchPadding) {
                onClearClick();
            } else if (evX >= visibilityRect.left - btnTouchPadding && evX < visibilityRect.right + btnTouchPadding
                    && evY >= visibilityRect.top - btnTouchPadding && evY <= visibilityRect.bottom + btnTouchPadding) {
                onPwVisibilityClick();
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        int len = s == null ? 0 : s.length();
        boolean oldValue = btnsVisible;
        btnsVisible = len > 0;
        if (oldValue != btnsVisible) {
            invalidate(invalidateLeft, invalidateTop, invalidateRight, invalidateBottom);
//            invalidate();
        }

    }

    private void onPwVisibilityClick() {
        pwdVisible = !pwdVisible;

        if (!pwdVisible && mPasswordTransformationMethod == null) {
            mPasswordTransformationMethod = new PasswordTransformationMethod();
        }

        setTransformationMethod(pwdVisible ? null : mPasswordTransformationMethod);
        decodeAndCalculateVisibilityIcon();
        invalidate(invalidateLeft, invalidateTop, invalidateRight, invalidateBottom);
    }

    private void onClearClick() {
        setText("");
    }


}
