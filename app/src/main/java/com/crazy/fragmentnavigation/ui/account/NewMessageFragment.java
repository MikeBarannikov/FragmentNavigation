package com.crazy.fragmentnavigation.ui.account;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;

/**
 * @author Mike
 */

public class NewMessageFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_new_message;
    }

    @Override
    protected int getColorRes() {
        return R.color.dark_purple_600;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }
}
