create table F16_12_universityApplication (
        serviceID number,
        universityName varchar2(80) not null,
        applicationStatus varchar2(20),
        constraint chk_applicationStatus check(applicationStatus like 'accept' or applicationStatus like 'reject'),
        constraint pk_universityApplication primary key(serviceID),
        constraint fk_universityApplication foreign key(serviceID) references F16_12_service(serviceID)
);
