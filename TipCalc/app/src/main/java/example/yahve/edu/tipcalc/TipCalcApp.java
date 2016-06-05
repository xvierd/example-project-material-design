package example.yahve.edu.tipcalc;

import android.app.Application;

/**
 * Created by xavier on 04/06/16.
 */
public class TipCalcApp extends Application {

    private final String ABOUT_URL = "http://www.google.com";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
