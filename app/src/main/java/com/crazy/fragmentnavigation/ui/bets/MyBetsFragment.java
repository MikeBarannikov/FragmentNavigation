package com.crazy.fragmentnavigation.ui.bets;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

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
    protected void downButtonClicked() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(this);
        if (navigator != null) {
            navigator.replaceFragment(new BetFragment(), true);
        }
    }
}
