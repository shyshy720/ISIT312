import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.io.IOUtils;


public class FileSystemPut {

    public static void main(String[] args) throws Exception {

        String local1Str = args[0];
        String local2Str = args[1];//?
        String hdfsStr = args[2];

        Configuration conf = new Configuration();
        FileSystem local1 = FileSystem.getLocal(conf);
        FileSystem local2 = FileSystem.getLocal(conf);
        FileSystem hdfs  = FileSystem.get(URI.create(hdfsStr), conf);

        Path local1File = new Path(local1Str);
        Path local2File = new Path(local2Str);
        Path hdfsFile = new Path(hdfsStr);

        FSDataInputStream in1 = local.open(local1File);
        FSDataInputStream in2 = local.open(local2File);
        FSDataOutputStream out = hdfs.create(hdfsFile);

        IOUtils.copyBytes(in1, out, 4096, false);
        IOUtils.copyBytes(in2, out, 4096, true);
    }
}


