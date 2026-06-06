# Appium Mobile Automation Project (Physical Device)

This project contains mobile test automation scripts designed to run locally on **physical Android devices** using **Appium**, **Java**, and **UIAutomator2**.  
The framework is built with the **Page Object Model (POM)** design pattern for maintainability and scalability.

---

## 🛠️ Tech Stack & Prerequisites

- **Language:** Java 21
- **Build Tool:** Maven
- **Automation:** Appium Server & Appium Java Client
- **Driver:** UIAutomator2
- **Device:** Physical Android Device
- **Design Pattern:** Page Object Model (POM)

---

## 💻 Environment Setup

Ensure the following environment variables are configured on your system:

- `JAVA_HOME` → JDK installation path
- `ANDROID_HOME` → Android SDK installation path

---

## 📱 Install Appium Server

Install Appium globally and set up the Android driver using Node.js (v20+ recommended):

```bash
npm install -g appium
appium driver install uiautomator2
