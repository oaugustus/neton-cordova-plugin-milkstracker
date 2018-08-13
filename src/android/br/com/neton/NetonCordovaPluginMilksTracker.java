/**
 */
package br.com.neton;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

import android.util.Log;

import java.util.Date;

public class NetonCordovaPluginMilksTracker extends CordovaPlugin {
  private static final String TAG = "NetonCordovaPluginMilksTracker";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing NetonCordovaPluginMilksTracker");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("start")) {
      ComponentName componentName = new ComponentName("br.com.milksrota.tracker","br.com.milksrota.tracker.TrackingService");
      Intent intent = new Intent();
      intent.setComponent(componentName);

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        startForegroundService(intent);
      } else {
        startService(intent);
      }

    } else if(action.equals("stop")) {
      ComponentName componentName = new ComponentName("br.com.milksrota.tracker","br.com.milksrota.tracker.TrackingService");
      Intent intent = new Intent();
      intent.setComponent(componentName);

      stopService(intent);
    }
    return true;
  }

}
