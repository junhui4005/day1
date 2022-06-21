package web.dao;

import web.dto.BoardDto;

import java.sql.*;


public class BoardDao extends Dao{

    public BoardDao() {
        super();
    }

    public static BoardDao boardDao = new BoardDao();
    public static BoardDao getboardDao() {return boardDao;};


    public boolean save(BoardDto boardDto){
        try{
            String sql = "insert into board(btitle,bcontent) values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,boardDto.getBtitle());
            ps.setString(2,boardDto.getBcontent());
            ps.executeUpdate();
            return true;
        }catch(Exception e){

        }
        return false;
    }

//    private JdbcTemplate jdbcTemplate;
//    public BoardDao (DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);}
//    public void save(BoardDto boardDto) {
//    jdbcTemplate.save("insert into board(btitle,bcontent) values(?,?)",boardDto.getBtitle(),boardDto.getBcontent());}

}
