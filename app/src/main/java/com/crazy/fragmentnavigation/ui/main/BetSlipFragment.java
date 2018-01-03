package com.crazy.fragmentnavigation.ui.main;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class BetSlipFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_bet_slip;
    }

    @Override
    protected int getColorRes() {
        return R.color.pink_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }
}
