/*==============================================================*/
/* Table: ClaimPolicy                                  */
/*==============================================================*/
create table ClaimPolicy
(
   id                   bigint not null auto_increment,
   claimNumber          varchar(32),
   InsurancePolicyId    bigint,
   vehicleId            bigint,
   insuranceCompanyId   bigint,
   primary key (id),
   KEY `claimNumber` (`claimNumber`) USING BTREE,
   KEY `InsurancePolicyId` (`InsurancePolicyId`) USING BTREE,
   KEY `vehicleId` (`vehicleId`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: InsurancePolicyInfo                                   */
/*==============================================================*/
create table InsurancePolicyInfo
(
   Id                   bigint not null auto_increment,
   PolicyNo             varchar(128),
   InsuranceCompanyId   varchar(32) not null,
   PolicyTypeId         int not null,
   InsuranceStartDate   timestamp,
   InsuranceEndDate     timestamp,
   Applicant            varchar(32),
   InsuredPersonName    varchar(32),
   InsuredPersonIDNumber varchar(32),
   InsuredPersonAddress varchar(200),
   InsuredPersonTel     varchar(32),
   Premium              decimal(9,2),
   SignedDate           timestamp,
   isNewEquipmentInsured integer,
   isDesinatedDriver    integer,
   AccidentsCount       integer,
   VehicleId            bigint,
   Remark               varchar(256),
   primary key (Id),
   KEY `PolicyNo` (`PolicyNo`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*==============================================================*/
/* Table: ClaimCheck                                            */
/*==============================================================*/
create table ClaimCheck
(
   Id                   bigint not null auto_increment,
   ClaimId              bigint,
   UserId               int not null,
   CheckTime            timestamp not null,
   FraudRiskLevel       int not null,
   PriceRiskLevel       int not null,
   ClaimCheckResultTypeId int not null,
   IsImportantClaim     int not null,
   checkMode            int,
   checkRemark          text,
   primary key (Id),
   KEY `ClaimId` (`ClaimId`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: ClaimRisk                                             */
/*==============================================================*/
create table ClaimRisk
(
   Id                   bigint not null auto_increment,
   claimId              bigint,
   checkId              bigint not null,
   ruleId               bigint,
   Score                float,
   AutoSuggestText      varchar(512) not null,
   IsDeleted            int not null,
   InvestigationRiskText varchar(512),
   VehicleId            bigint,
   ruleNo               varchar(32),
   vehicleNo            varchar(32),
   primary key (Id),
   KEY `claimId` (`claimId`) USING BTREE,
   KEY `checkId` (`checkId`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: claimDerogate                                         */
/*==============================================================*/
create table claimDerogate
(
   Id                   bigint not null auto_increment,
   riskId               bigint,
   checkId              bigint,
   claimId              bigint,
   injuredId            bigint,
   feeItemId            integer not null,
   stdFeeItemCount      int,
   stdFeePrice          float,
   stdAreaCode          varchar(32),
   derogateAmount       float,
   checkDate            timestamp,
   claimNumber          varchar(128),
   checkMode            int,
   insuranceCompanyId   bigint,
   confirmTime          timestamp,
   confirmUser          bigint,
   confirmState         int,
   confirmRemark        text,
   claimPartsName       varchar(32),
   primary key (Id),
   KEY `claimId` (`claimId`) USING BTREE,
   KEY `riskId` (`riskId`) USING BTREE,
   KEY `checkId` (`checkId`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
