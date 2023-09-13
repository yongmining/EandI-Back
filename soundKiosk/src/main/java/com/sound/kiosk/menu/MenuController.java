package com.sound.kiosk.menu;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MenuController {
	
	private MenuService menuService;

	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	@GetMapping("main")
	public String main() {
		return "default/main";
	}
	
	
	@ResponseBody
	@PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) {
        // 여기서 file과 title을 사용하여 원하는 로직을 수행하고 결과를 반환합니다.
        // 예를 들어, 파일을 저장하고 title을 기반으로 처리할 수 있습니다.
        System.out.println(file);
        // 아래는 간단한 예제로 file 이름과 title을 합쳐서 반환하는 예제입니다.
        String result = "파일 이름: " + file.getOriginalFilename() + ", 제목: " + title;
        
        return result;
    }
	
	@GetMapping("/getTotalMenu")
	public Object getTotalMenu() {
		
		ArrayList<MenuDTO> totalMenus = menuService.getTotalMenus();
		return totalMenus;
	}
	
}