package com.crazy.fragmentnavigation.ui.games;

import android.view.View;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

import androidx.navigation.fragment.NavHostFragment;

/**
 * @author Mike
 */

public class LiveFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_live;
    }

    @Override
    protected int getColorRes() {
        return R.color.light_blue_100;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked(View view) {
        NavHostFragment.findNavController(this).navigate(R.id.next_action);
    }
}
