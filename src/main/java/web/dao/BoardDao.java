package web.dao;

import org.springframework.stereotype.Repository;
import web.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;


@Repository
public class BoardDao{

    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;


    public BoardDao() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1?serverTimezone=UTC","root","1234");
            System.out.println("연동성공");
        }

        catch(Exception e) {System.out.println("sql ����" + e);}
    }

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
    public ArrayList<BoardDto> list(){
        ArrayList<BoardDto> boardlist = new ArrayList<BoardDto>();
        try{
            String sql = "select * from board";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                BoardDto boardDto = new BoardDto(
                  rs.getInt(1),rs.getString(2)
                        ,rs.getString(3)
                );
                boardlist.add(boardDto);
            }
            return boardlist;
        }catch(Exception e){

        }
        return null;
    }

//    private JdbcTemplate jdbcTemplate;
//    public BoardDao (DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);}
//    public void save(BoardDto boardDto) {
//    jdbcTemplate.save("insert into board(btitle,bcontent) values(?,?)",boardDto.getBtitle(),boardDto.getBcontent());}

}
