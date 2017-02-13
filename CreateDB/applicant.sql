create table F16_12_applicant (
        applicantID number,
        eduStatus varchar2(30),
        countryPref varchar2(30),
        universityPref varchar(50),
        constraint pk_applicantID primary key(applicantID),
        constraint fk_applicant foreign key(applicantID) references F16_12_customer(customerID)
);
