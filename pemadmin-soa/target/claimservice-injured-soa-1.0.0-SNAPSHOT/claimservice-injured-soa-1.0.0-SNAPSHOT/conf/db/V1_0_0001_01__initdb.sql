/*==============================================================*/
/* Table: claimInfo                                             */
/*==============================================================*/
create table claimInfo
(
   id                   bigint not null,
   claimNumber          varchar(64),
   insuranceCompanyId   bigint,
   branchInsuranceCompanyId bigint,
   lossAmount           float,
   ClaimType            int,
   IsMostRecent         int,
   IsExistPhoto         int,
   sysCheckState        int,
   checkState           int,
   derogationState      int,
   claimState           int,
   claimStage           int,
   heardState           int,
   heardTime            timestamp,
   closedState          int,
   closedTime           timestamp,
   acceptTime           timestamp,
   caseType             int,
   primary key (id)
);

/*==============================================================*/
/* Table: ClaimReportInfo                                       */
/*==============================================================*/
create table ClaimReportInfo
(
   id                   bigint not null auto_increment,
   ClaimId              bigint not null,
   claimNo              varchar(128),
   relatedClaimNumber   varchar(256),
   Reporter             varchar(32),
   ReporterContact      varchar(32),
   ReportDate           timestamp,
   IsRemoteAccident     int,
   AccidentDate         timestamp,
   AccidentAddress      varchar(128),
   AccidentReason       varchar(64),
   AccidentType         varchar(100),
   AccidentDescription  text,
   ReporterIsInsured    int,
   ReporterIsDriver     int,
   Driver               varchar(16),
   DriverGender         int,
   ReportedOnSite       int,
   PolicyHolderName     varchar(32),
   PolicyHolderTel      varchar(32),
   AccidentResponsibility varchar(32),
   DisposeDepartment    varchar(32),
   DisposeType          varchar(32),
   Remark               text,
   PoliceDisposeDesc    varchar(256),
   reportMode           int,
   primary key (id)
);

/*==============================================================*/
/* Table: InvestigationInfo                                     */
/*==============================================================*/
create table InvestigationInfo
(
   Id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   Investigator         varchar(32),
   InvestigationDate    timestamp,
   AccidentReason       varchar(128),
   AccidentType         varchar(32),
   LossCategory         varchar(32),
   Remark               text,
   InsuranceTypeId      bigint,
   accidentResponsibility varchar(32),
   disposeType          varchar(32),
   urgency              varchar(32),
   isSimpleClaim        int,
   hasInjuredPerson     int,
   sceneType            varchar(32),
   accidentAddress      varchar(200),
   investigationComments text,
   Operator             varchar(32),
   operationTime        timestamp,
   operationEquipmentType int,
   payoutType           int,
   claimType            varchar(32),
   hasAccidentScene     int,
   lossTypeName         varchar,
   isPrimaryScene       int,
   isReportAccidentAddress int,
   insuranceType        varchar,
   surveyMode           varchar,
   injuredMeet          int,
   policeOpinion        text,
   policeDept           varchar(128),
   policeName           varchar(32),
   policePhoneNo        varchar(32),
   accidentResult       int,
   primary key (Id)
);

/*==============================================================*/
/* Table: claimLoss                                             */
/*==============================================================*/
create table claimLoss
(
   id                   bigint not null auto_increment,
   claimId              bigint,
   claimNumber          varchar(64),
   injuredId            bigint,
   feeItemId            bigint,
   feeItemName          varchar(32),
   stdPrice             float,
   lossCount            int,
   lossRate             float,
   lossAmount           float,
   stdAreaCode          bigint,
   lossBasis            varchar(256),
   primary key (id)
);

/*==============================================================*/
/* Table: LossAudit                                             */
/*==============================================================*/
create table LossAudit
(
   id                   bigint not null auto_increment,
   lossId               bigint,
   VehicleNo            varchar(32),
   userRoleName         varchar(64),
   auditType            int,
   taskRemark           text,
   createTime           timestamp,
   createUser           bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredInfo                                           */
/*==============================================================*/
create table injuredInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredName          varchar(64),
   injuredGender        int,
   injuredAge           int,
   certificateType      int,
   certificateNo        varchar(64),
   injuredInsuranceType int,
   injuryType           int,
   injuredTreatment     int,
   injuredDelivery      int,
   directPay            int,
   injuredPhoneNo       varchar(32),
   contactName          varchar(32),
   contactPhoneNo       varchar(32),
   censusAddr           varchar(256),
   censusType           int,
   residenceAddr        varchar(256),
   residenceYears       int,
   housingType          int,
   jobState             int,
   jobTrade             bigint,
   jobCompanyName       varchar(64),
   jobCompanyAddr       varchar(256),
   jobCompanyPhoneNo    varchar(32),
   jobAge               int,
   jobPost              varchar(32),
   jobWage              float,
   grantType            int,
   contractSigned       int,
   agentName            varchar(32),
   agentPhone           varchar(32),
   litigateState        int,
   litigateSite         varchar(32),
   agentlawyer          varchar(32),
   agentlawyerPhoneNo   varchar(32),
   courtAddr            varchar(256),
   compensateStd        varchar(64),
   compensateStdYear    int,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredAccidentInfo                                   */
/*==============================================================*/
create table injuredAccidentInfo
(
   id                   bigint not null auto_increment,
   injuredId            bigint,
   injuredState         int,
   inquireTime          timestamp,
   vehicleBrand         varchar(32),
   vehicleColor         varchar(32),
   accidentAddr         varchar(256),
   injuredCount         int,
   driverFeature        varchar(256),
   accidentRemark       text,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredhospitalRegInfo                                */
/*==============================================================*/
create table injuredhospitalRegInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   hospitalId           bigint,
   deptId               bigint,
   combineState         int,
   hospitalNumber       varchar(128),
   bedNumber            varchar(32),
   checkInTime          timestamp,
   checkOutTime         timestamp,
   hospitalDay          int,
   doctorName           bigint,
   treatmentType        text,
   preHospitalName      bigint,
   enterTime            timestamp,
   treatmentRemark      text,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredTraceInfo                                      */
/*==============================================================*/
create table injuredTraceInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   traceUserName        varchar(32),
   injuredId            bigint,
   traceRemark          text,
   traceTime            timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredDiagnoseInfo                                   */
/*==============================================================*/
create table injuredDiagnoseInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   hospitalId           bigint,
   InjuryMainPart       bigint,
   InjurySubPart        bigint,
   diagnoseRemark       text,
   InjuryClassify       bigint,
   surgeryName          bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: InjuredNurseInfo                                      */
/*==============================================================*/
create table InjuredNurseInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   nurserName           varchar(32),
   nurseType            bigint,
   nurseGrade           bigint,
   nurserTrade          bigint,
   nurserCompany        varchar(256),
   nurseUnitPrice       float,
   estimateDays         int,
   actualDays           int,
   nurseFee             float,
   primary key (id)
);


/*==============================================================*/
/* Table: injuredRetainInfo                                     */
/*==============================================================*/
create table injuredRetainInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   treatmentItemId      bigint,
   treatmentFee         float,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredIdentifyInfo                                   */
/*==============================================================*/
create table injuredIdentifyInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   identifyRemark       text,
   identifyOrgId        bigint,
   identifyUserName     varchar(32),
   identifyDate         varchar(32),
   effectiveDate        varchar(32),
   disabilityName       varchar(64),
   disabilityGrade      int,
   disabilityClause     int,
   disabilityRate       float,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredAlimonyInfo                                    */
/*==============================================================*/
create table injuredAlimonyInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   alimonyPersonName    varchar(32),
   injuredRelation      int,
   alimonyBirthday      varchar(32),
   alimonyYears         int,
   censusType           int,
   alimonyCount         int,
   alimonyStdAreaCode   varchar(256),
   alimonyUnitPrice     int,
   alimonyFee           float,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredFeeItemInfo                                    */
/*==============================================================*/
create table injuredFeeItemInfo
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   claimantAmount       float,
   lossHistoryAmount    float,
   lossLuggageAmount    float,
   treatmentAmount      float,
   disabilityAmount     float,
   litigateFee          float,
   lossAmount           float,
   preemptionAmount     float,
   advanceAmount        float,
   enforceTreatmentMaxAmount float,
   enforceDisabilityMaxAmount float,
   dutyCoefficient      float,
   allocationRatio      float,
   enforceTreatmentOtherAmount float,
   enforceDisabilityOtherAmount float,
   primary key (id)
);

/*==============================================================*/
/* Table: injuredOtherFee                                       */
/*==============================================================*/
create table injuredOtherFee
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(64),
   injuredId            bigint,
   feeDays              int,
   unitPrice            float,
   lossAmount           float,
   feeType              int,
   primary key (id)
);


