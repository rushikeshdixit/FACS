alter table employee
add constraint fk_branch foreign key(branch) references F16_12_branch(branchID);

alter table branch
add constraint fk_managerID foreign key(managerID) references F16_12_employee(employeeID);
