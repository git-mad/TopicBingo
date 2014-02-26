package org.gitmad.topicbingo.view;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.gitmad.topicbingo.R;
import org.gitmad.topicbingo.TopicBingoApplication;
import org.gitmad.topicbingo.model.DataModel;

public class PlayActivity extends Activity {

	private ListView mTopicsList;
	private TextView mMaxView;
    private DataModel model;
	private int mNumTopics;

	private OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int position,
				long id) {
			TextView titleView = (TextView) v.findViewById(R.id.titleView);
	        mMaxView.setText(getString(R.string.max, position + 1, mNumTopics));
	    	Toast.makeText(PlayActivity.this, titleView.getText().toString(),
	    			Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
        model = ((TopicBingoApplication)getApplication()).getModel();
        mMaxView = (TextView) findViewById(R.id.max_textview);
        mNumTopics = model.getCurrentTopics().size();
        mMaxView.setText(getString(R.string.max, 0, mNumTopics));
		mTopicsList = (ListView) findViewById(R.id.topics_list);
		mTopicsList.setAdapter(new TopicArrayAdapter(this,
      	        model.getCurrentTopics()));
		mTopicsList.setOnItemClickListener(onItemClickListener);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
