package com.forceoperationx.Fakebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RootActivity extends Activity {
	
	Facebook facebook = new Facebook("287986494596034");
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Auth
        facebook.authorize(this, new DialogListener() {
        	@Override
        	public void onComplete (Bundle values) {
        		
        	}
        	
        	@Override
        	public void onFacebookError(FacebookError error) {
        		
        	}

			@Override
			public void onError(DialogError e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	facebook.authorizeCallback(requestCode, resultCode, data);
    }
}