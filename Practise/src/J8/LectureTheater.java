package J8;

public class LectureTheater {
    String name;
    Projector projector;
    public LectureTheater(String name, String projectorBrand, boolean hdProjector){
        this.name = name;
        this.projector = new Projector(projectorBrand,hdProjector,this);
    }
    @Override
    public String toString() {
        return "LectureTheater "+name+" with projector "+projector;
    }
}
