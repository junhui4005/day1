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
import java.util.Optional;

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
        return boardEntity.getBno() >= 1;
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

    public JSONObject board( int bno ) {
        Optional<BoardEntity> optional =  boardRepository.findById( bno );
        BoardEntity entity = optional.get();

        JSONObject object = new JSONObject();
        object.put("bno" , entity.getBno() );
        object.put("btitle" , entity.getBtitle() );
        object.put("bcontent" , entity.getBcontent() );
        return object;
    }
    public boolean delete(int bno){
        return boardDao.delete(bno);
    }

    public boolean update(BoardDto boardDto){
        return boardDao.update(boardDto.getBno(),boardDto.getBtitle(),boardDto.getBcontent());
    }

}
