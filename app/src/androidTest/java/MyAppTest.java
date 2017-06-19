package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;


/**
 * Created by monica on 6/19/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MyAppTest implements EndpointsAsyncTask.OnDataDeliver {

    EndpointsAsyncTask endpointsAsyncTask;
    String Joke = null;

    @Test
    public void testAsyncTask() {

        endpointsAsyncTask = new EndpointsAsyncTask(this);
        try {
            endpointsAsyncTask.execute();
            Joke = endpointsAsyncTask.get();
            assertEquals(Joke, "Monica's Joke App :D");
            assertNotNull(Joke);


        } catch (Exception e) {

            fail(e.toString());

        }


    }


    @Override
    public void onDataDeliver(String data) {
        Joke = data;
    }
}