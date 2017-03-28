package lj.recyclerviewsearchdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import lj.recyclerviewsearchdemo.R;
import lj.recyclerviewsearchdemo.holders.RvSearchDemoHolder;

/**
 * Created by lj on 3/28/2017.
 */

public class RvSearchDemoAdapter extends RecyclerView.Adapter<RvSearchDemoHolder> {
    private ArrayList<String> countries;
    private ArrayList<String> countriesCopy;
    private LayoutInflater inflater;


    public RvSearchDemoAdapter(Context context, ArrayList<String> countries) {
        this.countries = countries;
        this.countriesCopy = new ArrayList<>();
        countriesCopy.addAll(countries);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RvSearchDemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RvSearchDemoHolder(inflater.inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(RvSearchDemoHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void filter(CharSequence sequence) {
        ArrayList<String> temp = new ArrayList<>();
        if (!TextUtils.isEmpty(sequence)) {
            for (String s : countries) {
                if (s.toLowerCase().contains(sequence)) {
                    temp.add(s);
                }
            }
        } else {
            temp.addAll(countriesCopy);
        }
        countries.clear();
        countries.addAll(temp);
        notifyDataSetChanged();
        temp.clear();
    }
}
