import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MinMax { // solution2

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count"); // Job job = Job.getInstance(conf, "speead camera");
    job.setJarByClass(MinMax.class); // job.setJarByClass(solution2.class);
    job.setMapperClass(TokenizerMapper.class); // 0
    job.setCombinerClass(IntMinMaxReducer.class); // del
    job.setReducerClass(IntMinMaxReducer.class); //job.setReducerClass(TextOverSpeedReducer.class);
    job.setOutputKeyClass(Text.class); // 0
    job.setOutputValueClass(IntWritable.class); // 0
    FileInputFormat.addInputPath(job, new Path(args[0])); // 0
    FileOutputFormat.setOutputPath(job, new Path(args[1])); // 0
    System.exit(job.waitForCompletion(true) ? 0 : 1); // 0
  }

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable counter = new IntWritable(0); // del? dtring reg
    private Text word = new Text(); // del? string date and inttweitable speed

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken()); // reg.set(itr.nextToken());
        counter.set( Integer.parseInt(itr.nextToken()) ); // date.set(itr.nextToken());
        context.write(word, counter); // speed.set(Integer.parseInt(itr.nextToken()));
        // context.write(reg, speed)
      }
    }
  }

  public static class IntMinMaxReducer // TextOverSpeedReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
	int max = Integer.MIN_VALUE; // int sum
      int min = Integer.MAX_VALUE;  // int count & double ave > 70

      for (IntWritable val : values) {
	  if ( val.get()> max )
	      max = val.get();
          if ( val.get() < min )
              min = val.get();
      }
      result.set(max);
      context.write(key, result);
      result.set(min);
      context.write(key, result);
    }
  }
}
