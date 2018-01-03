package com.crazy.fragmentnavigation.ui.main;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class FavFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_fav;
    }

    @Override
    protected int getColorRes() {
        return R.color.amber_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }
}
