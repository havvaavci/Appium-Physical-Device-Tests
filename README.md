# Appium Mobile Automation Framework

This repository features a robust mobile test automation framework designed for executing native and hybrid application tests locally on physical Android devices using **Java**, **Appium**, and **UIAutomator2**.

Rather than focusing on heavy structural abstractions, this project is engineered to provide high-performance execution, custom W3C gesture mechanics, and seamless device-level interactions.

---

## 🎯 Architectural Approach

This framework is intentionally designed with a **lightweight, linear structure** instead of a traditional Page Object Model (POM). This architectural choice ensures:
* **Direct Interaction:** Direct control over elements without boilerplate code layers.
* **Rapid Execution:** Lower overhead during execution and immediate troubleshooting.
* **Focused Utility:** Ideal for intensive interaction testing, complex gesture validations, and performance-centric scripts.

---

## 📱 Features & Capabilities

### 🔹 Advanced Mobile Gestures (W3C PointerInput)
Built-in custom implementations using the modern W3C Actions API for precise, human-like mobile interactions:
* **Tap & Double Tap**
* **Long Press**
* **Swipe & Fling** (Precise programmatic scrolling and rapid flick mechanics)
* **Drag and Drop**
* **Zoom In & Zoom Out** (Pinch-to-zoom gestures)

### 🌐 Hybrid & Mobile Web Automation
* Full support for context switching between Native App and WebView.
* Automation workflows for embedded web elements and native components within the same test cycle.

### 📱 Device & Keyboard Interactions
* Programmatic device locking/unlocking capabilities.
* Native notification management.
* Custom input handling for system keyboard application interactions.

### 🔹 Core Operations
* Optimized explicit/implicit waiting strategies.
* Standard element interactions (Click, SendKeys, Clear, GetText).

---

## 🧱 Project Structure

```text
src
└── test
    └── java
        └── appium
            ├── basetest      # Base test classes with driver initialization & capabilities
            ├── day01 - dayN  # Progressive test scripts organized by topic
            └── utils         # Helper utilities (W3C PointerInput gestures, waits, device actions)
pom.xml
README.md
```

---

## 🛠️ Tech Stack

* **Language:** Java 21
* **Build Tool:** Maven
* **Automation Framework:** Appium 2.x & Appium Java Client
* **Driver:** UIAutomator2
* **Test Runner:** TestNG
* **Target Environment:** Physical Android Devices

---

## 💻 Environment Setup

Ensure the following environment variables are configured on your system:

* `JAVA_HOME` → Path to your JDK installation
* `ANDROID_HOME` → Path to your Android SDK installation

**Physical Device Requirements:**
* Developer Options enabled.
* USB Debugging turned on.
* Device visible under `adb devices`.

---

## 📲 Installing Appium Server

Install Appium globally and set up the driver via Node.js (v20+ recommended):

```bash
npm install -g appium
appium driver install uiautomator2
```
