package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

/**
 * @author Mike
 */

public class PrematchLocationLeaguesFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_prematch_location_leagues;
    }

    @Override
    protected int getColorRes() {
        return R.color.teal_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(this);
        if (navigator != null) {
            navigator.getRouter().navigateTo(PrematchLocationLeagueGamesFragment.class.getSimpleName());
        }
    }
}
