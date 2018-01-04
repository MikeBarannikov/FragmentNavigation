package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

/**
 * @author Mike
 */

public class PrematchLocationLeagueGamesFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_prematch_location_league_games;
    }

    @Override
    protected int getColorRes() {
        return R.color.teal_400;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(NavigatorFragment.findNavigator(this));
        if (navigator != null) {
            navigator.getRouter().navigateTo(GameFragment.class.getSimpleName());
        }
    }
}
