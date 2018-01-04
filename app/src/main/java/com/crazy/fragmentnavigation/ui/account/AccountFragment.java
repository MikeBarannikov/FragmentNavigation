package com.crazy.fragmentnavigation.ui.account;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

/**
 * @author Mike
 */
public class AccountFragment extends BaseFragment {
    @Override
    public int getTitleRes() {
        return R.string.title_account;
    }

    @Override
    protected int getColorRes() {
        return R.color.dark_purple_300;
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_toolbar;
    }

    @Override
    protected void downButtonClicked() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(this);
        if (navigator != null) {
            navigator.getRouter().navigateTo(MessagesFragment.class.getSimpleName());
        }
    }
}
