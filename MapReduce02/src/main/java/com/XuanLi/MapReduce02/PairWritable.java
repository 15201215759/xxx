package com.XuanLi.MapReduce02;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PairWritable implements WritableComparable<PairWritable> {
    // 组合key,第一部分是我们第一列，第二部分是我们第二列
   private String first;
   private Integer second;

    public PairWritable() {

    }

    public PairWritable(String first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "PairWritable{" +
                "first='" + first + '\'' +
                ", second=" + second +
                '}';
    }

    @Override
    public int compareTo(PairWritable o) {
        //每次比较都是调用该方法的对象与传递的参数进行比较，说白了就是第一行与第二行比较完了之后的结果与第三行比较，
        //得出来的结果再去与第四行比较，依次类推

        int s = this.first.compareTo(o.first);
        if (s!=0){
            return s;
        }else {
            int i = this.second.compareTo(o.second);
            return i;
        }

    }

    @Override
    public void write(DataOutput out) throws IOException {
    out.writeUTF(this.first);
    out.writeInt(this.second);

    }

    @Override
    public void readFields(DataInput in) throws IOException {
    this.first=in.readUTF();
    this.second=in.readInt();
    }
}
