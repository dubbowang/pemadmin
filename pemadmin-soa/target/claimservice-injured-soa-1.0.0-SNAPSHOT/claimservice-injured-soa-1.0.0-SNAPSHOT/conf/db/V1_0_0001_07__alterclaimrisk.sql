ALTER TABLE `claimrisk`
ADD COLUMN `confirmTime`  timestamp NULL AFTER `vehicleNo`,
ADD COLUMN `confirmUser`  bigint(20) NULL AFTER `confirmTime`,
ADD COLUMN `confirmState`  int(11) NULL AFTER `confirmUser`,
ADD COLUMN `confirmRemark`  text NULL AFTER `confirmState`,
ADD COLUMN `randomId`  bigint(20) NULL AFTER `confirmRemark`;
