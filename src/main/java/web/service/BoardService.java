package web.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.BoardDao;
import web.domain.BoardEntity;
import web.domain.BoardRepository;
import web.dto.BoardDto;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    HttpServletRequest request;

    @Autowired
    BoardRepository boardRepository;

    BoardDao boardDao = new BoardDao();

    public boolean save(BoardDto board){
        BoardEntity boardEntity = board.toentity();
        boardRepository.save( boardEntity );
        if(boardEntity.getBno()<1){
            return false;
        }else{
            return true;
        }
    }

    public JSONObject getlist(){
        JSONArray jsonArray = new JSONArray();
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        for (BoardEntity boardEntity : boardEntityList) {
            JSONObject object = new JSONObject();
            object.put("bno", boardEntity.getBno());
            object.put("btitle", boardEntity.getBtitle());
            object.put("bcontent", boardEntity.getBcontent());
            jsonArray.put(object);
        }
        JSONObject object = new JSONObject();
        object.put("list" , jsonArray );
        return object;
    }

    public BoardDto board( int bno ) {
        return boardDao.board(bno);
    }
    public boolean delete(int bno){
        return boardDao.delete(bno);
    }

    public boolean update(BoardDto boardDto){
        return boardDao.update(boardDto.getBno(),boardDto.getBtitle(),boardDto.getBcontent());
    }

}
