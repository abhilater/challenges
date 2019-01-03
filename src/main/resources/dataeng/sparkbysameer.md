Spark Intro by Sameer Farooqi
================================

![Imgur](https://i.imgur.com/w4tkcJI.png)

![Imgur](https://i.imgur.com/V56GnDN.png)

Why is Spark 200 times faster
===============================

* Iterative Disk IO per MR job step vs Working memory 
![Imgur](https://i.imgur.com/8lQlcqa.png)
![Imgur](https://i.imgur.com/TAUOORu.png)
![Imgur](https://i.imgur.com/MsY3eWml.png)
![Imgur](https://i.imgur.com/dA7WMt4l.png)

RDDs
=====
* Create RDDs either by reading from a distributed storage like HDFS/Cassandra or by paralellizing a collection (impractical as the collections gets loaded in driver JVM)
* Each HDFS file block becomes an RDD partition
* By default output parition number is same after filter/map ops
* We can repartition/coalesce to remove empty partitions/get the partitions count right. Also override default number of partitions eg HDFS -> no of blocks
* All ops except Action ops are lazy (Transformation) it keeps on creating DAG metadata (this RDD depends on this RDD depends on this ..)
* When you call Action like collect, the DAG executes (collect action sends result to Driver JVM usually 1 GB)
![Imgur](https://i.imgur.com/lMCTffnl.png)
![Imgur](https://i.imgur.com/mWsZ22ql.png)

https://www.youtube.com/watch?v=7ooZ4S7Ay6Y

