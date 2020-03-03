package net.darinlina.mvcproject01.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\personel\\myProjects\\SpringProject_01\\mvcproject01\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	public static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

		logger.info("REAL PATH is: " + REAL_PATH);

		// To make sure all the directories exists
		if (!new File(ABS_PATH).exists()) {
			// create the directories
			new File(ABS_PATH).mkdirs();

		}

		if (!new File(REAL_PATH).exists()) {
			// create the directories
			new File(REAL_PATH).mkdirs();

		}

		try {
			// for server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));

		} catch (IOException e) {
			logger.error("Something went wrong while uploading the image !");
		}

	}
}
