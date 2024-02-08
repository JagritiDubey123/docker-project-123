const mysql = require("mysql2");


// Create a connection to the database
const connection = mysql.createConnection({
  host: "mysql-container1",
  user: "root",
  password: "Jagriti@123456",
  port: "3306",
  database: "employees_db"
});

// open the MySQL connection
connection.connect(error => {
  if (error) throw error;
  console.log("Successfully connected to the MYSQL database.");
});

module.exports = connection;
