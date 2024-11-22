package com.hanulso.util;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hanulso.domain.BoardAttachVo;
import com.hanulso.domain.PresidentVo;

@Component
public class FileUpload {

	// String uploadFolder = "C:/upload";
	private final String uploadFolder = Paths.get("C:", "upload").toString();

	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	public List<BoardAttachVo> uploadFiles(@RequestParam("uploadFile") MultipartFile[] uploadFile) {

		List<BoardAttachVo> list = new ArrayList<>();

		String uploadFolderPath = getFolder();

		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			BoardAttachVo attach = new BoardAttachVo();

			String uploadFilesname = multipartFile.getOriginalFilename();

			UUID uuid = UUID.randomUUID();

			uploadFilesname = uuid.toString() + "_" + uploadFilesname;

			File saveFilename = new File(uploadPath, uploadFilesname);
			System.out.println(saveFilename);
			try {

				multipartFile.transferTo(saveFilename);

				attach.setFilename(multipartFile.getOriginalFilename());
				attach.setUploadfile(saveFilename.toString());
				attach.setUuid(uuid.toString());
				attach.setUploadpath(uploadFolderPath);

			} catch (Exception e) {
				e.printStackTrace();
			}

			list.add(attach);
		}

		return list;
	}

	public PresidentVo uploadPresident(@RequestParam("uploadFile") MultipartFile[] uploadFile) {

		String uploadFolderPath = getFolder();

		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		MultipartFile presidentFile = uploadFile[0];

		UUID uuid = UUID.randomUUID();

		PresidentVo president = new PresidentVo();

		String presidentImg = presidentFile.getOriginalFilename();

		presidentImg = uuid.toString() + "_" + presidentImg;

		File savePresident = new File(uploadPath, presidentImg);

		try {

			presidentFile.transferTo(savePresident);

			president.setFilename(presidentFile.getOriginalFilename());
			president.setUploadfile(savePresident.toString());
			president.setUuid(uuid.toString());
			president.setUploadpath(uploadFolderPath);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return president;

	}

}
