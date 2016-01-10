package com.shakti.GridFrame.Pages;

import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;

/**
 * Created by stokas on 10-01-2016.
 */
public class Page {

    public static void GetPage(PageType pageType){

        switch (pageType){

            case LoginPage:
                new LoginPage(Driver.Instance);//Initializing LoginPage factory
                break;

            case HomePage:
                new HomePage(Driver.Instance);//Initializing HomePage factory
                break;

            default:
                Log.error("No such page exist.");
                break;
        }

    }

}
