package com.crazy.fragmentnavigation.ui.games;

import android.view.View;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

import androidx.navigation.Navigation;

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
    protected void downButtonClicked(View view) {
        if (getActivity() != null) {
            Navigation.findNavController(getActivity(), R.id.main_host_fragment).navigate(R.id.game_action);
        }
    }
}
