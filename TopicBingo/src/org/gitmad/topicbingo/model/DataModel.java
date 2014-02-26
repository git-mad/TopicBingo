package org.gitmad.topicbingo.model;

import android.content.Context;
import org.gitmad.topicbingo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex on 2/24/14.
 */
public class DataModel
{
	private static final int NUM_TOPICS = 5;
    private Context context;
    private List<Topic> allTopics;
    private List<Topic> currentTopics;

    public DataModel(Context context)
    {
        allTopics = new ArrayList<Topic>();
        currentTopics = new ArrayList<Topic>();
        this.context = context;
        loadTopics();
        randomizeTopics();
    }

    private void loadTopics()
    {
       String[] topics = context.getResources().getStringArray(R.array.topics_array);
       for(String s:topics)
           allTopics.add(new Topic(s));
    }
    public void randomizeTopics()
    {
        currentTopics.clear();
        Random random = new Random();
        while(currentTopics.size()<NUM_TOPICS)
        {
            Topic t = allTopics.get(random.nextInt(allTopics.size()));
            if(!currentTopics.contains(t))
                currentTopics.add(t);
        }
    }
    public List<Topic> getCurrentTopics()
    {
        return currentTopics;
    }
}
