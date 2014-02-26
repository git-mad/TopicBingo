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
import org.gitmad.topicbingo.model.Topic;

public class PlayActivity extends Activity {

	private TopicArrayAdapter mTopicsAdapter;
	private ListView mTopicsList;
	private TextView mMaxView;
    private DataModel mModel;
	private int mNumTopics;
	private int mCurrentCheckedTopicIndex;

	private OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int position,
				long id) {
			TextView titleView = (TextView) v.findViewById(R.id.titleView);
	        mMaxView.setText(getString(R.string.max, position + 1, mNumTopics));
	    	Toast.makeText(PlayActivity.this, titleView.getText().toString(),
	    			Toast.LENGTH_SHORT).show();
	    	if (mCurrentCheckedTopicIndex >= 0 && mCurrentCheckedTopicIndex < mNumTopics) {
	    		((Topic) arg0.getItemAtPosition(mCurrentCheckedTopicIndex)).setChecked(false);
	    	}
	    	((Topic) arg0.getItemAtPosition(position)).setChecked(true);
	    	mTopicsAdapter.notifyDataSetChanged();
	    	mCurrentCheckedTopicIndex = position;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
        mModel = ((TopicBingoApplication)getApplication()).getModel();
        mMaxView = (TextView) findViewById(R.id.max_textview);
        mNumTopics = mModel.getCurrentTopics().size();
        mMaxView.setText(getString(R.string.max, 0, mNumTopics));
		mTopicsList = (ListView) findViewById(R.id.topics_list);
		mTopicsAdapter = new TopicArrayAdapter(this, mModel.getCurrentTopics());
		mTopicsList.setAdapter(mTopicsAdapter);
		mTopicsList.setOnItemClickListener(onItemClickListener);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
