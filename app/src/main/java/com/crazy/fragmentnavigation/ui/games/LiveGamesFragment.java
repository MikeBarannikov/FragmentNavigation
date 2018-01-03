package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

/**
 * @author Mike
 */

public class LiveGamesFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_live_games;
    }

    @Override
    protected int getColorRes() {
        return R.color.light_blue_200;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(NavigatorFragment.findNavigator(this));
        if (navigator != null) {
            navigator.replaceFragment(new GameFragment(), true);
        }
    }
}
