package web.dto;

public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;

    public BoardDto() {
    }

    public BoardDto(int bno, String btitle, String bcontent) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                '}';
    }
}
