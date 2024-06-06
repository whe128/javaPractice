package J8;

public class LectureTheaterStaticNested {
    String name;
    ProjectorNested projector;

    public static class ProjectorNested{
        String brand;
        boolean isHD;
        LectureTheaterStaticNested theater;
        public ProjectorNested(String brand, boolean isHD, LectureTheaterStaticNested theater){
            this.brand = brand;
            this.isHD=isHD;
            this.theater=theater;
        }
        @Override
        public String toString() {
            return brand+" projector, "+(isHD?"has HD":"no HD")+", in "+theater.name;
        }
    }
    public LectureTheaterStaticNested(String name, String projectorBrand, boolean hdProjector){
        this.name = name;
        this.projector = new ProjectorNested(projectorBrand,hdProjector,this);
    }

    @Override
    public String toString() {
        return "LectureTheater "+name+" with projector "+projector;
    }
}
