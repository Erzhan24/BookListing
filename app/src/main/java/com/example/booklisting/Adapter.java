package com.example.booklisting;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private AdapterView.OnItemClickListener onItemClickListener;
        private List<Information> items;
        private Context context;

        public Adapter(List<Information> items, Context context) {
            this.items = items;
            this.context = context;

        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.booklist, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.itemView.setTag(items.get(position));
            final Information currentBook = items.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(currentBook.getVolumeInfo().getPreviewLink()));
                context.startActivity(bookIntent);
            }
        });

            holder.title.setText(currentBook.getVolumeInfo().getTitle());

            holder.author.setText("Written by"+currentBook.getVolumeInfo().getAuthors().toString());

            holder.date.setText(currentBook.getVolumeInfo().getPublishedDate());

            holder.pages.setText(currentBook.getVolumeInfo().getPageCount() + " pages");

            holder.ratingBar.setRating(currentBook.getVolumeInfo().getAverageRating());


            Glide.with(holder.image.getContext())
                    .load(currentBook.getVolumeInfo().getImageLinks().getSmallThumbnail().replace("http","https"))
                    .into(holder.image);

        }


        @Override
        public int getItemCount() {
            if (items != null) {
                return items.size();
            } else {
                return 0;
            }
        }

        public void clear() {
            items.clear();
            notifyDataSetChanged();
        }


        public void addAll(List<Information> items) {
            this.items = items;
            notifyDataSetChanged();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView title;
            public TextView author;
            public TextView pages;
            public TextView date;
            public ImageView image;
            public RatingBar ratingBar;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
                title = itemView.findViewById(R.id.title);
                author = itemView.findViewById(R.id.author);
                pages = itemView.findViewById(R.id.pages);
                date = itemView.findViewById(R.id.date);
                ratingBar = itemView.findViewById(R.id.rating);

            }
        }
    }
