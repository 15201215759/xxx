package com.XuanLi.MapReduce02;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class sortMapper extends Mapper<LongWritable,Text,PairWritable,IntWritable> {

   private PairWritable pairWritable =new PairWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Counter counter = context.getCounter("MR_COUNT", "MapRecordCounter");
        counter.increment(1L);

        String[] split = value.toString().split("\t");

        pairWritable.setFirst(split[0]);
        pairWritable.setSecond(Integer.parseInt(split[1]));
        context.write(pairWritable,new IntWritable(Integer.parseInt(split[1])));
    }
}
