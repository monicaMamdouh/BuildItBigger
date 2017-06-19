import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;


/**
 * Created by monica on 6/19/2017.
 */

public class appTest  extends AndroidTestCase implements EndpointsAsyncTask.OnDataDeliver{

   EndpointsAsyncTask endpointsAsyncTask;
    String joke=" ";

    public void testAsyncTask() throws Exception
    {
        endpointsAsyncTask=new EndpointsAsyncTask(this);
        endpointsAsyncTask.execute();
        joke=endpointsAsyncTask.get();
        assertNotNull(joke);
    }

    @Override
    public void onDataDeliver(String data) {
        joke=data;
    }
}
