package J8;

public class Nested {
    public static void main(String[] args) {
        LectureTheater llewellyn = new LectureTheater("Llewellyn Hall","Sony",true);
        System.out.println(llewellyn);
        LectureTheaterStaticNested manningclarke=new LectureTheaterStaticNested("Manning Clarke Hall", "LG", false);
        System.out.println(manningclarke);
        LectureTheaterInner dunbar=new LectureTheaterInner("Dunbar Hall", "Something", true);
        System.out.println(dunbar);
    }
}
