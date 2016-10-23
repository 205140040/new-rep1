package com.yfairy.file.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yfairy.common.enums.ImageEnum;

@Controller
@RequestMapping("/file")
public class FileController {

	@Value("${filebasepath}")
	private String FILEBASEPATH;

	@RequestMapping("/toUploadFilePage")
	public String toUploadFilePage() {
		return "jsp/uploadFile";
	}

	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartFile file) {
		String fileUrl = "";
		try {
			String fileName = file.getOriginalFilename();
			// 后缀
			String[] ss = fileName.split("\\.");
			String fileSuffix = ss[1];
			File basePath = new File(FILEBASEPATH);
			if (!basePath.exists()) {
				basePath.mkdir(); // 创建basePath
			}
			File saveFileDir = new File(FILEBASEPATH, fileSuffix); // 按照后缀名，分为不同的文件夹
			if (!saveFileDir.exists()) {
				saveFileDir.mkdir();
			}
			String newFileName = UUID.randomUUID() + "." + fileSuffix;
			File saveFile = new File(saveFileDir, newFileName);
			file.transferTo(saveFile);
			boolean isImage = false;
			ImageEnum[] imageEnums = ImageEnum.values();
			for (ImageEnum img : imageEnums) {
				if (img.getValue().equalsIgnoreCase(fileSuffix)) {
					isImage = true;
					break;
				}
			}
			if (isImage) {
				fileUrl = "/file/imageFile/" + fileSuffix + "/" + newFileName;
			} else {
				fileUrl = "/file/downloadFile/" + fileSuffix + "/" + newFileName;
			}
		} catch (Exception e) {
			fileUrl = e.getMessage();
			e.printStackTrace();
		}
		return fileUrl;
	}

	@RequestMapping("/imageFile/**")
	public void imageFile(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			String contextPath = request.getServletContext().getContextPath();
			contextPath = contextPath.replace("/", "");
			String[] uriss = request.getRequestURI().split("/");
			StringBuilder imageFilePathSb = new StringBuilder();
			for (String item : uriss) {
				if (StringUtils.hasText(item) && !item.equals(contextPath) && !item.equals("file")
						&& !item.equals("imageFile")) {
					imageFilePathSb.append((item + File.separator));
				}
			}
			String imageFilePath = imageFilePathSb.toString().substring(0, (imageFilePathSb.length() - 1));
			String finalImageFilePath = FILEBASEPATH + File.separator + imageFilePath;
			ServletOutputStream out = response.getOutputStream();
			byte[] bytes = FileCopyUtils.copyToByteArray(new File(finalImageFilePath));
			out.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/downloadFile/**")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("multipart/form-data");
			String contextPath = request.getServletContext().getContextPath();
			contextPath = contextPath.replace("/", "");
			String[] uriss = request.getRequestURI().split("/");
			StringBuilder filePathSb = new StringBuilder();
			for (String item : uriss) {
				if (StringUtils.hasText(item) && !item.equals(contextPath) && !item.equals("file")
						&& !item.equals("downloadFile")) {
					filePathSb.append((item + File.separator));
				}
			}
			String filePath = filePathSb.toString().substring(0, (filePathSb.length() - 1));
			String finalFilePath = FILEBASEPATH + File.separator + filePath;
			OutputStream out = response.getOutputStream();
			File downloadFile = new File(finalFilePath);
			String downloadFileName = downloadFile.getName();
			response.setHeader("Content-Disposition",
					"attachment;fileName=" + new String(downloadFileName.getBytes(), "ISO-8859-1"));
			byte[] bytes = FileCopyUtils.copyToByteArray(downloadFile);
			out.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
