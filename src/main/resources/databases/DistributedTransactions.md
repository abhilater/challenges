# Distributed Transactions

All the transactions properties we have seen so far work across the confines of a single database in a single machine.
What about transaction across Microservies (different services each with their own databases, database should not be shared 
between services or it breaks the goal of microservies) or Stream processing (Flows which takes in input streams and produce output streams)

![Imgur](https://i.imgur.com/toUssUal.jpg)

Usually people draw a transaction boundary around their MS (transaction would be allowed only within the service maybe using a
transactional database) for good reason because 
> ### Who will ensure Serializability across the services?
![Imgur](https://i.imgur.com/yHqliYNl.jpg)

![Imgur](https://i.imgur.com/NFvfOJpl.jpg)

> ### To ensure serializability and atomcity we would need some distributed system protocols like 
**_2PC or 3 PC or Transaction Managers_** which ensure if there are multiple services participating in a transaction either all commit or none commit

> ### We also saw that the whole idea of serializability is that the transactions appear as if they were in a total serial order
so whenever transactions conflict, somebody needs to decide which came first -in DS it makes it an **_Atomic Broadcast Problem_**
i.e the problem of getting a bunch of messages to different nodes in exactly the same order, but the issue with Atomic broadcast from
a theortical and practical perspective it is equivalent to **_Consensus_** which is pretty expensive and requires a lot of
coordination between the services, and this coordination makes the system very brittle (idea is to make services decoupled),
if 1 service is slow it will amplify over all the participant services, no one really likes usig Consensus protocols 
(very bad over WAN where latency is high, none wants Zookeeper to run across multiple Datacenters)

![Imgur](https://i.imgur.com/AUiT0C6l.jpg)

> ### So what people do is the above. 
**_Compensating transactions_** for some sort of Atomicity handled by application in some crude manner, and 
**_Apologies_**, kind of like Consistency of ACID where we validate invariants at application level later using
reconcilaition and fix jobs. So basically 

![Imgur](https://i.imgur.com/grZQnmSl.jpg)

> ### So what about Isolation
Lets say we have two services - Friends and Posts, and there is implicit causality between the Unfried and Post events

![Imgur](https://i.imgur.com/0d6Z5A5l.jpg)
![Imgur](https://i.imgur.com/0dui2jll.jpg)
![Imgur](https://i.imgur.com/hd4ZBYEl.jpg)

> ### So microservices arch kind of loses this causality info. At the moment we are building Microservices systems as pure Eventual consistency based systems.
we probably can't do Serializability because 2PC and 3PC - too brittle, so want something in between which can still capture causality
kind of ordering of events
![Imgur](https://i.imgur.com/m0seqmXl.jpg)
![Imgur](https://i.imgur.com/uOgcM4Cl.jpg)

> ### There is lot of research going on, on the area of delivering read committed, causality in transactions across 
distributed services without overhead of global coordination.
![Imgur](https://i.imgur.com/wHeoT0fl.jpg)



