# DEPI: Swag Labs Testing Project

![Status](https://img.shields.io/badge/Status-In%20Progress-blue)
![Tests](https://img.shields.io/badge/Tests-Pending-yellow)
![Bugs Found](https://img.shields.io/badge/Bugs_Found-0-lightgrey)

---

### 📖1. Project Overview

This project is the final graduation submission for the **[Digital Egypt Pioneers (DEPI)](https://depi.gov.eg/)** initiative, provided by the Egyptian Ministry of Communications and Information Technology (MCIT).

Our project focuses on applying the complete Software Testing Life Cycle (STLC) to the **Swag Labs** e-commerce website. The primary objective is to conduct comprehensive manual and automation testing to ensure all core user stories function correctly and to document all test artifacts and findings.

---

### 2. Application Under Test (AUT)

![Swag Labs Login Page](assets/swag-labs-login.png)

---

### 3. Team & Responsibilities

Our team consists of four QA Testers, with responsibilities divided as follows:

| Team Member | Role | Responsibilities (User Stories) |
| :--- | :--- | :--- |
| **Aml Ahmed** | QA Tester | **US-03:** Cart Page <br> **US-04:** Checkout: Your Information |
| **Ahmed Akram** | QA Tester | **US-01:** Login Page |
| **Esraa Sameh** | QA Tester | **US-02:** Products Page |
| **Farah** | QA Tester | **US-05:** Checkout Overview Page <br> **US-06:** Checkout Complete Page |

---

### ⚙️ 4. Tools & Technology Stack

This project utilizes the following tools for management, documentation, and automation:

#### Manual Testing & Management Tools
| Tool | Purpose | Version / Platform |
| :--- | :--- | :--- |
| **Jira** | Project Management & Bug Tracking | Jira Cloud |
| **GitHub** | Version Control & Collaboration | Web (Cloud) |
| **MS Excel** | Test Artifacts (Cases, RTM) | (Desktop / Office 365) |

#### Automation Testing Stack (Future Scope)
| Tool | Purpose | Version |
| :--- | :--- | :--- |
| **Java** | Programming Language | 21 |
| **Selenium** | Browser Automation Framework | 4.27.0 |
| **TestNG** | Testing Framework | 7.10.2 |
| **Maven** | Build & Dependency Management | (Project Default) |
| **IntelliJ IDEA** | Integrated Development Environment | 2025.2.4 |

---

### 🧩5. Repository Structure

📂 DEPI-Swag-Labs-Testing
├── 📁 1-Documentation
│   ├── Test_Plan.pdf
│   ├── RTM.xlsx
│   └── Test_Summary_Report.pdf
├── 📁 2-Manual
│   └── Jira_Export.csv
├── 📁 3-Automation
│   └── (Automation Scripts)
└── README.md

---

### 6. Quick Links

* **[Project Jira Board] (https://depi-final-project-r3-ast.atlassian.net/jira/software/projects/SCRUM/boards/1)**
* **[Master Test Plan] (1-Documentation/Test_Plan.pdf)**

---

### 🚀 7. How to Run (Automation - Future Scope)

This section details the steps to run the automation test scripts once they are developed using the Maven framework.

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/YourUsername/DEPI-Swag-Labs-Testing.git](https://github.com/YourUsername/DEPI-Swag-Labs-Testing.git)
    ```
2.  **Navigate to the automation project directory:**
    ```sh
    cd 3-Automation
    ```
3.  **Install all required dependencies:**
    ```sh
    mvn install
    ```
4.  **Run the full test suite:**
    ```sh
    mvn test
    ```
