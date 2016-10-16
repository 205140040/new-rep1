package com.yfairy.file.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	private final String FILEBASEPATH = "C:\\Users\\jiangzi\\Desktop\\fileupload";

	@RequestMapping("/toFileUploadPage")
	public String toFileUploadPage() {
		return "jsp/fileUpload";
	}

	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			// 后缀
			String[] ss = fileName.split("\\.");
			String suffix = ss[1];
			File basePath = new File(FILEBASEPATH);
			if (!basePath.exists()) {
				basePath.mkdir(); // 创建basePath
			}
			File saveFileDir = new File(FILEBASEPATH, suffix); // 按照后缀名，分为不同的文件夹
			if (!saveFileDir.exists()) {
				saveFileDir.mkdir();
			}
			String newFileName = UUID.randomUUID() + "." + suffix;
			File saveFile = new File(saveFileDir, newFileName);
			file.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping("/view/**")
	public void view(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			String[] uriss = request.getRequestURI().split("/");
			String viewFilePath = "";
			for (String item : uriss) {
				if (StringUtils.hasText(item) && !item.equals("yfairy-web-www") && !item.equals("file")
						&& !item.equals("view")) {
					viewFilePath = viewFilePath + item + File.separator;
				}
			}
			viewFilePath = viewFilePath.substring(0, (viewFilePath.length() - 1));
			String finalViewFilePath = FILEBASEPATH + File.separator + viewFilePath;
			ServletOutputStream out = response.getOutputStream();
			byte[] bytes = FileCopyUtils.copyToByteArray(new File(finalViewFilePath));
			out.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
