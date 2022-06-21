package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.dao.BoardDao;
import web.dto.BoardDto;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

    @GetMapping("/")
    public String main(){
        return "write";
    }

    @PostMapping("/write")
    @ResponseBody
    public String write(@ModelAttribute BoardDto boardDto){
        BoardDao boardDao = new BoardDao();
        BoardDao.getboardDao().save(boardDto);
        return "/";
    }

}
