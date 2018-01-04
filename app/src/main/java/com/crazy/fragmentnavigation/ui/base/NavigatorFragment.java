package com.crazy.fragmentnavigation.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.fragmentnavigation.AppDelegate;
import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.account.AccountFragment;
import com.crazy.fragmentnavigation.ui.account.MessageFragment;
import com.crazy.fragmentnavigation.ui.account.MessagesFragment;
import com.crazy.fragmentnavigation.ui.account.NewMessageFragment;
import com.crazy.fragmentnavigation.ui.bets.BetFragment;
import com.crazy.fragmentnavigation.ui.bets.MyBetsFragment;
import com.crazy.fragmentnavigation.ui.games.GameFragment;
import com.crazy.fragmentnavigation.ui.games.GamesFragment;
import com.crazy.fragmentnavigation.ui.games.LiveFragment;
import com.crazy.fragmentnavigation.ui.games.LiveGamesFragment;
import com.crazy.fragmentnavigation.ui.games.PrematchFragment;
import com.crazy.fragmentnavigation.ui.games.PrematchLocationFragment;
import com.crazy.fragmentnavigation.ui.games.PrematchLocationLeagueGamesFragment;
import com.crazy.fragmentnavigation.ui.games.PrematchLocationLeaguesFragment;
import com.crazy.fragmentnavigation.ui.games.SearchFragment;
import com.crazy.fragmentnavigation.ui.main.BetSlipFragment;
import com.crazy.fragmentnavigation.ui.main.FavFragment;
import com.crazy.fragmentnavigation.util.LocalCiceroneHolder;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import timber.log.Timber;

/**
 * @author Mike
 */

public class NavigatorFragment extends BackStackFragment {

    private String mContainerName;
    private LocalCiceroneHolder mLocalCiceroneHolder;
    private Navigator mNavigator;

    @Nullable
    public static NavigatorFragment findNavigator(@Nullable Fragment fragment) {
        if (fragment == null) {
            return null;
        }

        final Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment != null && parentFragment instanceof NavigatorFragment) {
            return (NavigatorFragment) parentFragment;
        } else {
            return findNavigator(parentFragment);
        }
    }

    public static Fragment newInstance(String name) {
        final NavigatorFragment fragment = new NavigatorFragment();
        fragment.setContainerName(name);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocalCiceroneHolder = AppDelegate.getLocalCiceroneHolder();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fr_navigator, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        final FragmentManager fm = getChildFragmentManager();
        final Fragment fragment = fm.findFragmentById(R.id.navigatorFragmentContainer);
        if (fragment == null) {
            getRouter().replaceScreen(mContainerName);
        }
    }

    private Cicerone<Router> getCicerone() {
        return mLocalCiceroneHolder.getCicerone(mContainerName);
    }

    public Router getRouter() {
        return getCicerone().getRouter();
    }

    @Override
    public void onResume() {
        super.onResume();
        getCicerone().getNavigatorHolder().setNavigator(getNavigator());
    }

    @Override
    public void onPause() {
        getCicerone().getNavigatorHolder().removeNavigator();
        super.onPause();
    }

    private Navigator getNavigator() {
        if (mNavigator == null) {
            mNavigator = new SupportAppNavigator(getActivity(), getChildFragmentManager(), R.id.navigatorFragmentContainer) {

                @Override
                protected Intent createActivityIntent(String screenKey, Object data) {
                    return null;
                }

                @Override
                protected Fragment createFragment(String screenKey, Object data) {
                    if (screenKey.equals(GamesFragment.class.getSimpleName())) {
                        return new GamesFragment();
                    } else if (screenKey.equals(FavFragment.class.getSimpleName())) {
                        return new FavFragment();
                    } else if (screenKey.equals(BetSlipFragment.class.getSimpleName())) {
                        return new BetSlipFragment();
                    } else if (screenKey.equals(MyBetsFragment.class.getSimpleName())) {
                        return new MyBetsFragment();
                    } else if (screenKey.equals(AccountFragment.class.getSimpleName())) {
                        return new AccountFragment();
                    } else if (screenKey.equals(LiveFragment.class.getSimpleName())) {
                        return new LiveFragment();
                    } else if (screenKey.equals(PrematchFragment.class.getSimpleName())) {
                        return new PrematchFragment();
                    } else if (screenKey.equals(SearchFragment.class.getSimpleName())) {
                        return new SearchFragment();
                    } else if (screenKey.equals(BetFragment.class.getSimpleName())) {
                        return new BetFragment();
                    } else if (screenKey.equals(MessagesFragment.class.getSimpleName())) {
                        return new MessagesFragment();
                    } else if (screenKey.equals(MessageFragment.class.getSimpleName())) {
                        return new MessageFragment();
                    } else if (screenKey.equals(NewMessageFragment.class.getSimpleName())) {
                        return new NewMessageFragment();
                    } else if (screenKey.equals(LiveGamesFragment.class.getSimpleName())) {
                        return new LiveGamesFragment();
                    } else if (screenKey.equals(GameFragment.class.getSimpleName())) {
                        return new GameFragment();
                    } else if (screenKey.equals(PrematchLocationFragment.class.getSimpleName())) {
                        return new PrematchLocationFragment();
                    } else if (screenKey.equals(PrematchLocationLeaguesFragment.class.getSimpleName())) {
                        return new PrematchLocationLeaguesFragment();
                    } else if (screenKey.equals(PrematchLocationLeagueGamesFragment.class.getSimpleName())) {
                        return new PrematchLocationLeagueGamesFragment();
                    }

                    return null;
                }

                @Override
                protected void exit() {
                    Timber.d("EXIT");
//                    ((RouterProvider) getActivity()).getRouter().exit();
                }
            };
        }
        return mNavigator;
    }

    public void setContainerName(String containerName) {
        mContainerName = containerName;
    }
}
