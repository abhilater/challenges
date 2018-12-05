Designing data-intensive applications Notes
============================================

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
* Decouple the places where people make the most mistakes from the places where they can cause failures.  sandbox environments
* Test thoroughly at all levels, from unit tests to whole-system integration tests and manual tests and automated test for covering corner cases that rarely arise in normal operation.
* Allow quick and easy recovery from human errors, to minimize the impact in the case of a failure. For example, make it fast to roll back configuration changes,
* Set up detailed and clear monitoring, such as performance metrics and error rate


Scalability
============
Scalability is the term we use to describe a system’s ability to cope with increased load.

Excerpt From: Kleppmann, Martin. “Designing Data-Intensive Applications.” iBooks. 
> LATENCY AND RESPONSE TIME
Latency and response time are often used synonymously, but they are not the same. The response time is what the client sees: besides the actual time to process the request (the service time), it includes network delays and queueing delays. Latency is the duration that a request is waiting to be handled—during which it is latent, awaiting service

> Perhaps the slow requests are intrinsically more expensive, e.g., because they process more data. But even in a scenario where you’d think all requests should take the same time, you get variation: random additional latency could be introduced by a context switch to a background process, the loss of a network packet and TCP retransmission, a garbage collection pause, a page fault forcing a read from disk, mechanical vibrations in the server rack [18], or many other causes

> Queueing delays often account for a large part of the response time at high percentiles. As a server can only process a small number of things in parallel (limited, for example, by its number of CPU cores), it only takes a small number of slow requests to hold up the processing of subsequent requests—an effect sometimes known as head-of-line blocking. Even if those subsequent requests are fast to process on the server, the client will see a slow overall response time due to the time waiting for the prior request to complete. Due to this effect, it is important to measure response times on the client side.

> The architecture of systems that operate at large scale is usually highly specific to the application—there is no such thing as a generic, one-size-fits-all scalable architecture (informally known as magic scaling sauce). The problem may be the volume of reads, the volume of writes, the volume of data to store, the complexity of the data, the response time requirements, the access patterns, or (usually) some mixture of all of these plus many more issues.
For example, a system that is designed to handle 100,000 requests per second, each 1 kB in size, looks very different from a system that is designed for 3 requests per minute, each 2 GB in size—even though the two systems have the same data throughput

Maintainability
================
> It is well known that the majority of the cost of software is not in its initial development, but in its ongoing maintenance—fixing bugs, keeping its systems operational, investigating failures, adapting it to new platforms, modifying it for new use cases, repaying technical debt, and adding new features

Operability
============
“Make it easy for operations teams to keep the system running smoothly.”

Simplicity
===========
“Make it easy for new engineers to understand the system, by removing as much complexity as possible from the system.”

Evolvability
=============
“Make it easy for engineers to make changes to the system in the future, adapting it for unanticipated use cases as requirements change”

Excerpt From: Kleppmann, Martin. “Designing Data-Intensive Applications.” iBooks. 




