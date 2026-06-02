# NexSense - IoT Environment Monitoring & Control System

## Overview

NexSense is a complete IoT-based Smart Environment Monitoring and Control System built using ESP32, Firebase Realtime Database, a responsive Web Dashboard, and an Android Application.

The system continuously monitors environmental conditions such as Temperature, Humidity, and Gas Concentration in real time. Sensor data is transmitted from ESP32 to Firebase and instantly displayed on both the web dashboard and Android application.

In addition to monitoring, NexSense provides remote control capabilities for connected devices such as Air Conditioners and Fans through Manual and Automatic operating modes.

---

## Features

### Real-Time Monitoring

* Live Temperature Monitoring
* Live Humidity Monitoring
* Live Gas Level Monitoring
* Automatic Sensor Status Detection
* Real-Time Firebase Synchronization

### Device Control

* AC Control (ON/OFF)
* Fan Control (ON/OFF)
* Manual Mode
* Automatic Mode
* Remote Device Management

### Analytics

* Live Sensor Trend Charts
* Historical Data Visualization
* Device Status Monitoring
* Connection Status Detection
* Total Read Counter

### User Interface

* Modern Dark-Themed Dashboard
* Responsive Mobile-Friendly Design
* Real-Time Updates
* Animated Components
* Interactive Controls

---

## System Architecture

ESP32 Sensors
↓
Firebase Realtime Database
↓
Web Dashboard
↓
Android Application

---

## Hardware Components

| Component       | Purpose                           |
| --------------- | --------------------------------- |
| ESP32           | Main Controller                   |
| DHT22 Sensor    | Temperature & Humidity Monitoring |
| MQ Gas Sensor   | Gas Detection                     |
| Relay Module    | Device Switching                  |
| Fan             | Controlled Device                 |
| Air Conditioner | Controlled Device                 |
| Power Supply    | System Power                      |

---

## Software Technologies

### Frontend

* HTML5
* CSS3
* JavaScript
* Chart.js

### Backend

* Firebase Realtime Database

### Mobile App

* Android Studio
* Kotlin

### IoT Platform

* ESP32
* Arduino Framework

---

## Database Structure

```json
sensor
{
  "temp": 28.5,
  "hum": 65,
  "gas": 320
}

control
{
  "mode": 1,
  "m1": 1,
  "m2": 0
}
```

### Control Parameters

| Key  | Description      |
| ---- | ---------------- |
| mode | Auto/Manual Mode |
| m1   | AC Control       |
| m2   | Fan Control      |

---

## Dashboard Features

### Sensor Cards

Temperature Card

* Current Temperature
* Status Indicator
* Progress Visualization

Humidity Card

* Current Humidity
* Comfort Analysis
* Live Updates

Gas Card

* Air Quality Monitoring
* Safety Alerts
* Gas Concentration Status

### Device Information

* ESP32 Status
* Firebase Connection Status
* Refresh Interval
* Last Seen Timestamp
* Total Database Reads

### Live Trend Graph

The dashboard uses Chart.js to visualize:

* Temperature Trends
* Humidity Trends
* Gas Trends

in real time.

---

## Android Application

The Android application provides:

* Live Sensor Monitoring
* Firebase Integration
* Real-Time Device Control
* Mobile Notifications
* Remote Access

---

## Automatic Mode Logic

### Temperature-Based Control

* High Temperature → AC ON
* Normal Temperature → AC OFF

### Gas Safety Logic

* High Gas Level → Alert Generated
* Ventilation Recommended

### Humidity Monitoring

* Humidity Status Classification
* Comfort Level Detection

---

## Installation

### ESP32

1. Install Arduino IDE
2. Install ESP32 Board Package
3. Install Required Libraries
4. Configure WiFi Credentials
5. Configure Firebase Credentials
6. Upload Code

### Web Dashboard

1. Clone Repository

```bash
git clone https://github.com/your-username/NexSense.git
```

2. Open index.html

3. Update Firebase URLs

```javascript
const DB = "YOUR_FIREBASE_URL";
const CONTROL = "YOUR_FIREBASE_CONTROL_URL";
```

4. Run on Browser

### Android App

1. Open Android Studio
2. Import Project
3. Connect Firebase
4. Build APK
5. Install on Device

---

## Future Enhancements

* Push Notifications
* Historical Data Storage
* AI-Based Prediction
* MQTT Integration
* Voice Assistant Support
* Energy Consumption Analysis
* Multi-Device Management

---

## Applications

* Smart Home Automation
* Smart Office Monitoring
* Industrial Safety Monitoring
* Laboratory Monitoring
* Environmental Monitoring
* Smart Building Management

---

## Project Author

**Shravan Singh**

B.Tech Computer Science Engineering

IoT | Android Development | AI | Firebase

GitHub:
https://github.com/singhShravan67

---

## License

This project is developed for educational, research, and IoT learning purposes.

Feel free to modify and extend the project according to your requirements.
