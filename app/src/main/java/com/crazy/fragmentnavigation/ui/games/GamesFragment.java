package com.crazy.fragmentnavigation.ui.games;

import android.support.v4.app.Fragment;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseViewPagerFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;

import java.util.Arrays;
import java.util.List;

import ru.terrakok.cicerone.Router;

/**
 * @author Mike
 */

public class GamesFragment extends BaseViewPagerFragment {
    @Override
    protected List<Fragment> getFragmentList() {
        return Arrays.asList(
                NavigatorFragment.newInstance(LiveFragment.class.getSimpleName()),
                NavigatorFragment.newInstance(PrematchFragment.class.getSimpleName()),
                NavigatorFragment.newInstance(SearchFragment.class.getSimpleName()));
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_view_pager_toolbar;
    }

    @Override
    protected Router getRouter() {
        final NavigatorFragment navigator = NavigatorFragment.findNavigator(this);
        if (navigator != null) {
            return navigator.getRouter();
        }
        return null;
    }
}
