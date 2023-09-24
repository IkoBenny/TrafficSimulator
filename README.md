# TrafficSimulator

<details>
<summary>Project Background</summary>
The Capstone Project for the Computer Science program at UMGC.
A concurrent Java program written using Threads, Listeners, and Event Handlers.
TrafficLightDescription.PDF is where interested parties may find additional assignment details. 
</details>

<details>
<summary>Project Status</summary>
This project has completed development.
This project was developed using Waterfall methodlogy and is currently in maintenance phase. 
</details>

<details>
<summary>Planned Changes</summary>
There are currently no planned changes for this project.  
</details>

<details>
<summary>Concepts Explored</summary>

  - Builder Pattern
  - Command Pattern
  - Singleton Pattern
  - Strategy Pattern
  - MVC Pattern
  
  - Concurrent Processing
  - Multi Threaded Processing
  - Real Time Processing
  
  - Distributed Applications
  - Monolothic Applications
    
  - Monotask Architectures
  - Multitask Architectures

  - Object Serialization/Deserialization
  - Enumeration
  - EPOCH time
  - Git
  - Real Time Specification for Java (RTSJ)

</details>

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



