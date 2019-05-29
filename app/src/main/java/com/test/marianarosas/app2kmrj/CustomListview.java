package com.test.marianarosas.app2kmrj;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CustomListview extends ArrayAdapter<String>{

    private ArrayList arrayList;
    private ArrayList<Integer> img;
    private Activity context;
    public CustomListview(Activity  context, ArrayList<String> arrayList) {

        super(context, R.layout.listview_layout,arrayList);

        this.context = context;
        this.arrayList=arrayList;




    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) r.getTag();
        }

        //viewHolder.ivw.setImageResource(img[position]);


            viewHolder.tv1.setText(arrayList.get(position).toString());


        return r;

        // return super.getView(position, convertView, parent);
    }

    class ViewHolder{
        TextView  tv1;

        ImageView ivw;
        ViewHolder( View view){

            tv1= view.findViewById(R.id.textView3);


        }
    }
}


