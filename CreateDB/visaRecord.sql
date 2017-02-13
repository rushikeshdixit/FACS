create table F16_12_visaRecord (
        serviceID number,
        interviewDate date not null,
        visaStatus varchar2(20),
        constraint chk_visaStatus check(visaStatus like 'accept' or visaStatus like 'reject'),
        constraint pk_visaRecord primary key(serviceID),
        constraint fk_visaRecord foreign key(serviceID) references F16_12_service(serviceID)
);
