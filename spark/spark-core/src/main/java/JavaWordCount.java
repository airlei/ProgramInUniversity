import   org.apache.spark.SparkConf;    
import   org.apache.spark.api.java.JavaPairRDD;    
import   org.apache.spark.api.java.JavaRDD;    
import   org.apache.spark.api.java.JavaSparkContext;    
import   org.apache.spark.api.java.function.FlatMapFunction;    
import   org.apache.spark.api.java.function.Function2;    
import   org.apache.spark.api.java.function.PairFunction;    
import   scala.Tuple2;    
import   java.util.Arrays;
import java.util.Iterator;
import   java.util.List;
import   java.util.regex.Pattern;    
public   final   class   JavaWordCount   {
    private   static   final   Pattern   SPACE   =   Pattern.compile("\t");
    public   static   void   main(String[]   args)   throws   Exception   {
        SparkConf   sparkConf   =   new   SparkConf().setMaster("local").setAppName("JavaWordCount");
        JavaSparkContext   ctx   =   new   JavaSparkContext(sparkConf);
        JavaRDD<String>   lines   =   ctx.textFile("hdfs://hadoop102:8020/myspark4/buyer_favorite1");
        JavaRDD<String>   words   =   lines.flatMap(new   FlatMapFunction<String,   String>()   {
            @Override
            public Iterator<String> call(String   s)   {
                String   word[]=s.split("\t",2);
                return (Iterator<String>) Arrays.asList(word[0]);
            }
        });
        JavaPairRDD<String,   Integer>   ones   =   words.mapToPair(new   PairFunction<String,   String,   Integer>()   {
            @Override
            public   Tuple2<String,   Integer>   call(String   s)   {
                return   new   Tuple2<String,   Integer>(s,   1);
            }
        });
        JavaPairRDD<String,   Integer>   counts   =   ones.reduceByKey(new   Function2<Integer,   Integer,   Integer>()   {
            @Override
            public   Integer   call(Integer   i1,   Integer   i2)   {
                return   i1   +   i2;
            }
        });
        List<Tuple2<String,   Integer>>   output   =   counts.collect();
        System.out.println(counts.collect());
        counts.saveAsTextFile("hdfs://hadoop102:8020/myspark4/out");
        ctx.stop();
    }
}