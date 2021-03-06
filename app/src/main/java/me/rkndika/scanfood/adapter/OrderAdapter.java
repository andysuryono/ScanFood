package me.rkndika.scanfood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.rkndika.scanfood.R;
import me.rkndika.scanfood.model.TransactionItem;
import me.rkndika.scanfood.util.SessionManager;

/**
 * Created by include on 02/06/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<TransactionItem> listItem;
    private Context context;

    private SessionManager session;

    public OrderAdapter(Context applicationContext, List<TransactionItem> listItem){
        this.context = applicationContext;
        this.listItem = listItem;
        session = new SessionManager(context);
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_order, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder viewHolder, int i) {
        viewHolder.menuName.setText(listItem.get(i).getMenuName());
        viewHolder.menuJumlah.setText("Jumlah : " + listItem.get(i).getQuantity());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView menuName, menuJumlah;

        public ViewHolder(View view){
            super(view);
            menuName = (TextView) view.findViewById(R.id.menuName);
            menuJumlah = (TextView) view.findViewById(R.id.menuJumlah);
        }
    }
}
