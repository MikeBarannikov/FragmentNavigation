package com.crazy.fragmentnavigation.ui.bets;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class BetFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_bet;
    }

    @Override
    protected int getColorRes() {
        return R.color.purple_500;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }
}
