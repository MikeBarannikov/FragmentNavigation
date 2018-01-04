package com.crazy.fragmentnavigation.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.crazy.fragmentnavigation.R;
import com.crazy.fragmentnavigation.ui.account.AccountFragment;
import com.crazy.fragmentnavigation.ui.base.BackStackFragment;
import com.crazy.fragmentnavigation.ui.base.NavigatorFragment;
import com.crazy.fragmentnavigation.ui.bets.MyBetsFragment;
import com.crazy.fragmentnavigation.ui.games.GamesFragment;

import java.util.List;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;
import ru.terrakok.cicerone.commands.SystemMessage;

public class MainActivity extends AppCompatActivity {

    public static final String GAMES_TAG = "Games";
    public static final String FAV_TAG = "Fav";
    public static final String BET_SLIP_TAG = "BetSlip";
    public static final String MY_BETS_TAG = "MyBets";
    public static final String ACCOUNT_TAG = "Account";

    private Fragment mGamesFragment = NavigatorFragment.newInstance(GamesFragment.class.getSimpleName());
    private Fragment mFavFragment = NavigatorFragment.newInstance(FavFragment.class.getSimpleName());
    private Fragment mBetSlipFragment = NavigatorFragment.newInstance(BetSlipFragment.class.getSimpleName());
    private Fragment mMyBetsFragment = NavigatorFragment.newInstance(MyBetsFragment.class.getSimpleName());
    private Fragment mAccountFragment = NavigatorFragment.newInstance(AccountFragment.class.getSimpleName());

    private Cicerone<Router> mCicerone = Cicerone.create();

    private Navigator mNavigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if (command instanceof Back) {
                finish();
            } else if (command instanceof SystemMessage) {
                Toast.makeText(MainActivity.this, ((SystemMessage) command).getMessage(), Toast.LENGTH_SHORT).show();
            } else if (command instanceof Replace) {
                FragmentManager fm = getSupportFragmentManager();

                switch (((Replace) command).getScreenKey()) {
                    case GAMES_TAG:
                        fm.beginTransaction()
                                .detach(mAccountFragment)
                                .detach(mFavFragment)
                                .detach(mBetSlipFragment)
                                .detach(mMyBetsFragment)
                                .attach(mGamesFragment)
                                .commitNow();
                        break;
                    case FAV_TAG:
                        fm.beginTransaction()
                                .detach(mGamesFragment)
                                .detach(mAccountFragment)
                                .detach(mBetSlipFragment)
                                .detach(mMyBetsFragment)
                                .attach(mFavFragment)
                                .commitNow();
                        break;
                    case BET_SLIP_TAG:
                        fm.beginTransaction()
                                .detach(mGamesFragment)
                                .detach(mFavFragment)
                                .detach(mAccountFragment)
                                .detach(mMyBetsFragment)
                                .attach(mBetSlipFragment)
                                .commitNow();
                        break;
                    case MY_BETS_TAG:
                        fm.beginTransaction()
                                .detach(mAccountFragment)
                                .detach(mFavFragment)
                                .detach(mBetSlipFragment)
                                .detach(mGamesFragment)
                                .attach(mMyBetsFragment)
                                .commitNow();
                        break;
                    case ACCOUNT_TAG:
                        fm.beginTransaction()
                                .detach(mGamesFragment)
                                .detach(mFavFragment)
                                .detach(mBetSlipFragment)
                                .detach(mMyBetsFragment)
                                .attach(mAccountFragment)
                                .commitNow();
                        break;
                }
            }
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mCicerone.getRouter().replaceScreen(GAMES_TAG);
                    return true;
                case R.id.navigation_dashboard:
                    mCicerone.getRouter().replaceScreen(FAV_TAG);
                    return true;
                case R.id.navigation_notifications:
                    mCicerone.getRouter().replaceScreen(BET_SLIP_TAG);
                    return true;
                case R.id.navigation_cart:
                    mCicerone.getRouter().replaceScreen(MY_BETS_TAG);
                    return true;
                case R.id.navigation_money:
                    mCicerone.getRouter().replaceScreen(ACCOUNT_TAG);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mCicerone.getNavigatorHolder().setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        mCicerone.getNavigatorHolder().removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (!BackStackFragment.handleBackPressed(getSupportFragmentManager())) {
            mCicerone.getRouter().exit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        initContainers();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_home);
        }
    }

    private void initContainers() {
        FragmentManager fm = getSupportFragmentManager();
        mGamesFragment = fm.findFragmentByTag(GAMES_TAG);
        if (mGamesFragment == null) {
            mGamesFragment = NavigatorFragment.newInstance(GamesFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, mGamesFragment, GAMES_TAG)
                    .detach(mGamesFragment).commitNow();
        }

        mFavFragment = fm.findFragmentByTag(FAV_TAG);
        if (mFavFragment == null) {
            mFavFragment = NavigatorFragment.newInstance(FavFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, mFavFragment, FAV_TAG)
                    .detach(mFavFragment).commitNow();
        }

        mBetSlipFragment = fm.findFragmentByTag(BET_SLIP_TAG);
        if (mBetSlipFragment == null) {
            mBetSlipFragment = NavigatorFragment.newInstance(BetSlipFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, mBetSlipFragment, BET_SLIP_TAG)
                    .detach(mBetSlipFragment).commitNow();
        }

        mMyBetsFragment = fm.findFragmentByTag(MY_BETS_TAG);
        if (mMyBetsFragment == null) {
            mMyBetsFragment = NavigatorFragment.newInstance(MyBetsFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, mMyBetsFragment, MY_BETS_TAG)
                    .detach(mMyBetsFragment).commitNow();
        }

        mAccountFragment = fm.findFragmentByTag(ACCOUNT_TAG);
        if (mAccountFragment == null) {
            mAccountFragment = NavigatorFragment.newInstance(AccountFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, mAccountFragment, ACCOUNT_TAG)
                    .detach(mAccountFragment).commitNow();
        }
    }

}
