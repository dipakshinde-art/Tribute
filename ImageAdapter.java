package org.codeextended.uploadimage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    private OnItemClickListener mListener;

    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName().toUpperCase());
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.black)
                .fit()
                .centerInside()
                .into(holder.imageView);
        holder.likesCount.setText(uploadCurrent.getmLikes());

        holder.commentsCount.setText(uploadCurrent.getMcommentsCount());

        holder.txtPost.setText(uploadCurrent.getmPost());



    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView textViewName;

        public ImageView imageView;

        //New
        public TextView likesCount;

        public TextView commentsCount;

        public ImageButton likeBtn, commentBtn;

        public TextView txtPost;
        //New End

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);

            //New
            likesCount = itemView.findViewById(R.id.likesCount);
            commentsCount = itemView.findViewById(R.id.commentsCount);
            txtPost=itemView.findViewById(R.id.txtPost);

            likeBtn=itemView.findViewById(R.id.likeBtn);
            commentBtn=itemView.findViewById(R.id.commentBtn);

            //New End

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

            likeBtn.setOnClickListener(this);
            commentBtn.setOnClickListener(this);
            commentsCount.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            if (mListener != null) {
//                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION) {
//                    mListener.onItemClick(position);
//                }
//            }

            if (v.getId() == R.id.likeBtn) {
                int position = getAdapterPosition();
               // mListener.onItemClick(position);
                mListener.onLike(position);
            }
            if (v.getId() == R.id.commentBtn) {
                int position = getAdapterPosition();
                // mListener.onItemClick(position);
                mListener.onComment(position);
            }

            if (v.getId() == R.id.commentsCount) {
                int position = getAdapterPosition();
                // mListener.onItemClick(position);
                mListener.onViewComment(position);
            }

        }



        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (item.getItemId()) {
                        case 1:
                            mListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");

            delete.setOnMenuItemClickListener(this);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
        void onLike(int position);
        void onComment(int position);
        void onViewComment(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

}


