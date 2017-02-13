create table F16_12_enrollsIn (
        applicantID number,
        branchID number(1),
        employeeID number,
        serviceID number,
        applicantDOJ date,
        constraint pk_enrollsIn primary key (applicantID, branchID, employeeID, serviceID),
        constraint fk_enrollsIn foreign key(applicantID) references F16_12_applicant(applicantID),
        constraint fk_enrollsInBranch foreign key(branchID) references F16_12_branch(branchID),
        constraint fk_enrollsInEmployee foreign key(employeeID) references F16_12_employee(employeeID),
        constraint fk_enrollsInService foreign key(serviceID) references F16_12_service(serviceID)
);
