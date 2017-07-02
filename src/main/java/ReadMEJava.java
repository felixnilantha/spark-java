import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class ReadMEJava {

	@SuppressWarnings("serial")
	public static void main(String[] args) {

		boolean javaVersion = false;
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile("/Users/sooriyasilva/Documents/spark-2.1.1-bin-hadoop2.7/README.md");
		JavaRDD<String> pythonLines;	
	
		// Java 7 example
		if (javaVersion == true) {
			pythonLines = lines.filter(
					new Function<String, Boolean>() {
						@Override
						public Boolean call(String line) throws Exception {
							return line.contains("Spark");
						}
					}
			);
		} else {
			// Java 8 lambda
			pythonLines = lines.filter(line -> line.contains("Python"));
		}
		System.out.println(pythonLines.first());
		sc.close();
	}
	
}