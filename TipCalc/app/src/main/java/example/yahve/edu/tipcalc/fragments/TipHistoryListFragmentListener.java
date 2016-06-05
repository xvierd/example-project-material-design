package example.yahve.edu.tipcalc.fragments;

import example.yahve.edu.tipcalc.models.TipRecord;

/**
 * Created by xavier on 04/06/16.
 */
public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
