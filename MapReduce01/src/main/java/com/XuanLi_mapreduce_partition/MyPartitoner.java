package com.XuanLi_mapreduce_partition;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitoner extends Partitioner<Text,NullWritable> {
    @Override
    public int getPartition(Text text, NullWritable nullWritable, int i) {
        String s = text.toString().split("\t")[5];
        if (Integer.parseInt(s)>15){
            return 0;
        }else {
            return 1;
        }
    }

}

