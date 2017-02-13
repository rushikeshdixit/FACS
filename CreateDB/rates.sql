create table F16_12_rates (
        applicantID number,
        employeeID number,
        rating number(1),
        constraint pk_rates primary key(applicantID, employeeID),
        constraint fk_ratesApplicantID foreign key(applicantID) references F16_12_applicant(applicantID),
        constraint fk_ratesEmployeeID foreign key(employeeID) references F16_12_employee(employeeID)
);
