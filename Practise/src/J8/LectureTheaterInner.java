package J8;

public class LectureTheaterInner {
    String name;
    ProjectorInner projector;

    public class ProjectorInner{
        String brand;
        boolean isHD;

        public ProjectorInner(String brand, boolean isHD){
            this.brand = brand;
            this.isHD = isHD;
        }
        @Override
        public String toString() {
            return brand+" projector, "+(isHD?"has HD":"no HD")+", in "+name;
        }
    }

    public LectureTheaterInner(String name, String projectorBrand, boolean hdProjector){
        this.name = name;
        /*
            here use the inner class
         */
        this.projector = this.new ProjectorInner(projectorBrand, hdProjector);
    }

    @Override
    public String toString() {
        return "LectureTheater "+name+" with projector "+projector;
    }
}
