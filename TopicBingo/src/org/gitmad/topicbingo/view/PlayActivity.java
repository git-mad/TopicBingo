package org.gitmad.topicbingo.view;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.gitmad.topicbingo.R;
import org.gitmad.topicbingo.TopicBingoApplication;
import org.gitmad.topicbingo.model.DataModel;

public class PlayActivity extends ListActivity {

	private ListView mTopicsList;
    private DataModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
        model = ((TopicBingoApplication)getApplication()).getModel();

		mTopicsList = (ListView) findViewById(android.R.id.list);
		mTopicsList.setAdapter(new TopicArrayAdapter(this,
      	        model.getCurrentTopics()));
    }

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    	Toast.makeText(this, ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
