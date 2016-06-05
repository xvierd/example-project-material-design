package example.yahve.edu.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.yahve.edu.tipcalc.R;
import example.yahve.edu.tipcalc.models.TipRecord;

/**
 * Created by xavier on 04/06/16.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TipRecord> dataSet;
    private OnItemClickListener onItemClickListener;

    public TipAdapter(Context context,ArrayList<TipRecord> dataSet) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element = dataSet.get(position);
        String strTip = String.format(
                                context.getString(R.string.global_message_tip),element.getTip());
        holder.textContent.setText(strTip);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void add (TipRecord record){
        dataSet.add(0,record);
        notifyDataSetChanged();
    }

    public void clear(){
        dataSet.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.textContent)
        TextView textContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
