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
		// �̷��� �ص� ���� �����Ϳ� ��ȭ�� ����. ��ȭ�� ����� �����ϰ� �ʹٸ� collect �� �ָ� �ȴ�
		Stream.of(strArray)	// �迭�� ��Ʈ�� ��ü(����ȭ�� ������)�� ��ȯ���ش�
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.map(s->s+" ").map(s->s.toUpperCase())
				.filter(s->s.contains(","))
				.parallel()		// ���� ����
				.forEach(System.out::print);
		System.out.println();
		
		Stream<String> stream = Arrays.stream(strArray);
		// �ڱⰡ ���� �����͸� �ϳ��� �������� ������ ��Ʈ���̴�
		// ���꿡�� �߰������ ���������� �ִµ�, �߰������� map, filter �� ���� �߰��� ó���� �ִ� ��
		// ���������� �������� ������� ������(��ó�� �Ϸ�� ����)�� �ϳ��� ������ְų�, �����ͺ��̽��� �־��ְų� ���� �÷��ǿ� �־��ְų� �Ѵ�
		// Rx �� �ٷ� �̰������� ���̴�. �̷� ������ ó��. �ٸ� ����� �Ϸ��� �����͸� �� ����� �ξ��ٸ� Rx �� publisher�� subscriber �� �־
		// �����͸� ���ݾ� �޾ƺ� �� �ִ�.
		// ��Ʈ���� �̿����� �ʴ´ٸ� for, if ���� �����ϰ� ����� ��� �Ѵ�.
		// ��Ʈ���� �� �ִ� ������ ������ ó���� ���ؼ��̴�. �̰� ���� �߿��ϴ�.
		// ���� ��Ʈ���� �������� ���� �� �� �ִ�. 
		// ���� ��� ���� ���� �޸� db ���� ���ϴ� ������ ������ ���Ѵٵ��� �̷� ���� ���� �� �� �� �ִ�.
		
//		IntStream intStream = IntStream.of(new int[]{1,2,3,4,5});
//		IntSummaryStatistics istatics = intStream.summaryStatistics();
//		istatics.getMax(); // �̷��� �Ҽ� ����
		
		Stream.of(strArray)
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.map(s->s+" ").map(s->s.toUpperCase())
		.filter(s->s.contains(","))
		.parallel()		// ���� ����
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
