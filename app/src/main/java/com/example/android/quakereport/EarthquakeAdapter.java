package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doc on 05/11/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquakes> {

    public EarthquakeAdapter(Activity context, List<Earthquakes> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Create the reference to the listView
        View callingListView = convertView;
        if (callingListView == null) {
            callingListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_cell, parent, false);
        }

        // reference to the Earthquake object
        Earthquakes earthquake = getItem(position);

        // reference to the earthquake magnitude textview
        TextView magnitudeText = (TextView) callingListView.findViewById(R.id.magnitude);

        magnitudeText.setText(formatMag(earthquake.getMagnitude()));

        // reference to the place
        TextView placeText = (TextView) callingListView.findViewById(R.id.place);
        TextView distanceText = (TextView) callingListView.findViewById(R.id.distance);


        // split the place string
        String[] splitString = earthquake.getPlace().split(" of");
        if (splitString.length == 2) {
            distanceText.setText(splitString[0] + " of");
            placeText.setText(splitString[1]);
        }else{
            distanceText.setText("Near the");
            placeText.setText(splitString[0]);

        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(earthquake.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);


        // Find the TextView with view ID date
        TextView dateView = (TextView) callingListView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
       // String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(dateToDisplay);

        // Find the TextView with view ID time
        TextView timeView = (TextView) callingListView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
       // String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(dateObject);

        timeView.setText(timeToDisplay);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return callingListView;
    }

    private String formatMag(double mag){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mag);
    }

    private int getMagnitudeColor(double magnitude){

        switch ( (int)magnitude)  {
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);

            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            case 10:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
        }

    }
}

