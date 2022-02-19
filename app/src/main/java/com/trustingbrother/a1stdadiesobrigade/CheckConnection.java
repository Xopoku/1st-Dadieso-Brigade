package com.trustingbrother.a1stdadiesobrigade;

import android.content.Context;
import android.net.ConnectivityManager;

public class CheckConnection{
    public static boolean checkInternetConnection(Context context){
        ConnectivityManager con_manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert con_manager != null;
        return (con_manager.getActiveNetworkInfo()!= null) && con_manager.getActiveNetworkInfo().isAvailable() && con_manager.getActiveNetworkInfo().isConnected() && con_manager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

}
