package org.gitmad.topicbingo;

import android.app.Application;
import org.gitmad.topicbingo.model.DataModel;

/**
 * Created by Alex on 2/24/14.
 */
public class TopicBingoApplication extends Application
{
    private static DataModel model;


    public DataModel getModel()
    {
        return model;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        model = new DataModel(this);
    }
}
