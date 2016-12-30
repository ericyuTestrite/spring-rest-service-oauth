select * from po_mst;


CREATE TABLE `userbase`.`PO_MST` (
  `HUB_ID` VARCHAR(10) NOT NULL,
  `COMPANY_ID` VARCHAR(10) NOT NULL,
  `PURCHASE_ID` VARCHAR(10) NOT NULL,
  `PO_NO` VARCHAR(20) NOT NULL,
  `ORDER_DATE` DATETIME NOT NULL,
  `PO_TYPE` VARCHAR(10) NULL,
  `VENDOR_NO` VARCHAR(45) NULL,
  `ORDER_DEPT` VARCHAR(45) NULL,
  `OLD_PO_NO` INT NULL,
  PRIMARY KEY (`HUB_ID`, `COMPANY_ID`, `PURCHASE_ID`, `PO_NO`, `ORDER_DATE`));
