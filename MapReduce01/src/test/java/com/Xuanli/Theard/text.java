package com.Xuanli.Theard;

import org.testng.annotations.Test;

public class text  {


    @Test
    public class  text1 extends Thread{
        @Override
        public synchronized void start() {
            super.start();
        }
    }
}
