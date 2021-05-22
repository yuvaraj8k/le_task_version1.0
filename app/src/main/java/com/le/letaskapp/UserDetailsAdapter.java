package com.le.letaskapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.le.letaskapp.model.Address;
import com.le.letaskapp.model.UserDetails;

import java.util.ArrayList;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.ViewHolder> {
    private ArrayList<UserDetails> arrayList;
    private Context context;

    public UserDetailsAdapter(ArrayList<UserDetails> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }
    @Override
    public UserDetailsAdapter.ViewHolder onCreateViewHolder ( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_list_user, parent, false);
        return new ViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder ( UserDetailsAdapter.ViewHolder holder, int position) {
        if (arrayList!=null){
            holder.tv_name.setText(arrayList.get(position).getName());
            holder.tv_phone.setText(arrayList.get(position).getPhone());
        }
        holder.cl_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Address address = arrayList.get(position).getAddress();
                Intent intent = new Intent(context, UserDetailsActivity.class);
                intent.putExtra("details", arrayList.get(position));
                intent.putExtra("address", arrayList.get(position).getAddress());
                intent.putExtra("location", arrayList.get(position).getAddress().getGeo());
                intent.putExtra("company", arrayList.get(position).getCompany());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return arrayList!=null ? arrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tv_name, tv_phone;
        ConstraintLayout cl_main;
        public ViewHolder ( View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            cl_main = itemView.findViewById(R.id.cl_main);


        }
    }
}
