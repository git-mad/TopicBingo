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
    public TopicArrayAdapter(Context context, List<Topic> topics)
    {
        super(context, R.layout.topics_list_item, topics);
        this.topics=topics;
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        TopicHolder holder = null;
        if (row == null) {
        	LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.topics_list_item, parent, false);
            holder = new TopicHolder();
            holder.topicName = (TextView) row.findViewById(R.id.titleView);
            row.setTag(holder);
        } else {
            holder = (TopicHolder) row.getTag();
        }
        Topic topic = topics.get(position);
        holder.topicName.setText(topic.getName());
        return row;
    }

    private static class TopicHolder {
    	private TextView topicName;
    }
}
