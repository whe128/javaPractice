package J8;

public class Projector {
    String brand;
    boolean isHD;
    LectureTheater theater;

    public Projector(String brand, boolean isHD, LectureTheater theater){
        this.brand = brand;
        this.isHD=isHD;
        this.theater=theater;
    }

    @Override
    public String toString() {
        return brand+" projector, "+(isHD?"has HD":"no HD")+", in "+theater.name;
    }
}
