import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda2 {

	static String sample ="Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray = sample.split(" ");
		System.out.printf("strArray.length : %d", strArray.length);
		System.out.println();
		Stream.of(strArray).map(s->s+"").forEach(System.out::print);
		System.out.println();
		// 이렇게 해도 원본 데이터에 변화가 없다. 변화된 모습을 저장하고 싶다면 collect 해 주면 된다
		Stream.of(strArray)	// 배열은 스트림 객체(직렬화된 데이터)로 변환해준다
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.map(s->s+" ").map(s->s.toUpperCase())
				.filter(s->s.contains(","))
				.parallel()		// 병렬 연산
				.forEach(System.out::print);
		System.out.println();
		
		Stream<String> stream = Arrays.stream(strArray);
		// 자기가 가진 데이터를 하나씩 내보내기 때문에 스트림이다
		// 연산에는 중간연산과 최종연산이 있는데, 중간연산은 map, filter 와 같이 중간에 처리해 주는 것
		// 최종연산은 마지막에 만들어진 데이터(전처리 완료된 연산)를 하나씩 출력해주거나, 데이터베이스에 넣어주거나 따로 컬렉션에 넣어주거나 한다
		// Rx 는 바로 이것을위한 것이다. 이런 베이터 처리. 다만 여기는 일련의 데이터를 다 만들어 두었다면 Rx 는 publisher와 subscriber 가 있어서
		// 데이터를 조금씩 받아볼 수 있다.
		// 스트림을 이용하지 않는다면 for, if 문을 복잡하게 만들어 줘야 한다.
		// 스트림을 해 주느 이유가 데이터 처리를 위해서이다. 이게 가장 중요하다.
		// 이제 스트림이 무엇인지 조금 알 수 있다. 
		// 예를 들어 내가 만든 메모 db 에서 원하는 글자의 개수만 구한다든지 이런 것을 쉽게 해 줄 수 있다.
		
//		IntStream intStream = IntStream.of(new int[]{1,2,3,4,5});
//		IntSummaryStatistics istatics = intStream.summaryStatistics();
//		istatics.getMax(); // 이런거 할수 있음
		
		Stream.of(strArray)
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.map(s->s+" ").map(s->s.toUpperCase())
		.filter(s->s.contains(","))
		.parallel()		// 병렬 연산
		.forEach(System.out::print);
		System.out.println();
	
	}
	
	private static String reverseCharsequence(String s){
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1; i>=0; i++){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	

}
