/**
 * This is the MyListAdapter class.
 */
package io.github.cs102g1j.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MyLesson;
import io.github.cs102g1j.nav.MyLessons;


public class MyListAdapter
   extends RecyclerView.Adapter< MyListAdapter.ExampleViewHolder >
{
   private MyLessons listdata;
   // private ArrayList< ExampleItem > mExampleList;
   private MyListAdapter.OnItemClickListener mListener;

   public interface OnItemClickListener
   {
      void onItemClick( int position );

      void onDeleteClick( int position );
   }

   public void setOnItemClickListener( MyListAdapter.OnItemClickListener listener )
   {
      mListener = listener;
   }

   public static class ExampleViewHolder extends RecyclerView.ViewHolder
   {
      public ImageView mImageView;
      public TextView mTextView1;
      public TextView mTextView2;
      public ImageView mDeleteImage;

      public ExampleViewHolder( View itemView,
                                final MyListAdapter.OnItemClickListener listener
                              )
      {
         super( itemView );
         mImageView = itemView.findViewById( R.id.imageView );
         mTextView1 = itemView.findViewById( R.id.textView );
         mTextView2 = itemView.findViewById( R.id.textView2 );
         mDeleteImage = itemView.findViewById( R.id.image_delete );
         itemView.setOnClickListener( new View.OnClickListener()
         {
            @Override
            public void onClick( View v )
            {
               if ( listener != null )
               {
                  int position = getAdapterPosition();
                  if ( position != RecyclerView.NO_POSITION )
                  {
                     listener.onItemClick( position );
                  }
               }
            }
         } );
         mDeleteImage.setOnClickListener( new View.OnClickListener()
         {
            @Override
            public void onClick( View v )
            {
               if ( listener != null )
               {
                  int position = getAdapterPosition();
                  if ( position != RecyclerView.NO_POSITION )
                  {
                     listener.onDeleteClick( position );
                  }
               }
            }
         } );
      }
   }

   public MyListAdapter( MyLessons myLessons )
   {
      listdata = myLessons;
   }

   @Override
   public MyListAdapter.ExampleViewHolder onCreateViewHolder( ViewGroup parent,
                                                              int viewType
                                                            )
   {
      View v = LayoutInflater.from( parent.getContext() )
                             .inflate( R.layout.list_item, parent, false );
      MyListAdapter.ExampleViewHolder evh = new MyListAdapter.ExampleViewHolder(
         v,
         mListener
      );
      return evh;
   }

   @Override
   public void onBindViewHolder( MyListAdapter.ExampleViewHolder holder,
                                 int position
                               )
   {
      MyLesson currentItem = listdata.get( position );
      //holder.mImageView.setImageResource( currentItem.getImageResource() );
      holder.mTextView1.setText( currentItem.getLectureName() );
      holder.mTextView2.setText( currentItem.getPlace() +
                                 " " +
                                 currentItem.getDate() );
   }

   @Override
   public int getItemCount()
   {
      return listdata.size();
   }
}
