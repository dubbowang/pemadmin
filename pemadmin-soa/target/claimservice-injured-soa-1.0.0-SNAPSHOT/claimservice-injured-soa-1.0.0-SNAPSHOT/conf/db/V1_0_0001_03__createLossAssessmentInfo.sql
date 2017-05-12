create table LossAssessmentInfo
(
   id                   bigint not null auto_increment,
   ClaimId              bigint,
   lossAssessingTime    timestamp,
   lossAssessingAddress varchar(256),
   lossAssessorName     varchar(32),
   hospitalId           bigint,
   remark               text,
   insuranceCompanyId   int,
   LossAssessmentComCode varchar(128),
   lossAssessmentAmount decimal(9,2),
   lossAssessmentState  int,
   Operator             varchar(32),
   operationTime        timestamp,
   operationEquipmentType int,
   operationEquipmentId varchar(60),
   primary key (id),
   KEY `claimId` (`ClaimId`) USING BTREE
);
