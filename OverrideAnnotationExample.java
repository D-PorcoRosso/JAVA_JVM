import java.util.*;

public class OverrideAnnotationExample {
    private final char first;
	private final char second;

	public OverrideAnnotationExample(char first, char second) {
		this.first = first;
		this.second = second;
	}

    //lack of override annotation, cause exec result error
	/*public boolean equals(OverrideAnnotationExample b) {
		return b.first == first && b.second == second;
    }*/
    
    // compile error
    /*@Override
    public boolean equals(OverrideAnnotationExample b) {
		return b.first == first && b.second == second;
    }*/
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OverrideAnnotationExample ))
            return false;
        OverrideAnnotationExample O = (OverrideAnnotationExample)o;
		return O.first == first && O.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<OverrideAnnotationExample> s = new HashSet<OverrideAnnotationExample>();
		for (int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				s.add(new OverrideAnnotationExample(ch, ch));
		System.out.println(s.size());
	}
}