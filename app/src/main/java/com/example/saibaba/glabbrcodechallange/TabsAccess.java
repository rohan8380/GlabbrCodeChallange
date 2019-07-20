package com.example.saibaba.glabbrcodechallange;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAccess extends FragmentPagerAdapter {


    public TabsAccess(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 1:
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;

            case 2:
                CallsFragment callsFragment = new CallsFragment();
                return callsFragment;

                default:
                    return null;


        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch(position)
        {
            case 0:
                return "Chats";

            case 1:
                return "Contacts";

            case 2:
                return "Calls";

            default:
                return null;


        }
    }
}
