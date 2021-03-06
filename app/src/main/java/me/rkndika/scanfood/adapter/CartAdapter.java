package me.rkndika.scanfood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.rkndika.scanfood.R;
import me.rkndika.scanfood.model.Cart;
import me.rkndika.scanfood.util.SessionManager;

/**
 * Created by include on 02/06/17.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<Cart> lisCart;
    private Context context;

    private SessionManager session;

    public CartAdapter(Context applicationContext, ArrayList<Cart> lisCart){
        this.context = applicationContext;
        this.lisCart = lisCart;
        session = new SessionManager(context);
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_cart, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder viewHolder, int i) {
        viewHolder.menuName.setText(lisCart.get(i).getMenuName());
        viewHolder.menuJumlah.setText("Jumlah : " + lisCart.get(i).getQuantity());
    }

    @Override
    public int getItemCount() {
        return lisCart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView menuName, menuJumlah;
        private ImageView btnDelete;

        public ViewHolder(View view){
            super(view);
            menuName = (TextView) view.findViewById(R.id.menuName);
            menuJumlah = (TextView) view.findViewById(R.id.menuJumlah);
            btnDelete = (ImageView) view.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisCart.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),lisCart.size());

                    //ubah session
                    session.setCart(lisCart);

                }
            });
        }
    }
}
