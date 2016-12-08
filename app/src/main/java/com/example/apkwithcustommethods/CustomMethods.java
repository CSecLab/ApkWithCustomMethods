package com.example.apkwithcustommethods;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.ActivityManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.hardware.Camera;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import it.saonzo.rmperm.annotations.AuxiliaryClass;
import it.saonzo.rmperm.annotations.CustomMethodClass;
import it.saonzo.rmperm.annotations.MethodPermission;

@CustomMethodClass
public class CustomMethods {

    @MethodPermission(permission = "android.permission.CHANGE_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static boolean removeNetwork(WifiManager wm, int i) {
        return false;
    }
    @MethodPermission(permission = "android.permission.CHANGE_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static boolean saveConfiguration(WifiManager wm) {
        return false;
    }

    @MethodPermission(permission = "android.permission.CHANGE_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static boolean disconnect(WifiManager wm) {
        return false;
    }

    @MethodPermission(permission = "android.permission.CHANGE_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static boolean setWifiEnabled(WifiManager wm, boolean b) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static boolean isWifiEnabled(WifiManager wm) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_WIFI_STATE", defClass ="android.net.wifi.WifiManager")
    public static WifiInfo getConnectionInfo(WifiManager wm) {
        return null;
    }

    @MethodPermission(permission = "android.permission.ACCESS_NETWORK_STATE", defClass ="android.net.ConnectivityManager")
    public static int startUsingNetworkFeature(ConnectivityManager cm, int i, String s) { return 0; }

    @MethodPermission(permission = "android.permission.ACCESS_NETWORK_STATE", defClass ="android.net.ConnectivityManager")
    public static int stopUsingNetworkFeature(ConnectivityManager cm, int i, String s) {
        return 0;
    }

    @MethodPermission(permission = "android.permission.ACCESS_NETWORK_STATE", defClass ="android.net.ConnectivityManager")
    public static NetworkInfo getNetworkInfo(ConnectivityManager cm, int type) {
        return null;
    }

    @MethodPermission(permission = "android.permission.ACCESS_NETWORK_STATE", defClass ="android.net.ConnectivityManager")
    public static NetworkInfo getActiveNetworkInfo(ConnectivityManager cm) {
        return null;
    }

    @MethodPermission(permission = "android.permission.ACCESS_NETWORK_STATE", defClass ="android.net.ConnectivityManager")
    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {return false;}

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="android.app.DownloadManager")
    public static Uri getUriForDownloadedFile(DownloadManager dm, long l) {
        return Uri.parse("");
    }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="java.net.URL")
    public static URLConnection openConnection(URL url) {
        return new FakeURLConnection(url);
    }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="java.net.InetAddress")
    public static InetAddress getByName(InetAddress ia, String s) throws UnknownHostException {
        byte[] ipAddr = new byte[]{127, 0, 0, 1};
        return InetAddress.getByAddress(ipAddr);
    }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="java.net.URLConnection")
    public static InputStream getInputStream(URLConnection u) {
        return new ByteArrayInputStream(new byte[0]);
    }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="android.app.DownloadManager")
    public static long enqueue(android.app.DownloadManager dm, android.app.DownloadManager dm2) { return 0; }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="org.apache.http.impl.client.DefaultHttpClient")
    public  static HttpResponse execute(DefaultHttpClient dhc, HttpUriRequest hur) {
        return new FakeHttpResponse();
    }

    @MethodPermission(permission = "android.permission.INTERNET", defClass ="java.net.URL")
    public static InputStream openStream(java.net.URL u) {
        return new FakeInputStream();
    }

    @MethodPermission(permission = "android.permission.GET_TASKS", defClass ="android.app.ActivityManager")
    public static List getRecentTasks(ActivityManager am, int x, int y) {
        return new ArrayList();
    }

    @MethodPermission(permission = "android.permission.GET_TASKS", defClass ="android.app.ActivityManager")
    public static List getRunningTasks(ActivityManager am, int x) {
        return new ArrayList();
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static void requestSingleUpdate(LocationManager lm, Criteria c, PendingIntent pi) { }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static boolean isProviderEnabled(LocationManager lm, String s) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static Location getLastKnownLocation(LocationManager lm, String s) {
        return new FakeLocation(s);
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static boolean addGpsStatusListener(LocationManager lm, GpsStatus.Listener listener) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static boolean addNmeaListener(LocationManager lm, GpsStatus.NmeaListener listener) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static boolean sendExtraCommand(LocationManager lm, String provider, String command, Bundle extras) {
        return false;
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.telephony.TelephonyManager")
    public static void listen(TelephonyManager tm, PhoneStateListener psl, int x) {}

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getGroupIdLevel1(TelephonyManager tm) {
        return "";
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static String getBestProvider(LocationManager lm, Criteria c, boolean b) {
        return "";
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static List getProviders(LocationManager lm, Criteria c, boolean b) { return new ArrayList(); }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static List getProviders(LocationManager lm, boolean b) {
        return new ArrayList();
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.telephony.TelephonyManager")
    public static CellLocation getCellLocation(TelephonyManager tm) {
        return new FakeCellLocation();
    }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.location.LocationManager")
    public static LocationProvider getProvider(LocationManager lm, String s) { return null; }

    @MethodPermission(permission = "android.permission.ACCESS_COARSE_LOCATION", defClass ="android.telephony.TelephonyManager")
    public static List getNeighboringCellInfo(TelephonyManager tm) { return new ArrayList(); }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getSubscriberId(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.SubscriptionManager")
    public static SubscriptionInfo getActiveSubscriptionInfoForSimSlotIndex(SubscriptionManager sm, int slotIdx) {
        return null;
    }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.SubscriptionManager")
    public static List<SubscriptionInfo> getActiveSubscriptionInfoList(SubscriptionManager sm) {
        return new ArrayList<SubscriptionInfo>();
    }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getDeviceSoftwareVersion(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getLine1Number(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getSimSerialNumber(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getVoiceMailAlphaTag(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getVoiceMailNumber(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.READ_PHONE_STATE", defClass ="android.telephony.TelephonyManager")
    public static String getDeviceId(TelephonyManager tm) { return ""; }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass ="android.accounts.AccountManager")
    public static AccountManagerFuture removeAccount(AccountManager am, Account a, AccountManagerCallback amc, Handler h) {
        return new FakeAccountManagerFuture();
    }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass ="android.accounts.AccountManager")
    public static String blockingGetAuthToken(AccountManager am, Account a, String s, boolean b) { return ""; }

    @MethodPermission(permission = "android.permission.AUTHENTICATE_ACCOUNTS", defClass ="android.accounts.AccountManager")
    public static boolean addAccountExplicitly(AccountManager am, Account a, String s, Bundle b) { return false; }

    @MethodPermission(permission = "android.permission.CAMERA", defClass ="android.hardware.Camera")
    public static Camera open(Camera c) {
        return null;
    }

    @MethodPermission(permission = "android.permission.BLUETOOTH", defClass = "android.bluetooth.BluetoothHeadset")
    public static boolean isAudioConnected(BluetoothHeadset bh, BluetoothDevice device) {
        return false;
    }

    @MethodPermission(permission = "android.permission.BLUETOOTH", defClass = "android.bluetooth.BluetoothHeadset")
    public static List<BluetoothDevice> getConnectedDevices(BluetoothHeadset bh) {
        return new ArrayList<BluetoothDevice>();
    }

    @MethodPermission(permission = "android.permission.BLUETOOTH", defClass = "android.bluetooth.BluetoothDevice")
    public static BluetoothClass getBluetoothClass(BluetoothDevice bd) {
        return null;
    }

    @MethodPermission(permission = "android.permission.BLUETOOTH", defClass = "android.bluetooth.BluetoothDevice")
    public static String getName(BluetoothDevice bd) {
        return "";
    }

    @MethodPermission(permission = "android.permission.BLUETOOTH", defClass = "android.bluetooth.BluetoothAdapter")
    public static boolean isEnabled(BluetoothAdapter ba) {
        return false;
    }

    @MethodPermission(permission = "android.permission.MODIFY_AUDIO_SETTINGS", defClass = "android.media.AudioManager")
    public static boolean isWiredHeadsetOn(AudioManager am) {
        return false;
    }

    @MethodPermission(permission = "android.permission.MODIFY_AUDIO_SETTINGS", defClass = "android.media.AudioManager")
    public static boolean isBluetoothA2dpOn(AudioManager am) {
        return false;
    }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass = "android.accounts.AccountManager")
    public static Account[] getAccountsByType(AccountManager am, String type) {
        return new Account[0];
    }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass = "android.accounts.AccountManager")
    public static Account[] getAccounts(AccountManager am) {
        return new Account[0];
    }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass = "android.accounts.AccountManager")
    public static AccountManagerFuture<Boolean> hasFeatures(AccountManager am, Account account, String[] features, AccountManagerCallback<Boolean> callback, Handler handler) {
        return new AccountManagerFuture<Boolean>() {

            @Override
            public boolean cancel(boolean b) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Boolean getResult() throws OperationCanceledException, IOException, AuthenticatorException {
                return false;
            }

            @Override
            public Boolean getResult(long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
                return false;
            }
        };
    }

    @MethodPermission(permission = "android.permission.GET_ACCOUNTS", defClass = "android.accounts.AccountManager")
    public static AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
            AccountManager am, String type, String[] features, AccountManagerCallback<Account[]> amc, Handler h) {
        return new AccountManagerFuture<Account[]>() {
            @Override
            public boolean cancel(boolean b) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Account[] getResult() throws OperationCanceledException, IOException, AuthenticatorException {
                return new Account[0];
            }

            @Override
            public Account[] getResult(long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
                return new Account[0];
            }
        };
    }

    @MethodPermission(permission = "com.android.voicemail.permission.ADD_VOICEMAIL", defClass = "android.provider.VoicemailContract$Status")
    public static Uri buildSourceUri(android.provider.VoicemailContract.Status vcs, String s) {
        return Uri.parse("https://www.example.com/");
    }

    @MethodPermission(permission = "com.android.voicemail.permission.ADD_VOICEMAIL", defClass = "android.provider.VoicemailContract$Voicemails")
    public static Uri buildSourceUri(android.provider.VoicemailContract.Voicemails vcv, String s) {
        return Uri.parse("https://www.example.com/");
    }

    @AuxiliaryClass
    public static class FakeURLConnection extends URLConnection {
        protected FakeURLConnection(URL url) {
            super(url);
        }

        @Override
        public void connect() throws IOException {
        }
    }

    @AuxiliaryClass
    public static class FakeHttpResponse implements HttpResponse {
        @Override
        public StatusLine getStatusLine() {
            return null;
        }

        @Override
        public void setStatusLine(StatusLine statusLine) {
        }

        @Override
        public void setStatusLine(ProtocolVersion protocolVersion, int i) {
        }

        @Override
        public void setStatusLine(ProtocolVersion protocolVersion, int i, String s) {
        }

        @Override
        public void setStatusCode(int i) throws IllegalStateException {
        }

        @Override
        public void setReasonPhrase(String s) throws IllegalStateException {
        }

        @Override
        public HttpEntity getEntity() {
            return null;
        }

        @Override
        public void setEntity(HttpEntity httpEntity) {
        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public void setLocale(Locale locale) {
        }

        @Override
        public ProtocolVersion getProtocolVersion() {
            return null;
        }

        @Override
        public boolean containsHeader(String s) {
            return false;
        }

        @Override
        public Header[] getHeaders(String s) {
            return new Header[0];
        }

        @Override
        public Header getFirstHeader(String s) {
            return null;
        }

        @Override
        public Header getLastHeader(String s) {
            return null;
        }

        @Override
        public Header[] getAllHeaders() {
            return new Header[0];
        }

        @Override
        public void addHeader(Header header) {
        }

        @Override
        public void addHeader(String s, String s1) {
        }

        @Override
        public void setHeader(Header header) {
        }

        @Override
        public void setHeader(String s, String s1) {
        }

        @Override
        public void setHeaders(Header[] headers) {
        }

        @Override
        public void removeHeader(Header header) {
        }

        @Override
        public void removeHeaders(String s) {
        }

        @Override
        public HeaderIterator headerIterator() {
            return null;
        }

        @Override
        public HeaderIterator headerIterator(String s) {
            return null;
        }

        @Override
        public HttpParams getParams() {
            return null;
        }

        @Override
        public void setParams(HttpParams httpParams) {
        }
    }

    @AuxiliaryClass
    public static class FakeInputStream extends InputStream {
        @Override
        public int read() throws IOException {
            return 0;
        }
    }

    @AuxiliaryClass
    public static class FakeLocation extends Location {
        public String CREATOR;

        public FakeLocation(String provider) {
            super(provider);
        }

        @Override
        public double getLatitude() {
            return 0x0;
        }

        @Override
        public void setLatitude(double latitude) {
            super.setLatitude(0x0);
        }

        @Override
        public double getLongitude() {
            return 0x0;
        }

        @Override
        public void setLongitude(double longitude) {
            super.setLongitude(0x0);
        }

        @Override
        public boolean hasSpeed() {
            return false;
        }

        @Override
        public boolean hasAltitude() {
            return false;
        }

        @Override
        public boolean hasBearing() {
            return false;
        }

        @Override
        public boolean hasAccuracy() {
            return false;
        }
    }

    @AuxiliaryClass
    public static class FakeCellLocation extends CellLocation {
    }

    @AuxiliaryClass
    public static class FakeAccountManagerFuture implements AccountManagerFuture {
        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public Object getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return null;
        }

        @Override
        public Object getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
            return null;
        }
    }

}
