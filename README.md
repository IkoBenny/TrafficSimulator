# TrafficSimulator

#ProjectBackground
This section gives a brief description of project, including start date, motivation, and programming languauges used.

The Capstone Project for Computer Science at UMGC. 
A concurrent Java program written using Threads, Listeners, and Event Handlers. 
TrafficLightDescription.PDF is where interested parties may find original assignment details. 
The original project was assigned in 2020, but was never completed. 
This project was revisited for educational purposes.

#ClassesUsed
This section is a list of classes encountered during implementation.
NOTE: A class may be listed, but not used in any current development or release.

Thread, Timer, TimerTask, Instant
JSLider, JTextField, JFrame, JPanel, JLabel
Graphics, Graphics2D
Point, Point2D.Double

#ConceptsLearned
This section is a list of concepts learned needed to complete analysis, design and implementation phases.

Multi Threaded Processing
Real Time Processing
Concurrent Processing
RTSJ (Real Time Specification for Java, classes, excpetions, expectations, etc.)
Git - Fork, Commit, Push, Pull, Cherry Pick, .GitIgnore, Stable branches, Feature and Release branches.

#DesignPatterns
This section includes lessons learned about design patterns.

Monotask (single task, easy to define, wait for stimulus, then act) 
and Multitask Architectures (each task performed by different thread, resources protected by critical sections)
Monolothic (single machine, sytstem, and language) vs 
Distributed Applications 
(each unit is on different machine, each unit can execute on different system,
each program may be in a different languauge). 
Event Handling (The three approaches for performing event handling are by 
placing the event handling code in one of the below-specified places.)
Within Class,
Other Class,
Anonymous Class.
MVC Model-View-Controller
Singleton Pattern
Strategy Pattern
Enumeration
Object Serialization/Deserialization 

#OldDesignAnalysis
This section is an honest evaluation of previously submitted coursework. 
The idea is to explain shortcomings, fix issues, demonstrate learning, etc. 

1. Many implementation choices could not be verified with existing requirements. 

2. For all Swing GUI components, I opted to extend classes JPanel, JTextField, etc. and
placed the event handling code within the class.

3. Testing was completed without using a testing framework, like JUnit. 

4. I took an approach as if I was building a Monotask Architechture, instaead of Multitask Architechture.
The latter would have been a more appropiate choice.

5. I was unable to complete the project in the alloted time due to many factors:
Lack of technical skill, proper planning, attention to detail, etc. 



