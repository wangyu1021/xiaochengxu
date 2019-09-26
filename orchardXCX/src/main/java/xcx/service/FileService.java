package xcx.service;

import org.springframework.web.multipart.MultipartFile;

import xcx.vo.ImageVO;



public interface FileService {

	ImageVO updateFile(MultipartFile uploadFile);

}
