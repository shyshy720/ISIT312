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

public class solution2 { // solution2

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "speed camera"); // Job job = Job.getInstance(conf, "speead camera");
    job.setJarByClass(solution2.class); // job.setJarByClass(solution2.class);
    job.setMapperClass(TokenizerMapper.class); // 0
    // del job.setCombinerClass(IntMinMaxReducer.class);
    job.setReducerClass(TextOverSpeedReducer.class); //job.setReducerClass(TextOverSpeedReducer.class);
    job.setOutputKeyClass(Text.class); // 0
    job.setOutputValueClass(IntWritable.class); // 0
    FileInputFormat.addInputPath(job, new Path(args[0])); // 0
    FileOutputFormat.setOutputPath(job, new Path(args[1])); // 0
    System.exit(job.waitForCompletion(true) ? 0 : 1); // 0
  }

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    //private final static IntWritable counter = new IntWritable(0); // del? string reg
    //private Text word = new Text(); // del? string date and inttweitable speed
    private Text reg = new Text();
    private Text date = new Text();
    private IntWritable speed = new IntWritable();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        reg.set(itr.nextToken()); // reg.set(itr.nextToken());
        date.set(itr.nextToken());
        speed.set(Integer.parseInt(itr.nextToken()));
        context.write(reg, speed);
      }
    }
  }

  public static class TextOverSpeedReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      int count = 0;

      for (IntWritable val : values) {
        sum = sum + val.get();
        count++;
      }

      double ave = (double) sum / count; // > 70

      if (ave > 70)
        result.set((int)ave);
        context.write(key, result);
    }
  }
}

