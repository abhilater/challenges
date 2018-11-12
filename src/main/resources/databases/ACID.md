# ACID

![Imgur](https://i.imgur.com/JgfMupFl.jpg)

> ### Durability is mostly about fsync to disk and replication
![Imgur](https://i.imgur.com/VkZU5nzl.jpg)

> ### C is ACID is a set of transactions moving a database from one consistent state to another so that the entire database satisfies certain application specific invariants or constraints eg sum total of credits and debits should be 0

![Imgur](https://i.imgur.com/zeuHUnfl.jpg)

![Imgur](https://i.imgur.com/XwT15AJl.jpg)

![Imgur](https://i.imgur.com/QTHtUnxl.jpg)

![Imgur](https://i.imgur.com/XDyFN3Al.jpg)

![Imgur](https://i.imgur.com/HKmGlh7l.jpg)

> ### Atomicity implies multiple different objects changed in a single transaction and if any fails we abort

![Imgur](https://i.imgur.com/jGeZtj4l.jpg)

> ### Abortibility handles whole lots of edge cases

![Imgur](https://i.imgur.com/M1AcQNRl.jpg)

> ### Isolation deals with concurrency 
and how different isolation modes tweaks and tunes some locks to handle different levels of race-conditions
![Imgur](https://i.imgur.com/hvKCDB5l.jpg)

![Imgur](https://i.imgur.com/MrcsQGWl.jpg)

![Imgur](https://i.imgur.com/isGHivjl.jpg)

> ### Read committed prevets Dirty reads (reading uncommited/potentially aborted data) and Dirty writes. 
But it faces the proplem of Read Skew and also Non-repeatable read

![Imgur](https://i.imgur.com/s9iQGcDl.jpg)

![Imgur](https://i.imgur.com/yDgaADSl.jpg)

> ### Interesting a lot of databases have read committed as default set Isolation Level

![Imgur](https://i.imgur.com/1UzXKexl.jpg)

![Imgur](https://i.imgur.com/jBPYExvl.jpg)

> ### Locking repeatable read is about 2PL 
a writer lock readers and readers lock writer, a write transaction will lock rows it reads, and any read 
transaction on those rows will have to wait

> ### MVCC is keeps some versions of each row (Suffers from Write Skew)
so that they can present snapshot version of rows to a transaction based on it timestamp, and hence multiple read/write 
transactions don't have to wait on lock like 2PL

![Imgur](https://i.imgur.com/Yzk3NEcl.jpg)

![Imgur](https://i.imgur.com/cpqSVl2l.jpg)

![Imgur](https://i.imgur.com/uebLvajl.jpg)

![Imgur](https://i.imgur.com/r9A2htgl.jpg)

![Imgur](https://i.imgur.com/0XxrA0dl.jpg)

![Imgur](https://i.imgur.com/gWGNICol.jpg)

![Imgur](https://i.imgur.com/KMmpXVbl.jpg)

![Imgur](https://i.imgur.com/Jlh3E5Kl.jpg)

![Imgur](https://i.imgur.com/BSWBJDwl.jpg)

![Imgur](https://i.imgur.com/qaVxtGrl.jpg)
