package edu.aku.wasimabbas.ehsas_evaluation.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.edittextpicker.aliazaz.EditTextPicker


fun isNetworkConnected(context: Context): Boolean {
    var result = false
    val connMgr =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connMgr.activeNetwork ?: return false
        val networkInfo = connMgr.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkInfo.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connMgr.run {
            connMgr.activeNetworkInfo?.run {
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
    }

    return result
}


fun chkValues(edx: EditTextPicker, val1: Array<Double>, context: Context) {

    edx.addTextChangedListener(object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            Toast.makeText(context, "" + s.toString(), Toast.LENGTH_SHORT).show()

            if (edx.text.toString().isNotEmpty()) {
                if (edx.text.toString().indexOf(".") != -1) {
                    for (item in val1) {
                        if (edx.text.toString().toDouble() == item)
                            edx.rangedefaultvalue = item.toFloat()
                    }
                }
            }
        }

        override fun afterTextChanged(s: Editable) {}
    })
}
