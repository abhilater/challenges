# Is Kafka a Database?
### Notes from an awesome keynote talk by Martin Kleppmann at Kakfka Summit 2018

# ACID

> ### Durability is achieved mostly using disk persistence and replication

![Imgur](https://i.imgur.com/4CXCZaHl.jpg)

![Imgur](https://i.imgur.com/efkXedGl.jpg)

> ### We can retry but only to an extent, research tells to use 2PC
(if any system commits all should commit, if any abort all should abort), but most datastore don't event implemenet 2PC like 
Redis or Elastic search, even for systems who do support, the performance is bad, if 1 system slow, all system becomes slow

![Imgur](https://i.imgur.com/Cec2Z3vl.png)

> ### All these systems consumes Fact(event) at their own pace, but atomicity is ensured by the Fact written to the log
the gurantee is that any event that is committed to the log will eventually be reflected to the db, cache and index, makes the
systems decoupled also as they can all proceed in their own place and ones' failure doesn't affect other

![Imgur](https://i.imgur.com/l2Kbc8Fl.png)

![Imgur](https://i.imgur.com/fSJYSDMl.png)

> ### The database here is hence atomic, even if there are crashes but still if we have written the 
first fact event, the two resulting debit and credit will eventually be applied (duplicate message in 2nd level can be deduped using eventId)
, however if the fact is not written nothing happens so we get ALL OR NOTHING

> ### Isolation - Serializable isolation, 
i.e concurrent transactions happen as if they are happening serially
![Imgur](https://i.imgur.com/BtMZN0rl.png)

Application where users can create an account claiming a unique userID, at-most one userID should exist

![Imgur](https://i.imgur.com/ngQBfI8l.png)

![Imgur](https://i.imgur.com/hD5b3myl.png)

> ### Both users send claim "Jane" event to same partition (topic partitioned by username) in 
claim topic. A stream processor will either get the event from A or B, lets say A comes first and it will check Database it will 
send register A's request, register processor will send notification to A that it is done, and error event will send notification
to B that it is taken

![Imgur](https://i.imgur.com/x2viJQel.png)

> ### So essentially we are getting serial ordering and processing as Stream processors are single 
thread for a partition and will automatically be serial and with multiple partitions we can get great throughput with Serializability

![Imgur](https://i.imgur.com/Wfuz6BOl.png)
