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
												// String �� String �迭�� �ٲ�
							// String ���� Stream // ���� �ִ� ��� �ٲٱ�   // ��ȯ�ϴ� ������ �ϳ��ϳ��� ��Ƽ� ����Ʈ�� ����� �ش�
		List<String[]> list = Stream.of(memos).map(s->s.split(" ")).collect(Collectors.toList()); // �߰�ó���� ����ó���� ������ ��� ��Ʈ���� �帧�� ��Ȯ�� �� �� �ִ�
							// ��ȯ ���� stream   // �ű⿡ map �� �ϸ� �ٲ� ������ stream // collect ���� stream ��°� ��Ƽ� ����Ʈ�� ����� �ش�.
		for(String[] strings: list){
			System.out.print(Arrays.toString(strings));
		}
		// �̰� �翬�ϰ� �ܿ�� �����ؾ� �Ѵ�.
		// �ڱⰡ �޾ƾ� �ϴ� �Լ��� �������̽��� ������ �˰� �˾ƾ� ���� ������ �� �ִ��� �� �� �ִµ�,
		// �̰� �ؿ� �ִ� �͸� �ܿ�� �ȴ�.
		// Runnable run() ���ڸ� ������ �ʰ� ��ȯ�� ���� �ʴ´�
		// Consumer accept(p) ���ڸ� �޴µ� ����x
		// Supplier get(); r ���ڸ� ���� �ʴµ� ����
		// Function apply(p); r ���� �ϳ� �޾Ƽ� ����	-- map�� Function
		// Predicate apply(p); boolean r ���ڸ� �ϳ� �ް� �Ҹ� ����
	
		// �Լ��� �������̽� ��� -- �ᱹ, �ſ� ��Ȯ�ϰ�, �翬�� ���� �� ���������� ���̴�. Ŭ���� ����� -> �Լ� �̸� ����� -> �Ķ���� Ÿ�� ����� -> ���� ����� -> ��ȣ �����
		// Function fun = s -> "s"; // �Ѱ��� �򰥷ȴ� ���� ���� ���� �����ϰڴٴ� ���� ��Ȯ�ؼ� return ������ �����ִ� ���̴�
	}
	
	private static void prepareSamples(){
		for(int i=0; i< memos.length; i++){
			memos[i] = new String(sample);
		}
	}
}
