import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ColdObservable } from 'rxjs/internal/testing/ColdObservable';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee:Employee = new Employee;

  constructor(private employeeService:EmployeeService,
    private router:Router) { }

  ngOnInit(): void {
  
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe();
    }

  goToEmployeeList(){
    this.router.navigate(["/employees"]);
  }
  
    

  onSubmit(){
    this.saveEmployee();
    this.goToEmployeeList();

  }

}
