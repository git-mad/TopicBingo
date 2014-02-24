package org.gitmad.topicbingo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlayActivity extends Activity {

	private ListView mTopicsList;
	private String[] mTopicsTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		mTopicsList = (ListView) findViewById(R.id.topics_list);
		mTopicsTitles = getResources().getStringArray(R.array.topics_array);
		mTopicsList.setAdapter(new ArrayAdapter<String>(this,
      	        R.layout.topics_list_item, mTopicsTitles));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
