package com.yfairy.file.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yfairy.common.utils.HttpClientUtil;

@Controller
@RequestMapping("/file")
public class FileController {
	/**
	 * 上传文件url
	 */
	@Value("${uploadFileUrl}")
	private String UPLOAD_FILE_URL;

	@RequestMapping("/toUploadFilePage")
	public String toUploadFilePage() {
		return "jsp/uploadFile";
	}

	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartFile file) {
		String res = HttpClientUtil.postMultipartFile(UPLOAD_FILE_URL, file);
		return res;
	}

	/*
	 * @RequestMapping("/imageFile/**") public void imageFile(HttpServletRequest
	 * request, HttpServletResponse response) { try {
	 * response.setCharacterEncoding("UTF-8"); String[] uriss =
	 * request.getRequestURI().split("/"); StringBuilder imageFilePathSb = new
	 * StringBuilder(); for (String item : uriss) { if
	 * (StringUtils.hasText(item) && !item.equals("file") &&
	 * !item.equals("imageFile")) { imageFilePathSb.append((item +
	 * File.separator)); } } String imageFilePath =
	 * imageFilePathSb.toString().substring(0, (imageFilePathSb.length() - 1));
	 * String finalImageFilePath = FILEBASEPATH + File.separator +
	 * imageFilePath; ServletOutputStream out = response.getOutputStream();
	 * byte[] bytes = FileCopyUtils.copyToByteArray(new
	 * File(finalImageFilePath)); out.write(bytes); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * @RequestMapping("/downloadFile/**") public void
	 * downloadFile(HttpServletRequest request, HttpServletResponse response) {
	 * try { request.setCharacterEncoding("UTF-8");
	 * response.setCharacterEncoding("UTF-8");
	 * response.setContentType("multipart/form-data");
	 * 
	 * String[] uriss = request.getRequestURI().split("/"); StringBuilder
	 * filePathSb = new StringBuilder(); for (String item : uriss) { if
	 * (StringUtils.hasText(item) && !item.equals("file") &&
	 * !item.equals("downloadFile")) { filePathSb.append((item +
	 * File.separator)); } } String filePath =
	 * filePathSb.toString().substring(0, (filePathSb.length() - 1)); String
	 * finalFilePath = FILEBASEPATH + File.separator + filePath; OutputStream
	 * out = response.getOutputStream(); File downloadFile = new
	 * File(finalFilePath); String downloadFileName = downloadFile.getName();
	 * response.setHeader("Content-Disposition", "attachment;fileName=" + new
	 * String(downloadFileName.getBytes(), "ISO-8859-1")); byte[] bytes =
	 * FileCopyUtils.copyToByteArray(downloadFile); out.write(bytes); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */
}
