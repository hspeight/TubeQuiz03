package com.tubequiz.tubequiz03;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
//import android.util.Log;

//import java.util.Map;

public class PreferencesActivity extends PreferenceActivity {

    private static final String DEBUG_TAG = "PA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        static String noLinesSelected = "None selected";

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
            SharedPreferences prefs = android.preference.PreferenceManager.getDefaultSharedPreferences(getActivity());
            prefs.registerOnSharedPreferenceChangeListener(this);

            Preference lineSummary = findPreference("lines");
            lineSummary.setSummary(prefs.getString("lines", ""));

            Preference zoneSummary = findPreference("zones");
            zoneSummary.setSummary(prefs.getString("zones", ""));
            //else
            //    evtitle.setSummary(noLinesSelected + "!!!!!!");

        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
        {
            //Log.i(DEBUG_TAG, "key is " + key);
            String prefixStr;

            //Get the current summary
            Preference pref = findPreference(key);
            //String summaryStr = (String)pref.getSummary();

            //Get the user input data

            switch (key) {
                case "lines":
                case "zones":
                    prefixStr = sharedPreferences.getString(key, "");
                    if(prefixStr.isEmpty())
                        pref.setSummary(noLinesSelected);
                    else
                        pref.setSummary(prefixStr);
                    break;
                //case "dlr":
                //prefixStr = sharedPreferences.getBoolean(key, false) + ""; //converts to string
                //Log.i(DEBUG_TAG, "prefixStr is " + prefixStr);
                //evdesc.setSummary(myEvent.get_eventinfo());
                //break;
                default:
                    //Toast.makeText(getActivity(), "Cannot be blank", Toast.LENGTH_SHORT).show();
            }

            //prefixStr = sharedPreferences.getString(key, "");



            //Update the summary with user input data
            //pref.setSummary(summaryStr.concat(": [").concat(prefixStr).concat("]"));

        }
    }

}
