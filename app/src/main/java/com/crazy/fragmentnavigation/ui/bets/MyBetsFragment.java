package com.crazy.fragmentnavigation.ui.bets;

import android.view.View;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

import androidx.navigation.Navigation;

/**
 * @author Mike
 */

public class MyBetsFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_my_bets;
    }

    @Override
    protected int getColorRes() {
        return R.color.purple_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }

    @Override
    protected void downButtonClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.next_action);
    }
}
