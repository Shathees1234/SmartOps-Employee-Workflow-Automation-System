# SmartOps: Employee Workflow Automation System
SmartOps-Employee-Workflow-Automation is a Core Java–based console application designed to manage employee details and automate leave management using JDBC and MySQL.

---

## 📌 Project Objective
To simplify employee leave handling by automating leave requests, approvals, and tracking through a structured and rule-based system.

---

## 🛠 Technologies Used
- Java (Core Java, OOP Concepts)
- JDBC
- MySQL
- SQL

---

## ✨ Key Features
- Employee registration and management
- Apply for leave with validation
- Admin approval or rejection of leave requests
- AI-based rule engine for leave decision support
- MySQL database connectivity using JDBC
- Clean layered architecture (Model, Service, Utility)

---

## 📂 Project Structure
- **model** – Entity classes like Employee and LeaveRequest
- **service** – Business logic for employees and admin
- **util** – Database connection and AI rule engine
- **MainApp** – Entry point of the application

---

## ⚙️ How to Run the Project
1. Clone or download the repository
2. Import the project into Eclipse / IntelliJ IDEA
3. Execute the SQL script from the `sql` folder to create the database
4. Update database credentials in `DBConnection.java`
5. Run `MainApp.java`

---

## 🧠 AI Rule Engine (Simple Logic)
- Automatically validates leave based on:
  - Available leave balance
  - Leave duration
- Helps admin make faster decisions

---

## 📈 Use Case
This system reduces manual effort in managing employee leave requests and improves accuracy and efficiency in approval workflows.

---

## 🎯 Future Enhancements
- Web interface using HTML, CSS, JavaScript
- Role-based authentication
- Leave history reports
- Email notification system

---

## 👨‍💻 Author
**Shathees GV**
