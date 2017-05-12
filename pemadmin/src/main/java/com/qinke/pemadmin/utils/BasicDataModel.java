package com.qinke.pemadmin.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicDataModel {

	@Value("${linuxImportExcelFilePath}")
	private String linuxImportExcelFilePath;

	@Value("${filePath}")
	private String filePath;

	@Value("${webapi}")
	private String webapi;

	@Value("${fileRootUrl}")
	private String fileRootUrl;

	@Value("${exportExcelFilePath}")
	private String exportExcelFilePath;

	@Value("${ImportExcelFilePath}")
	private String ImportExcelFilePath;

	@Value("${templateFilePath}")
	private String templateFilePath;

	@Value("${detailedDerogationSheet}")
	private String detailedDerogationSheet;

	@Value("${finalDerogationgSheet}")
	private String finalDerogationgSheet;

	@Value("${branchCompanyDerogationgSheet}")
	private String branchCompanyDerogationgSheet;

	@Value("${pinganClaimsFileFlag}")
	private String pinganClaimsFileFlag;

    private int fileFlag;

	public String getBranchCompanyDerogationgSheet() {
		return branchCompanyDerogationgSheet;
	}

	public void setBranchCompanyDerogationgSheet(String branchCompanyDerogationgSheet) {
		this.branchCompanyDerogationgSheet = branchCompanyDerogationgSheet;
	}

	public String getDetailedDerogationSheet() {
		return detailedDerogationSheet;
	}

	public void setDetailedDerogationSheet(String detailedDerogationSheet) {
		this.detailedDerogationSheet = detailedDerogationSheet;
	}

	public String getFinalDerogationgSheet() {
		return finalDerogationgSheet;
	}

	public void setFinalDerogationgSheet(String finalDerogationgSheet) {
		this.finalDerogationgSheet = finalDerogationgSheet;
	}

	public String getLinuxImportExcelFilePath() {
		return linuxImportExcelFilePath;
	}

	public void setLinuxImportExcelFilePath(String linuxImportExcelFilePath) {
		this.linuxImportExcelFilePath = linuxImportExcelFilePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getWebapi() {
		return webapi;
	}

	public void setWebapi(String webapi) {
		this.webapi = webapi;
	}

	public String getExportExcelFilePath() {
		return exportExcelFilePath;
	}

	public void setExportExcelFilePath(String exportExcelFilePath) {
		this.exportExcelFilePath = exportExcelFilePath;
	}

	public String getTemplateFilePath() {
		return templateFilePath;
	}

	public void setTemplateFilePath(String templateFilePath) {
		this.templateFilePath = templateFilePath;
	}

	public int getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(int fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getFileRootUrl() {
		return fileRootUrl;
	}

	public void setFileRootUrl(String fileRootUrl) {
		this.fileRootUrl = fileRootUrl;
	}

	public String getImportExcelFilePath() {
		return ImportExcelFilePath;
	}

	public void setImportExcelFilePath(String importExcelFilePath) {
		ImportExcelFilePath = importExcelFilePath;
	}

    public String getPinganClaimsFileFlag() {
        return pinganClaimsFileFlag;
    }

    public void setPinganClaimsFileFlag(String pinganClaimsFileFlag) {
        this.pinganClaimsFileFlag = pinganClaimsFileFlag;
    }

}
