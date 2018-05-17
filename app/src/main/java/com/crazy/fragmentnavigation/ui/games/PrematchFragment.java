package com.crazy.fragmentnavigation.ui.games;

import android.view.View;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

import androidx.navigation.Navigation;

/**
 * @author Mike
 */

public class PrematchFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_prematch;
    }

    @Override
    protected int getColorRes() {
        return R.color.teal_100;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.next_action);
    }
}
