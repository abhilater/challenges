Designing data-intensive applications Notes
============================================
- [Introduction](#introduction)
- [Reliability](#reliability)
  - [Human errors](#human-errors)
- [Scalability](#scalability)
- [Maintainability](#maintainability)
  - [Operability](#operability)
  - [Simplicity](#simplicity)
    - [Symptoms of Complexity](#symptoms-of-complexity)
  - [Evolvability](#evolvability)
- [Security & Compliance](#security---compliance)
- [Data Models & Query Languages](#data-models---query-languages)
  - [Data Models](#data-models)
  - [Declarative Query languages](#declarative-query-languages)
- [Storage Engines](#storage-engines)
  - [Riak Bitcask](#riak-bitcask)
  - [SSTable & LSM Trees](#sstable---lsm-trees)
    - [FTS Engine of Elastic Search/Solr](#fts-engine-of-elastic-search-solr)
    - [Bloom filters and Compaction Strategies](#bloom-filters-and-compaction-strategies)
  - [B-Tree](#b-tree)

Introduction
==============
> We call an application data-intensive if data is its primary challenge—the quantity of data, the complexity of data, or the speed at which it is changing—as opposed to compute-intensive, where CPU cycles are the bottleneck

> You will, however, develop a good intuition for what your systems are doing under the hood so that you can reason about their behavior, make good design decisions, and track down any problems that may arise

Reliability
============
System should work correctly in face of adversity 
* Hardware - RAID, Redundancy/Replicatopn
* Software faults (Chaos Monkey and FIT), 

Human errors
============
* Design systems in a way that minimizes opportunities for error. For example, well-designed abstractions, APIs, and admin interfaces make it easy to do “the right thing” and discourage “the wrong thing.”
* Decouple the places where people make the most mistakes from the places where they can cause failures. eg sandbox environments
* Test thoroughly at all levels, from unit tests to whole-system integration tests and manual tests and automated test for covering corner cases that rarely arise in normal operation.
* Allow quick and easy recovery from human errors, to minimize the impact in the case of a failure. For example, make it fast to roll back configuration changes,
* Set up detailed and clear monitoring, such as performance metrics and error rate


Scalability
============
Scalability is the term we use to describe a system’s ability to cope with increased load.

* Define load and performance quantitatively

> LATENCY AND RESPONSE TIME
Latency and response time are often used synonymously, but they are not the same. The response time is what the client sees: besides the actual time to process the request (the service time), it includes network delays and queueing delays. Latency is the duration that a request is waiting to be handled—during which it is latent, awaiting service

> Perhaps the slow requests are intrinsically more expensive, e.g., because they process more data. But even in a scenario where you’d think all requests should take the same time, you get variation: random additional latency could be introduced by a context switch to a background process, the loss of a network packet and TCP retransmission, a garbage collection pause, a page fault forcing a read from disk, mechanical vibrations in the server rack [18], or many other causes

> Queueing delays often account for a large part of the response time at high percentiles. As a server can only process a small number of things in parallel (limited, for example, by its number of CPU cores), it only takes a small number of slow requests to hold up the processing of subsequent requests—an effect sometimes known as head-of-line blocking. Even if those subsequent requests are fast to process on the server, the client will see a slow overall response time due to the time waiting for the prior request to complete. Due to this effect, it is important to measure response times on the client side.

> The architecture of systems that operate at large scale is usually highly specific to the application—there is no such thing as a generic, one-size-fits-all scalable architecture (informally known as magic scaling sauce). The problem may be the volume of reads, the volume of writes, the volume of data to store, the complexity of the data, the response time requirements, the access patterns, or (usually) some mixture of all of these plus many more issues.
For example, a system that is designed to handle 100,000 requests per second, each 1 kB in size, looks very different from a system that is designed for 3 requests per minute, each 2 GB in size—even though the two systems have the same data throughput

Demo Twitter Case Study - Page #41

Maintainability
================
> It is well known that the majority of the cost of software is not in its initial development, but in its ongoing maintenance—fixing bugs, keeping its systems operational, investigating failures, adapting it to new platforms, modifying it for new use cases, repaying technical debt, and adding new features

Operability
============
* Make it easy for operations teams to keep the system running smoothly.
* Good visibility into the system’s health, and having effective ways of managing it

Simplicity
===========
Make it easy for new engineers to understand the system, by removing as much complexity as possible from the system.
> “Good abstractions can help reduce complexity”

Symptoms of Complexity
======================
Accidental complexity - if it is not inherent in the problem that the software solves (as seen by the users) but arises only from the implementation
* Explosion of state space
* Tight coupling of modules and tangled dependencies
* Inconsistent naming and terminology
* Hacks to solve performance problems
* Special casing to workaround issues elsewhere

Best tool for removing complexity is **Abstraction** .
> For example, high-level programming languages are abstractions that hide machine code, CPU registers, and syscalls. SQL is an abstraction that hides complex on-disk and in-memory data structures, concurrent requests from other clients, and inconsistencies after crashes. Of course, when programming in a high-level language, we are still using machine code; we are just not using it directly, because the programming language abstraction saves us from having to think about it.

Evolvability
=============
Make it easy for engineers to make changes to the system in the future, adapting it for unanticipated use cases as requirements change
* Agile - framework for adapting to change - tools like TDD and Refactoring
* Most discussions of Agile techniques focus on small, local scale (a couple of source code files within the same application
* Ways to be agile on level of large data systems eg “example, how would you “refactor” Twitter’s architecture for assembling home timelines (“Describing Load”) from approach 1 to approach 2”

Security & Compliance
=====================

Data Models & Query Languages
=============================
* Most applications built - Layering one data model on top of another, different levels of abstraction
* App devs look at real world and model them as objects and data-structures and APIs to manipulate them
  * Complex apps have various intermediate levels, APIs built upon APIs
  * Each abstraction layer hides the complexity of the layers below it using a clean data model
* Storing these data using general purpose data models like JSON, XML, Tables in relational databases, graph model
* Engineers decide how to serialize these data in memory/disk/network to query/search/modify it in various ways
* Hardware engineers decide how to represet bytes as electrical currents, pulses of light, magnetic field etc

Data Models
==========================================================================

* **Document** - schema flexibility, better performance due to locality, and that for some applications it is closer to the data structures used by the application **data comes in self-contained documents and relationships between one document and another are rare**
  * If data has a document-like structure (i.e., a tree of one-to-many relationships, where typically the entire tree is loaded at once), then it’s probably a good idea to use a document model
  * The relational technique of splitting a document-like structure into multiple tables (like positions, education, and contact_info lead to cumbersome schemas and unnecessarily complicated application code.
  * Poor support for joins in document databases may or may not be a problem, depending on the application eg Analytics
  * Application code needs to do additional work to keep the denormalized data consistent
  * Joins can be emulated in application code by making multiple requests to the database, but that also moves complexity into the application and is usually slower than a join performed by specialized code inside the database
  * **Schema-on-read** is similar to dynamic (runtime) type checking in programming languages
  ```java
  if (user && user.name && !user.first_name) {
    // Documents written before Dec 8, 2013 don't have first_name
    user.first_name = user.name.split(" ")[0];} 
  ```

* **Relational** counters by providing better support for joins, and many-to-one and many-to-many relationships.
  * For highly interconnected data, the document model is awkward, the relational model is acceptable, and graph models are natural
  * **Schema-on-write** is similar to static (compile-time) type checking
  ```java
   ALTER TABLE users ADD COLUMN first_name text;
   UPDATE users SET first_name = split_part(name, ' ', 1);      -- PostgreSQL”
  ```
* **Graph** - The relational model can handle simple cases of many-to-many relationships, but as the connections within your data become more complex, it becomes more natural to start modeling your data as a graph. **targeting use cases where anything is potentially related to everything**
  * Two kinds of objects: vertices (also known as nodes or entities) and edges (also known as relationships or arcs)
  * Social graphs - vertices of peoples, edges -> people know each other
  * Road/Rail network - vertices are junctions, edges -> road/rail lines between them
  * Well-known algorithms can operate on these graphs
    * for example, car navigation systems search for the shortest path between two points in a road network, and PageRank can be used on the web graph to determine the popularity of a web page and thus its ranking in search results
  *  Not limited to such homogeneous data
     * for example Facebook maintains a single graph with many different types of vertices and edges: vertices represent people, locations, events, checkins, and comments made by users; edges indicate which people are friends with each other, which checkin happened in which location, who commented on which post, who attended which event
  * Graphs can be represented using a Relational modl
  ```java
  CREATE TABLE vertices (
    vertex_id   integer PRIMARY KEY,
    properties  json
   );

  CREATE TABLE edges (
    edge_id     integer PRIMARY KEY,
    tail_vertex integer REFERENCES vertices (vertex_id),
    head_vertex integer REFERENCES vertices (vertex_id),
    label       text,
    properties  json
   );

   CREATE INDEX edges_tails ON edges (tail_vertex);
   CREATE INDEX edges_heads ON edges (head_vertex);
  ```
  * Cypher queries (declarative graph queries) better than SQL demo **Page 117**
  
Declarative Query languages 
===========================
 * Declarative languages often lend themselves to parallel execution. Today, CPUs are getting faster by adding more cores, not by running at significantly higher clock speeds than before. Imperative code is very hard to parallelize across multiple cores and multiple machines, because it specifies instructions that must be performed in a particular order. Declarative languages have a better chance of getting faster in parallel execution because they specify only the pattern of the results, not the algorithm that is used to determine the results. The database is free to use a parallel implementation of the query language, if appropriate
 * In a web browser, using declarative CSS styling is much better than manipulating styles imperatively in JavaScript. Similarly, in databases, declarative query languages like SQL turned out to be much better than imperative query APIs
 * MapReduce is a fairly low-level programming model for distributed execution on a cluster of machines. Higher-level query languages like SQL can be implemented as a pipeline of MapReduce operations. There is nothing in SQL that constrains it to running on a single machine, and MapReduce doesn’t have a monopoly on distributed query execution
 * SQL, MapReduce, MongoDB’s aggregation pipeline, 
 * Cypher, SPARQL, and Datalog much more stuff ****Page 124**** 
 
Storage Engines
================

Riak Bitcask
==============
* Append only immutable key,val write log, deletion using tombstone
* In-memory Hashmap with key, disk offset for entry
* Segment splits on threshold breach and background compactions and segment merges
* Each segment has its own In-mem hashmap, hashmap snapshots periodically written to disk for fast recovery
* Limitations - HashMap must fit in-mem, no range scans possible strictly key value 

SSTable & LSM Trees
====================
* Only change to segment file is that key-val sequence sorted by key/ Each key appears only once in SSTable
* Adv - Merge sort during compaction with less memory available compared to file (Read line by line from S1 and S2 and write to S3)
* Instead of full key index - Sparse Index in-mem (Possible because keys are sorted - Binary search)
* 1 key for few KBs of segment - easily scanned for the key 
* Read requests need to scan over several key-value pairs in the requested range anyway, it is possible to group those records into a block and compress it before writing it to disk. Sparse in-memory index then points at the start of a compressed block. Besides saving disk space, compression also reduces the I/O bandwidth use
* Sorted order kv pairs possible due to **Memtable** ds like RB Trees/AVL Trees(insert keys in any order, read them in sorted)
* Memtable few MBs flush to SST
* CommitLog for crash recovery, once memtable -> SST, commit log segment can be discarded
* LevelDB with Riak, RocksDB, Cassandra and HBase all follow this
* Disk writes are sequential the LSM-tree can support remarkably high write throughput

![Imgur](https://i.imgur.com/sc59857l.png)

FTS Engine of Elastic Search/Solr
==================================
* Same principle as LST Tree, document tokenized to terms
* kv structure where key is term and value is list of document ids (Postings list)
* Mapping from term to Postings list is stored in SSTable like sorted files

Bloom filters and Compaction Strategies
========================================
* LSM trees slow when looking up keys that do not exist in SSTable
* Bloom filter memort optimized prob ds - false positive 1-2%
* Size-tiered and leveled compaction. LevelDB and RocksDB use leveled compaction, HBase uses size-tiered, and Cassandra supports both
* Size-tiered compaction, newer and smaller SSTables are successively merged into older and larger SSTables (50% disk free)
* In leveled compaction, the key range is split up into smaller SSTables and older data is moved into separate “levels,” which allows the compaction to proceed more incrementally and use less disk space

B-Tree
========
* LSM breaks db down into variable sized several MBs segments, by contrast B-Trees break it down to **fixed-size 4KB block/page**
* Each page identified by a ref/location (linked list in disk), **tree of pages**
* One page is designated as the root of the B-tree; whenever you want to look up a key in the index, you start here. The page contains several keys and references to child pages. Each child is responsible for a continuous range of keys
* The number of ref child pages in 1 page - **Branching factor of B-Tree**
* In practice, the branching factor depends on the amount of space required to store the page references and the range boundaries, but typically it is several hundred.
* If you want to update the value for an existing key in a B-tree, you search for the leaf page containing that key, change the value in that page, and write the page back to disk (any references to that page remain valid). If you want to add a new key, you need to find the page whose range encompasses the new key and add it to that page. If there isn’t enough free “space in the page to accommodate the new key, it is split into two half-full pages, and the parent page is updated to account for the new subdivision of key ranges
* **A four-level tree of 4 KB pages with a branching factor of 500 can store up to 256 TB
![Imgur](https://i.imgur.com/8TrnxgHl.png)
![Imgur](https://i.imgur.com/9f3b6Opl.png)
