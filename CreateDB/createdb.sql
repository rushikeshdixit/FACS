create table F16_12_customer (
        customerID number,
        firstName varchar2(20) not null,
        middleName varchar2(20),
        lastName varchar2(20) not null,
        dateofBirth date not null,
        phone varchar2(10) not null,
        emailID varchar2(30),
        blockNo varchar2(10),
        street varchar2(50),
        apartment varchar2(20),
        state varchar2(20),
        zipCode numeric(5),
        constraint pk_customer primary key(customerID),
        constraint chk_customerPhone check(length(phone) = 10)
);


create table F16_12_enquirer (
        enquirerID number,
        countryPref varchar2(30),
        constraint pk_enquirerID primary key(enquirerID),
        constraint fk_enquirerID foreign key(enquirerID) references F16_12_customer(customerID)
);


create table F16_12_applicant (
        applicantID number,
        eduStatus varchar2(30),
        countryPref varchar2(30),
        universityPref varchar(50),
        constraint pk_applicantID primary key(applicantID),
        constraint fk_applicant foreign key(applicantID) references F16_12_customer(customerID)
);


create table F16_12_employee (
        employeeID number,
        firstName varchar2(20) not null,
        middleName varchar2(20),
        lastName varchar2(20) not null,
        phone varchar2(10) not null,
        designation varchar2(20) not null,
        monthly_salary number(5) not null,
        branch numeric(1),
        startDate date not null,
        endDate date,
        constraint chk_salary check(monthly_salary >= 2000 or monthly_salary <= 30000),
        --constraint chk_designation check(designation like 'manager' or designation like 'accountant'),
        constraint chk_phone check(length(phone) = 10), 
        constraint pk_employeeID primary key(employeeID)


);


create table F16_12_branch (
        branchID number(1),
        branchLocation varchar2(40),
        managerID number,
        constraint pk_branchID primary key(branchID),
        constraint chk_branchID check (branchID = 1 or branchID = 2)
);


create table F16_12_service (
       serviceID number,
       serviceFee number(5),       
       serviceType varchar2(25),
       constraint pk_service primary key(serviceID)
);


create table F16_12_visaRecord (
        serviceID number,
        interviewDate date not null,
        visaStatus varchar2(20),
        constraint chk_visaStatus check(visaStatus like 'accept' or visaStatus like 'reject'), 
        constraint pk_visaRecord primary key(serviceID),
        constraint fk_visaRecord foreign key(serviceID) references F16_12_service(serviceID)
);


create table F16_12_universityApplication (
        serviceID number,
        universityName varchar2(80) not null,
        applicationStatus varchar2(20),
        constraint chk_applicationStatus check(applicationStatus like 'accept' or applicationStatus like 'reject'),
        constraint pk_universityApplication primary key(serviceID),
        constraint fk_universityApplication foreign key(serviceID) references F16_12_service(serviceID)
);


create table F16_12_tutorClass (
        serviceID number,
        classType varchar2(50) not null,
        constraint chk_classType check(classType like 'GRE' or classType like 'TOEFL' or classType like 'IELTS'),
        constraint pk_tutorClass primary key(serviceID),
        constraint fk_tutorClass foreign key(serviceID) references F16_12_service(serviceID)
);


create table F16_12_classSchedule (
        serviceID number,
        section varchar2(30),
        classDay varchar2(20),
        classTime varchar2(20),
        constraint chk_classDay check(classDay like 'Monday' or
                                      classDay like 'Tuesday' or
                                      classDay like 'Wednesday' or
                                      classDay like 'Thursday' or
                                      classDay like 'Friday' or
                                      classDay like 'Saturday' or
                                      classDay like 'Sunday'),
        constraint pk_classSchedule primary key(serviceID, section, classDay, classTime),
        constraint fk_classSchedule foreign key(serviceID) references F16_12_tutorClass(serviceID)
);


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


create table F16_12_rates (
        applicantID number,
        employeeID number,
        rating number(1),
        constraint pk_rates primary key(applicantID, employeeID),
        constraint fk_ratesApplicantID foreign key(applicantID) references F16_12_applicant(applicantID),
        constraint fk_ratesEmployeeID foreign key(employeeID) references F16_12_employee(employeeID)
);


create table F16_12_enquiresAt (
        enquirerID number,
        branchID number,
        dateofEnquiry date,
        constraint pk_enquiresAt primary key(enquirerID, branchID),
        constraint fk_enquiresAt foreign key(enquirerID) references F16_12_enquirer(enquirerID),
        constraint fk_enquiresAtBranch foreign key(branchID) references F16_12_branch(branchID)
);