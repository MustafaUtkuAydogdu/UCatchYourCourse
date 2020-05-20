package io.github.cs102g1j.ui.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import io.github.cs102g1j.R;
import io.github.cs102g1j.nav.MyLesson;
import io.github.cs102g1j.nav.MyLessons;

/**
 * This is RecyclerView Adapter class for MyLessons objects.
 * @version 2020.05.19
 * @author Melis Atun
 * @author Muhammed Can Küçükaslan
 * @author Mustafa Yasir Altunhan
 * @author Mustafa Utku Aydoğdu
 */
public class MyListAdapter
   extends RecyclerView.Adapter< MyListAdapter.ViewHolder >
{
   private MyLessons myLessons;
   private OnItemClickListener myListener;

   // Constructor
   public MyListAdapter( MyLessons myLessons )
   {
      this.myLessons = myLessons;
   }

   // methods
   /**
   * This method is for getting the size of the object myLessons, which has a property of arrayList. Hence, when this method is called, the size of the arrayList of the object myLessons will be returned.
   */
   @Override
   public int getItemCount()
   {
      return myLessons.size();
   }

   /** 
   * This method only creates a new view holder when there are no existing view holders which the RecyleView can reuse.
   * @param parent
   * @param viewType
   */
   @Override
   public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType )
   {
      LayoutInflater
         layoutInflater
         = LayoutInflater.from( parent.getContext() );
      View listItemView = layoutInflater.inflate( R.layout.list_item,
                                                  parent,
                                                  false
                                                );
      ViewHolder viewHolder = new ViewHolder( listItemView, myListener );
      return viewHolder;
   }
   
   /**
   * This method is for getting new unused view holders and filling them with data which are desired to be displayed.
   * @param holder
   * @param position
   */
   @Override
   public void onBindViewHolder( ViewHolder holder, int position )
   {
      MyLesson myListData = myLessons.get( position );
      myListData = myLessons.get( position );
      holder.mTextView1.setText( myListData.getLecture() );
      holder.mTextView2.setText( myListData.getPlace() +
                                 ", " +
                                 myListData.getDate() );
      // image is default, no need for getting
      //holder.mImageView.setImageResource(myListData.getImageResource());
   }

   /**
   * If a user presses an Item in the list, this method will display that precise Item.
   * @param listener
   */
   public void setOnItemClickListener( OnItemClickListener listener )
   {
      myListener = listener;
   }

   // onItemClickListener interface, it has two methods in it which take position as a parameter.
   public interface OnItemClickListener
   {
      void onItemClick( int position );

      void onDeleteClick( int position );
   }

   // inner class ViewHolder
   public static class ViewHolder extends RecyclerView.ViewHolder
   {
      // Properties
      ImageView mImageView;
      TextView mTextView1;
      TextView mTextView2;
      ImageView mDeleteImage;

      // Constructor
      public ViewHolder( View itemView, final OnItemClickListener listener )
      {
         super( itemView );
         mImageView = itemView.findViewById( R.id.imageView );
         mTextView1 = itemView.findViewById( R.id.itemTextView );
         mTextView2 = itemView.findViewById( R.id.subTextView );
         mDeleteImage = itemView.findViewById( R.id.image_delete );
         itemView.setOnClickListener( new View.OnClickListener()
         {
            
            /** 
            * This method is for detecting when the user clicks a button.
            * @param v
            */
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

}
