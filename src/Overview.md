# Project Context: Interactive Simulation of Ecosystem Food Chains

## 1. Project Overview
This project is an interactive ecosystem simulation designed to model the interactions between producers (plants), herbivores, and carnivores.

**Core Objectives:**
* **Demonstrate Energy Flow:** Model how energy transfers across trophic levels (Plants → Herbivores → Carnivores).
* **Simulate Population Dynamics:** Observe how predator-prey relationships impact the overall stability of the ecosystem.
* **Apply OOP Principles:** Utilize Object-Oriented Programming to accurately represent living organisms, their behaviors, and their environmental interactions.

---

## 2. System Architecture & UML Design
The project uses a clear inheritance hierarchy to model the ecosystem, utilizing abstraction, encapsulation, and polymorphism.

### **Core Relationships:**
* **Inheritance:** `Plant` and `Animal` inherit from a base `Living` class. `Carnivore` and `Herbivore` inherit from the `Animal` class.
* **Aggregation:** The `World` class manages collections (Lists) of `Plant` and `Animal` objects.
* **Composition/Association:** The `Living` class contains a `Position` object to track its location in the world.

