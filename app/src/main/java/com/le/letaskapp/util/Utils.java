package com.le.letaskapp.util;

import android.text.Html;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

public class Utils {

    public void setTextColor(AppCompatTextView textView, String value1, String value2){
        String text = "<font color=#cc0029>First Color</font> <font color=#ffcc00>Second Color</font>";
        textView.setText(Html.fromHtml(text));
    }
}
