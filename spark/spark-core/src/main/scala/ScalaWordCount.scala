import org.apache.spark.SparkConf  
import org.apache.spark.SparkContext  
object ScalaWordCount {  
      def main(args: Array[String]) {  
            val conf = new SparkConf()  
            conf.setMaster("local")  
                .setAppName("scalawordcount")  
            val sc = new SparkContext(conf)  
            val rdd = sc.textFile("hdfs://hadoop102:8020/myspark4/buyer_favorite2")
            rdd.map(line => (line.split("\t")(0), 1))  
               .reduceByKey(_ + _)  
               .collect()  
               .foreach(println)  
            sc.stop()  
        }  
}  