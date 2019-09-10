package com.crazy.fragmentnavigation.ui.games;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.base.BaseViewPagerFragment;

import java.util.Arrays;
import java.util.List;

import androidx.navigation.fragment.NavHostFragment;

/**
 * @author Mike
 */

public class GamesFragment extends BaseViewPagerFragment {
    @Override
    protected List<NavHostFragment> getFragmentList() {
        return Arrays.asList(
                NavHostFragment.create(R.navigation.live_navigation),
                NavHostFragment.create(R.navigation.prematch_navigation),
                NavHostFragment.create(R.navigation.search_navigation));
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_base_view_pager_toolbar;
    }
}
