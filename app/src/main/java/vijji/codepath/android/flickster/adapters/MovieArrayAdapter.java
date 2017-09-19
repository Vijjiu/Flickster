package vijji.codepath.android.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vijji.codepath.android.flickster.R;
import vijji.codepath.android.flickster.models.Movie;

/**
 * Created by vijji on 9/18/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data item for the postiion
        Movie movie = getItem(position);

        // check to see if the existing view is being reused
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // find the image view
        ImageView ivImage = (ImageView)convertView.findViewById(R.id.ivMovieImage);
        //clear out any image from convertView -- since its being reused view
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView)convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        return convertView;
    }
}