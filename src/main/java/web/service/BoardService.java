package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.BoardDao;
import web.dto.BoardDto;

import java.util.ArrayList;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public boolean save(BoardDto boardDto){
        boolean re = boardDao.save(boardDto);
        return re;
    }

    public ArrayList<BoardDto> getlist(){
        ArrayList<BoardDto> list = boardDao.list();
        return list;
    }



}
