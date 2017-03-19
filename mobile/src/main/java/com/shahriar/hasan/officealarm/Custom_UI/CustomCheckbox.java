package com.shahriar.hasan.officealarm.Custom_UI;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.shahriar.hasan.officealarm.Interfaces.CheckBoxListener;
import com.shahriar.hasan.officealarm.R;

/**
 * Created by USER on 3/18/2017.
 */

public class CustomCheckbox extends CheckBox {


    public CheckBoxListener checkBoxListener;

    public void setCheckBoxListener(CheckBoxListener checkBoxListener){
        this.checkBoxListener = checkBoxListener;
    }
    public CustomCheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setButtonDrawable(new StateListDrawable());
    }
    @Override
    public void setChecked(boolean t){

        if(t)
        {
            this.setText("Enabled");
            this.setBackgroundResource(R.drawable.selected_checkbox);
        }
        else
        {
            this.setText("Disabled");
            this.setBackgroundResource(R.drawable.normal_checkbox);
        }
        super.setChecked(t);
        if (checkBoxListener != null){
            checkBoxListener.onToggleClicked(this);
        }
    }
}

