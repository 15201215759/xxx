package com.XuanLi.MapReduce02;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class sortReducer extends Reducer<PairWritable,IntWritable,Text,IntWritable> {


    @Override
    protected void reduce(PairWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        for (IntWritable value : values) {
            context.write(new Text(key.getFirst()),value);
        }
    }
}
