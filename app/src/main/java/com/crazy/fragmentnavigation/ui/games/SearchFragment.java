package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class SearchFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_search;
    }

    @Override
    protected int getColorRes() {
        return R.color.yellow_100;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base;
    }

    @Override
    protected void downButtonClicked() {
    }
}
