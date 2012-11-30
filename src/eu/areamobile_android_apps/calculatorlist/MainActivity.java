package eu.areamobile_android_apps.calculatorlist;


import java.util.ArrayList;

import eu.areamobile_android_apps.calculatorlist.R;
import eu.areamobile_android_apps.calculatorlist.CalculateFragment.OnCalculateListener;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity 
implements OnCalculateListener {

	public final static String EXTRA_FIRST_OP = "eu.areamobile.extras.FIRST_OP";
	public final static String EXTRA_SECOND_OP = "eu.areamobile.extras.SECOND_OP";
	public final static String EXTRA_OPERATION = "eu.areamobile.extras.OPERATION";


	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        CalcApplication app = (CalcApplication)getApplication();
        
        
        if (savedInstanceState==null){
			app.setItems(new ArrayList<String>());
		} 
        
    }



	@Override
	public void onCalculate() {
		
		FragmentManager m = getSupportFragmentManager();
		InputFragment fInput1 = (InputFragment)m.findFragmentById(R.id.inputFragment1);
		InputFragment fInput2 = (InputFragment)m.findFragmentById(R.id.inputFragment2);
		OperationFragment fOperation = (OperationFragment)m.findFragmentById(R.id.operationFragment);
		
		int firstOp = fInput1.getOperand();
		int secondOp = fInput2.getOperand();
		
		int operation = fOperation.getOperation();
		
		final Intent intent = new Intent(this, ResultActivity.class);
		intent.putExtra(EXTRA_FIRST_OP, firstOp);
		intent.putExtra(EXTRA_SECOND_OP, secondOp);
		intent.putExtra(EXTRA_OPERATION, operation);
		
		startActivity(intent);
	}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		
		super.onSaveInstanceState(outState);
		
//		outState.putStringArrayList(ITEMS_KEY, mTodoItems);
	}
}
