package org.gitmad.topicbingo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.gitmad.topicbingo.R;
import org.gitmad.topicbingo.model.Topic;


import java.util.List;

/**
 * Created by Alex on 2/24/14.
 */
public class TopicArrayAdapter extends ArrayAdapter<Topic>
{
    private final List<Topic> topics;
    private final Context context;
    private final View.OnClickListener textListener;
    public TopicArrayAdapter(Context context, List<Topic> topics, View.OnClickListener textListener)
    {
        super(context, R.layout.topics_list_item, topics);
        this.topics=topics;
        this.context=context;
        this.textListener= textListener;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.topics_list_item, parent, false);
        TextView titleView = (TextView)rowView.findViewById(R.id.titleView);
        titleView.setText(topics.get(position).getName());
        titleView.setOnClickListener(textListener);
        return rowView;
    }
}
