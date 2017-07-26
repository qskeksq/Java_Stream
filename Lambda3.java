import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda3 {

	static String sample ="Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
	static String[] memos = new String[40];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prepareSamples();
												// String 을 String 배열로 바뀜
							// String 들의 Stream // 원래 있는 요소 바꾸기   // 반환하는 데이터 하나하나를 모아서 리스트로 만들어 준다
		List<String[]> list = Stream.of(memos).map(s->s.split(" ")).collect(Collectors.toList()); // 중간처리와 최종처리를 구분해 줘야 스트림의 흐름을 명확히 할 수 있다
							// 반환 값이 stream   // 거기에 map 을 하면 바뀐 값으로 stream // collect 에서 stream 출력값 모아서 리스트로 만들어 준다.
		for(String[] strings: list){
			System.out.print(Arrays.toString(strings));
		}
		// 이건 당연하게 외우고 시작해야 한다.
		// 자기가 받아야 하는 함수형 인터페이스의 종류는 알고 알아야 뭐를 생략할 수 있는지 알 수 있는데,
		// 이게 밑에 있는 것만 외우면 된다.
		// Runnable run() 인자를 받지도 않고 반환도 하지 않는다
		// Consumer accept(p) 인자를 받는데 리턴x
		// Supplier get(); r 인자를 받지 않는데 리턴
		// Function apply(p); r 인자 하나 받아서 리턴	-- map이 Function
		// Predicate apply(p); boolean r 인자를 하나 받고 불린 리턴
	
		// 함수형 인터페이스 축약 -- 결국, 매우 명확하고, 당연한 것을 다 지워버리는 것이다. 클래스 지우기 -> 함수 이름 지우기 -> 파라미터 타입 지우기 -> 리턴 지우기 -> 괄호 지우기
		// Function fun = s -> "s"; // 한가지 헷갈렸던 것은 리턴 값이 리턴하겠다는 것이 명확해서 return 까지도 지워주는 것이다
	}
	
	private static void prepareSamples(){
		for(int i=0; i< memos.length; i++){
			memos[i] = new String(sample);
		}
	}
}
