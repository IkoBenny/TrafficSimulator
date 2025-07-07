# 🚦 TrafficSimulator

<details>
<summary>Project Background</summary>

An extension of the original TrafficSimulator Capstone Project for the Computer Science program at UMGC.

This version introduces a modular, builder-based architecture that allows users to dynamically create and simulate traffic elements such as cars and traffic lights. Built in Java using Threads, Listeners, and Event Handlers, this simulator offers a scrollable, interactive GUI and real-time processing of traffic behaviors.

</details>

<details>
<summary>Project Status</summary>

This project is in active maintenance and feature expansion. The original Capstone requirements have been met (see `TrafficLightDescription.PDF`), and this updated version adds builder tools, improved concurrency, and a more robust simulation engine.

</details>

<details>
<summary>Planned Changes</summary>

* Update landing view to display current time on load
* Add Dark Mode UI support
* Add in-context help and documentation overlays
* Display more components simultaneously in simulation panel
* Fix TrafficLight bug (stops only being visually updated)
* Add clean application shutdown on STOP press
* Improve scroll pane behavior for large simulations
* Enable real-time editing of simulation objects
* Add object save/load and reset simulation state

</details>

<details>
<summary>Design Patterns Explored</summary>

* **Builder Pattern** – For dynamically constructing simulation objects
* **Command Pattern** – Executes build actions for lights/cars
* **Mediator Pattern** – Coordinates updates between model, view, and controller
* **Strategy Pattern** – Encapsulates update logic for Cars and Lights
* **MVC Pattern** – Separates core logic, GUI, and state

</details>

<details>
<summary>Concepts Explored</summary>

**Processing**

* Concurrent & Multi-threaded object simulation
* Scheduled updates and ticking using real-time logic
* Real-time GUI updates and event-driven processing

**Architecture**

* Modular and scalable simulation design
* Command-driven object creation system
* Scrollable pane for navigating simulation objects
* Clean separation of simulation, control logic, and rendering

</details>

---

## 📦 Package Structure

* **`builder`** – BuildCars, BuildLights, and other object builders
* **`interfaces`** – Shared API contracts like `ViewBuilderInterface`
* **`sim`** – Core simulation logic including scrollable view handling
* **`wrappers`** – Time, state, and GUI update wrappers

---

## 🧠 Notable Classes

* `Main.java` – Application entry point
* `SimulationAlgorithm.java` – Core simulation loop
* `Controller.java` – Orchestrates model-view interactions
* `Scheduler.java` – Coordinates updates per simulation tick
* `Car.java` / `TrafficLight.java` – Main simulation entities
* `CarView.java` / `LightView.java` – GUI representations
* `BuildCars.java` / `BuildLights.java` – Command-based creation
* `Constants.java` – GUI labels and string constants
* `Mediator.java` – Facilitates communication across components

---

## 🚀 Getting Started

### Requirements

* Java 8+
* Desktop environment (GUI required)
* Optional: Notepad++ or other editor for Git commit customization

### Run Instructions

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

## 📄 License

MIT License. See `LICENSE` for details.

---

Would you like me to generate this as a Markdown file (`README.md`) ready to copy/paste into GitHub, or include badges and screenshot placeholders?








