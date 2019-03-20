package de.auli.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private RecyclerView.ViewHolder viewHolder;
    private int i;

    public MyRecyclerViewAdapter() {
        super();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("count:", ""+i);
        List<Person> list =  MainActivity.personArrayList;

        if(list == null){
            Log.d("List ist null", "schade eigentlich");
            return;
        }
        viewHolder.itemTxtName.setText(list.get(i).getName());
        viewHolder.itemTxtCity.setText(list.get(i).getCity());
    }

    @Override
    public int getItemCount() {
        return MainActivity.personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTxtName = null;
        TextView itemTxtCity = null;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTxtName = itemView.findViewById(R.id.txt_user_name);
            itemTxtCity = itemView.findViewById(R.id.txt_user_city);
        }

    }
}
