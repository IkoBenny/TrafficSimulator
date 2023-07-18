# TrafficSimulator

<details>
<summary>Project Background</summary>
The Capstone Project for Computer Science at UMGC. A concurrent Java program written using Threads, Listeners, and Event Handlers. Originally assigned in 2020, but never fully completed. This project is a complete rewrite, for educational purposes.  
TrafficLightDescription.PDF is where interested parties may find original assignment details. 
</details>

<details>
<summary>Project Status</summary>
This project is currently in development. At this moment, there is no completion date. 
</details>

<details>
<summary>Planned Changes</summary>
There are numerous changes to be made. There is no priority for completion of features.

  - Add Real Time Heads-up Display, using Graphics.
  - Support for additional cars/traffic lights.
</details>

<details>
<summary>Concepts Explored</summary>
  - Concurrent Processing
  - Distributed Applications (each unit is on different machine, each unit can execute on different system, each program may be in a different languauge)
  - Enumeration
  - EPOCH time
  - Event Handling (The three approaches for performing event handling are by placing the event handling code in one of the below-specified places.)
    - Anonymous Class.
    - Another Class
    - Within Class
  - Git - Fork, Commit, Push, Pull, Cherry Pick, .GitIgnore, Stable branches, Feature and Release branches
  - Monolothic (single machine, sytstem, and language)
  - Monotask (single task, easy to define, wait for stimulus, then act) 
  - Multitask Architectures (each task performed by different thread, resources protected by critical sections)
  - Multi Threaded Processing
  - MVC Model-View-Controller
  - Object Serialization/Deserialization 
  - Real Time Processing
  - RTSJ (Real Time Specification for Java, classes, excpetions, expectations, etc.) 
  - Singleton Pattern
  - Strategy Pattern
</details>

<details>
<summary>Code Review</summary>
This section is an honest evaluation of my previously submitted coursework. This is where I take a look at my previous approach, and 
try to explain shortcomings, fix issues, demonstrate learning, etc. 

1. Many implementation choices could not be verified with existing requirements. That is, my code may have satisfied a requirement, but provied functionality that was uncalled for. For example, the state for my previous Car design included make and model types. In the real world, in general, functionality should not be provided unless asked for explicitly by the client. There is the event that additional value may be added without explicit request i.e. error handling, validation, security, etc. 

2. For all Swing GUI components, I opted to extend classes JPanel, JTextField, etc. and
placed the event handling code within the class. I could have possibly implented using models. Swing GUI components have data models which allow a Model to be attatched to a View effortlessly. For example, JSliders use BoundedRange Models.  

3. Testing was completed without using a testing framework, like JUnit. I could always make use of a framework, such as Mockito as well.

4. I took an approach as if I was building a Monotask Architechture, instaead of a Multitask Architechture.
The latter would have been the appropiate choice, given the project requirements.

5. I was unable to complete the project in the alloted time due to many factors:
   -  Lack of technical skill
   -  Proper planning
   -  Attention to detail,  etc.

Do I think I was technically able to complete the project back then? Yes. I spent a considerable amount of time learning about Threads. However, I glossed over directions and missed where it was recommended to focus on learning before starting to write code. Furthermore, resources were wasted on features that could have been addressed at a later time. This resulted in scope creep, and ultimately ended in project failure. I was unable to deliver a fully functional, tested version of the program before the milestone date of the deliverable.  
</details>



