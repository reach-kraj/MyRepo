const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

// Create a MySQL connection
const mysqlConnection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root@123',
  database: 'EmployeeDB'
});

// Connect to the MySQL database
mysqlConnection.connect((err) => {
  if (err) {
    console.error('Database connection failed: ' + err.stack);
    return;
  }
  console.log('Connected to database.');
});

// Example route that uses the MySQL connection
// get all employee
app.get('/users', (req, res) => {
  mysqlConnection.query('SELECT * FROM employee', (err, results) => {
    if (err) {
      console.error('Failed to retrieve users: ' + err.stack);
      res.status(500).send('Failed to retrieve users');
      return;
    }
    res.json(results);
    console.log(results);
  });
});

//get particular Employee
app.get('/users/:id', (req, res) => {
    mysqlConnection.query('SELECT * FROM employee WHERE EmpID =?',[req.params.id],(err, results) => {
      if (err) {
        console.error('Failed to retrieve users: ' + err.stack);
        res.status(500).send('Failed to retrieve users');
        return;
      }
      res.json(results);
      console.log(results);
    });
  });


  //delete
  app.delete('/users/:id', (req, res) => {
    mysqlConnection.query('DELETE FROM employee WHERE EmpID =?',[req.params.id],(err, results) => {
      if (err) {
        console.error('Failed to retrieve users: ' + err.stack);
        res.status(500).send('Failed to retrieve users');
        return;
      }
      // res.json(results);
      console.log('Deleted successfully');
      res.send('Deleted successfully');
    });
  });
  
 //insert
 app.post('/users', (req, res) => {
  let emp = req.body;
  console.log('Request body:', emp); // Log the request body to debug
  // if (!emp.EmpID || !emp.Name || !emp.EmpCode || !emp.Salary) {
  //   res.status(400).send('All fields (EmpID, Name, EmpCode, Salary) are required');
  //   return;
  // }

  // Check if the employee exists
  mysqlConnection.query('SELECT * FROM employee WHERE EmpID = ?', [emp.EmpID], (err, results) => {
    if (err) {
      console.error('Failed to retrieve user: ' + err.stack);
      res.status(500).send('Failed to retrieve user');
      return;
    }

    if (results.length > 0) {
      // Update existing employee
      const updateSql = 'UPDATE employee SET Name = ?, EmpCode = ?, Salary = ? WHERE EmpID = ?';
      mysqlConnection.query(updateSql, [emp.Name, emp.EmpCode, emp.Salary, emp.EmpID], (err, results) => {
        if (err) {
          console.error('Failed to update user: ' + err.stack);
          res.status(500).send('Failed to update user');
          return;
        }
        console.log('Updated successfully');
        res.send('Updated successfully');
      });
    } else {
      // Insert new employee
      const insertSql = 'INSERT INTO employee (EmpID, Name, EmpCode, Salary) VALUES (?, ?, ?, ?)';
      mysqlConnection.query(insertSql, [emp.EmpID, emp.Name, emp.EmpCode, emp.Salary], (err, results) => {
        if (err) {
          console.error('Failed to insert user: ' + err.stack);
          res.status(500).send('Failed to insert user');
          return;
        }
        console.log('Inserted successfully');
        res.send('Inserted successfully');
      });
    }
  });
});

  // Start the Express server
  app.listen(port, () => {
    console.log(`Server running on port ${port}`);
  });
