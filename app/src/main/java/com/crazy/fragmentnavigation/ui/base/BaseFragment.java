package com.crazy.fragmentnavigation.ui.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazy.fragmentnavigation.R;

/**
 * @author Mike
 */

public abstract class BaseFragment extends LogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(getLayout(), container, false);
        view.setBackgroundResource(getColorRes());

        final TextView tv = view.findViewById(R.id.tag);
        tv.setText(getTitleRes());

        View downButtonView = view.findViewById(R.id.downButtonView);
        downButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downButtonClicked(view);
            }
        });

        return view;
    }

    @StringRes
    public abstract int getTitleRes();

    @ColorRes
    protected abstract int getColorRes();

    @LayoutRes
    protected int getLayout() {
        return R.layout.fr_base;
    }

    protected void downButtonClicked(View view) {
    }
}
