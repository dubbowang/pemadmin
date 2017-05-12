ALTER TABLE `injurednurseinfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredretaininfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredalimonyinfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredotherfee`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredfeeiteminfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredinfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

ALTER TABLE `injuredidentifyinfo`
ADD COLUMN `lossAssessmentId`  bigint NULL AFTER `id`,
ADD INDEX `lossAssessmentId` (`lossAssessmentId`) USING BTREE ;

