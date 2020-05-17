package io.github.cs102g1j.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MyLesson;
import io.github.cs102g1j.nav.MyLessons;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
   private MyLessons listdata;

   // RecyclerView recyclerView;
   public MyListAdapter( MyLessons listdata) {
      this.listdata = listdata;
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
   {
      System.out.println( "line 28 Sch...acvity" );
      LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
      View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
      ViewHolder viewHolder = new ViewHolder( listItem);
      return viewHolder;
   }

   @Override
   public void onBindViewHolder( ViewHolder holder, int position) {
      final MyLesson myListData = listdata.getLesson( position );
      String tmp = "Line 36" + listdata.getLesson( position ).toString();
      System.out.println( tmp );
      holder.textView.setText( tmp );
      //holder.imageView.setImageResource(listdata[position].getImgId());
      holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Toast.makeText(view.getContext(),"click on item: "+ myListData.getLectureName(),Toast.LENGTH_LONG).show();
         }
      });
   }


   @Override
   public int getItemCount() {
      return listdata.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      public ImageView imageView;
      public TextView textView;
      public RelativeLayout relativeLayout;
      public ViewHolder(View itemView) {
         super(itemView);
         this.imageView = (ImageView) itemView.findViewById( R.id.imageView );
         this.textView = (TextView) itemView.findViewById(R.id.textView);
         relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
      }
   }
}
