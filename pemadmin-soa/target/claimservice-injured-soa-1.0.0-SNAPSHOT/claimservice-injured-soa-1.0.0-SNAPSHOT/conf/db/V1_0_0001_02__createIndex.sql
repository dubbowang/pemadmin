ALTER TABLE `claiminfo`
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `claimloss`
ADD INDEX `claimId` (`claimId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `claimreportinfo`
ADD INDEX `ClaimId` (`ClaimId`) USING BTREE ,
ADD INDEX `claimNo` (`claimNo`) USING BTREE ,
ADD INDEX `relatedClaimNumber` (`relatedClaimNumber`) USING BTREE ;

ALTER TABLE `injuredaccidentinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE ;

ALTER TABLE `injuredalimonyinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injureddiagnoseinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredfeeiteminfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredhospitalreginfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredidentifyinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredinfo`
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injurednurseinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredotherfee`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredretaininfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `injuredtraceinfo`
ADD INDEX `injuredId` (`injuredId`) USING BTREE,
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `investigationinfo`
ADD INDEX `claimNumber` (`claimNumber`) USING BTREE ;

ALTER TABLE `lossaudit`
ADD INDEX `lossId` (`lossId`) USING BTREE,
ADD INDEX `VehicleNo` (`VehicleNo`) USING BTREE;

