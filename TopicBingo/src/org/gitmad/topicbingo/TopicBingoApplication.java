package org.gitmad.topicbingo;

import android.app.Application;
import android.preference.PreferenceManager;
import org.gitmad.topicbingo.model.DataModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Alex on 2/24/14.
 */
public class TopicBingoApplication extends Application
{
	public static final String SAVED_TOPICS
			= "org.gitmad.topicsbingo.TopicBingoApplication.SAVED_TOPICS";
    private static DataModel model;


    public DataModel getModel()
    {
        return model;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String json = PreferenceManager.getDefaultSharedPreferences(this)
				.getString(SAVED_TOPICS, "");
		Gson gson = new Gson();
		model = gson.fromJson(json, new TypeToken<DataModel>(){}.getType());
		if (model == null) {
			model = new DataModel(getResources().getStringArray(R.array.topics_array));
		}
    }
}
