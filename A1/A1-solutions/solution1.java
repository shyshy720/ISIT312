import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.io.IOUtils;

public class solution1 {
	public static void main(String[] args) throws Exception {
		String localStr_1 = args[0];
		String localStr_2 = args[1];
		String hdfsStr = args[2];

		Configuration conf = new Configuration();
		FileSystem local_1 = FileSystem.getLocal(conf);
		FileSystem hdfs = FileSystem.get(URI.create(hdfsStr), conf);
		
		Path localFile_1 = new Path(localStr_1);
		Path hdfsFile = new Path(hdfsStr);

		FSDataInputStream in_1 = local_1.open(localFile_1);
		FSDataOutputStream out = hdfs.create(hdfsFile);
		
		IOUtils.copyBytes(in_1, out, 4096, false);
		IOUtils.closeStream(in_1);
		
		FileSystem local_2 = FileSystem.getLocal(conf);
		Path localFile_2 = new Path(localStr_2);
		
		FSDataInputStream in_2 = local_2.open(localFile_2);
		
		IOUtils.copyBytes(in_2, out, 4096, true);
		IOUtils.closeStream(in_2);
		out.close();
	}
}

