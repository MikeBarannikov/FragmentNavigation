package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class GameFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_game;
    }

    @Override
    protected int getColorRes() {
        return R.color.light_blue_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }
}
