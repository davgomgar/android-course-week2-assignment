package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

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
		setContentView(R.layout.activity_two);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);
		



		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ActivityTwo.this.finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
			
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
					
		}

		Log.i(TAG, "onCreate()");
		
		mCreate++;
		displayCounts();
	}

	// Lifecycle callback methods overrides

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
