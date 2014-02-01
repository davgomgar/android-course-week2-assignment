package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	private int mCreate;
	private int mRestart;
	private int mStart;
	private int mResume;


	private TextView mTvCreate;
	private TextView mTvStart;
	private TextView mTvResume;
	private TextView mTvRestart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvStart = (TextView) findViewById(R.id.start);



		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
				// Launch the Activity using the intent
				startActivity(intent);
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			mStart = savedInstanceState.getInt(START_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mCreate = savedInstanceState.getInt(CREATE_KEY);
		}


		Log.i(TAG, "onCreate()");
		
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();



	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "onStart()");

		mStart++;
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "onResume()");

		mResume++;
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(TAG, "onPause()");

	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(TAG, "onStop()");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG, "onRestart()");

		mRestart++;
		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "onDestroy()");


	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);

	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
