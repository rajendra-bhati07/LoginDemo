package com.it.logindemo.utils
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
object Utilility {
    private var cm: ConnectivityManager? = null
    /**
     * Method for checking network availability
     */
    fun isNetworkAvailable(context: Context): Boolean {
        try {
            cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: NetworkInfo = cm!!.getActiveNetworkInfo()!!
            // if no network is available networkInfo will be null
            // otherwise check if we are connected
            if (networkInfo != null && networkInfo.isConnected) return true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

}
